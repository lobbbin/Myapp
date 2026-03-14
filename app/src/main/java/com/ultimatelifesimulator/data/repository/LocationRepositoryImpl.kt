package com.ultimatelifesimulator.data.repository

import com.ultimatelifesimulator.data.local.dao.*
import com.ultimatelifesimulator.data.local.entity.*
import com.ultimatelifesimulator.domain.model.*
import com.ultimatelifesimulator.domain.repository.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocationRepositoryImpl @Inject constructor(
    private val locationDao: LocationDao
) : LocationRepository {
    
    override fun getAllLocations(): Flow<List<Location>> {
        return locationDao.getAllLocations().map { list -> list.map { it.toDomain() } }
    }
    
    override fun getLocationsByRegion(region: String): Flow<List<Location>> {
        return locationDao.getLocationsByRegion(region).map { list -> list.map { it.toDomain() } }
    }
    
    override fun getLocationsByType(type: LocationType): Flow<List<Location>> {
        return locationDao.getLocationsByType(type.name).map { list -> list.map { it.toDomain() } }
    }
    
    override suspend fun getLocationById(id: Long): Location? {
        return locationDao.getLocationById(id)?.toDomain()
    }
    
    override suspend fun initializeDefaultLocations() {
        val existing = locationDao.getAllLocations().first()
        if (existing.isEmpty()) {
            val defaultLocations = listOf(
                LocationEntity(name = "Royal Palace", type = "PALACE", region = "Capital City", description = "The seat of royal power", population = 500, securityLevel = 90, prosperity = 100),
                LocationEntity(name = "Noble District", type = "NOBLE_ESTATE", region = "Capital City", description = "Home to the aristocracy", population = 2000, securityLevel = 80, prosperity = 90),
                LocationEntity(name = "Central Market", type = "MARKETPLACE", region = "Capital City", description = "Bustling trade hub", population = 5000, securityLevel = 60, prosperity = 70),
                LocationEntity(name = "The Slums", type = "SLUMS", region = "Capital City", description = "Poor neighborhood", population = 10000, securityLevel = 20, prosperity = 20),
                LocationEntity(name = "Royal Jail", type = "PRISON", region = "Capital City", description = "High security detention", population = 200, securityLevel = 95, prosperity = 30),
                LocationEntity(name = "Temple of Light", type = "CHURCH", region = "Capital City", description = "Main religious site", population = 1000, securityLevel = 70, prosperity = 80),
                LocationEntity(name = "Royal Academy", type = "UNIVERSITY", region = "Capital City", description = "Center of learning", population = 3000, securityLevel = 75, prosperity = 85),
                LocationEntity(name = "Town Square", type = "PARK", region = "Capital City", description = "Public gathering space", population = 0, securityLevel = 70, prosperity = 60),
                LocationEntity(name = "Blacksmith Guild", type = "SHOP", region = "Capital City", description = "Craftsmen workshop", population = 100, securityLevel = 65, prosperity = 50),
                LocationEntity(name = "Tavern", type = "RESTAURANT", region = "Capital City", description = "Drinks and gossip", population = 50, securityLevel = 50, prosperity = 40)
            )
            locationDao.insertLocations(defaultLocations)
        }
    }
    
    private fun LocationEntity.toDomain() = Location(
        id = id,
        name = name,
        type = LocationType.valueOf(type),
        region = region,
        description = description,
        population = population,
        securityLevel = securityLevel,
        prosperity = prosperity
    )
}

@Singleton
class FactionRepositoryImpl @Inject constructor(
    private val factionDao: FactionDao
) : FactionRepository {
    
    override fun getAllFactions(): Flow<List<Faction>> {
        return factionDao.getAllFactions().map { list -> list.map { it.toDomain() } }
    }
    
    override fun getFactionsByType(type: FactionType): Flow<List<Faction>> {
        return factionDao.getFactionsByType(type.name).map { list -> list.map { it.toDomain() } }
    }
    
    override suspend fun getFactionById(id: Long): Faction? {
        return factionDao.getFactionById(id)?.toDomain()
    }
    
    override suspend fun updateFactionOpinion(factionId: Long, opinionChange: Int) {
        factionDao.getFactionById(factionId)?.let { faction ->
            factionDao.updateFaction(faction.copy(opinionOfPlayer = (faction.opinionOfPlayer + opinionChange).coerceIn(-100, 100)))
        }
    }
    
    override suspend fun initializeDefaultFactions() {
        val existing = factionDao.getAllFactions().first()
        if (existing.isEmpty()) {
            val defaultFactions = listOf(
                FactionEntity(name = "Royal Family", type = "ROYAL", power = 100, description = "The ruling dynasty"),
                FactionEntity(name = "High Council", type = "NOBLE", power = 80, description = "King's advisors"),
                FactionEntity(name = "Merchant Guild", type = "MERCHANT", power = 70, description = "Trade organization"),
                FactionEntity(name = "Church of Light", type = "RELIGIOUS", power = 75, description = "Religious authority"),
                FactionEntity(name = "Royal Army", type = "MILITARY", power = 85, description = "Military forces"),
                FactionEntity(name = "The Black Hand", type = "CRIMINAL", power = 40, description = "Underground organization"),
                FactionEntity(name = "Farmers Union", type = "LABOR", power = 30, description = "Agricultural workers")
            )
            factionDao.insertFactions(defaultFactions)
        }
    }
    
    private fun FactionEntity.toDomain() = Faction(
        id = id,
        name = name,
        type = FactionType.valueOf(type),
        power = power,
        opinionOfPlayer = opinionOfPlayer,
        description = description
    )
}

@Singleton
class RelationshipRepositoryImpl @Inject constructor(
    private val relationshipDao: RelationshipDao
) : RelationshipRepository {
    
    override fun getRelationshipsForCharacter(characterId: Long): Flow<List<Relationship>> {
        return relationshipDao.getRelationshipsForCharacter(characterId).map { list -> list.map { it.toDomain() } }
    }
    
    override fun getRelationshipsByType(characterId: Long, type: RelationshipType): Flow<List<Relationship>> {
        return relationshipDao.getRelationshipsByType(characterId, type.name).map { list -> list.map { it.toDomain() } }
    }
    
    override suspend fun addRelationship(relationship: Relationship): Long {
        return relationshipDao.insertRelationship(relationship.toEntity())
    }
    
    override suspend fun updateRelationshipScore(relationshipId: Long, scoreChange: Int) {
        // Implementation would update the relationship
    }
    
    private fun RelationshipEntity.toDomain() = Relationship(
        id = id,
        characterId = characterId,
        targetCharacterId = targetCharacterId,
        type = RelationshipType.valueOf(type),
        score = score,
        trust = trust,
        fear = fear,
        respect = respect,
        loyalty = loyalty,
        debt = debt
    )
    
    private fun Relationship.toEntity() = RelationshipEntity(
        id = id,
        characterId = characterId,
        targetCharacterId = targetCharacterId,
        type = type.name,
        score = score,
        trust = trust,
        fear = fear,
        respect = respect,
        loyalty = loyalty,
        debt = debt
    )
}

@Singleton
class GameEventRepositoryImpl @Inject constructor(
    private val gameEventDao: GameEventDao
) : GameEventRepository {
    
    override fun getAllEvents(): Flow<List<GameEvent>> {
        return gameEventDao.getAllEvents().map { list -> list.map { it.toDomain() } }
    }
    
    override fun getEventsByCategory(category: EventCategory): Flow<List<GameEvent>> {
        return gameEventDao.getEventsByCategory(category.name).map { list -> list.map { it.toDomain() } }
    }
    
    override suspend fun getRandomEvent(): GameEvent? {
        return gameEventDao.getRandomEvent()?.toDomain()
    }
    
    override suspend fun initializeDefaultEvents() {
        val existing = gameEventDao.getAllEvents().first()
        if (existing.isEmpty()) {
            // Royalty Events
            val royaltyEvents = listOf(
                GameEventEntity(title = "Noble's Request", description = "A vassal approaches you requesting a tax break for their lands.", category = "ROYALTY", weight = 30),
                GameEventEntity(title = "Foreign Diplomat", description = "A diplomat from a neighboring kingdom arrives with an alliance proposal.", category = "ROYALTY", weight = 25),
                GameEventEntity(title = "Peasant Unrest", description = "Rumors of rebellion spread among the common folk.", category = "ROYALTY", weight = 20),
                GameEventEntity(title = "Assassination Plot", description = "Your spymaster reports a plot against your life.", category = "ROYALTY", weight = 15)
            )
            // Politics Events
            val politicsEvents = listOf(
                GameEventEntity(title = "Opposition Leak", description = "A scandalous email from your opponent has leaked to the press.", category = "POLITICS", weight = 30),
                GameEventEntity(title = "Town Hall", description = "A hostile voter challenges you on your policy positions.", category = "POLITICS", weight = 35),
                GameEventEntity(title = "Fundraiser", description = "A major donor wants to discuss their expectations.", category = "POLITICS", weight = 25),
                GameEventEntity(title = "Debate Prep", description = "Your team prepares for the upcoming debate.", category = "POLITICS", weight = 20)
            )
            // Crime Events
            val crimeEvents = listOf(
                GameEventEntity(title = "Police Contact", description = "A cop pulls you over for a routine check.", category = "CRIME", weight = 40),
                GameEventEntity(title = "Rival Gang", description = "A rival gang is encroaching on your territory.", category = "CRIME", weight = 25),
                GameEventEntity(title = "New Crew Member", description = "Someone wants to join your operation.", category = "CRIME", weight = 30),
                GameEventEntity(title = "Job Opportunity", description = "A potentially lucrative job has been presented to you.", category = "CRIME", weight = 35)
            )
            // Random Events
            val randomEvents = listOf(
                GameEventEntity(title = "Windfall", description = "You find some money on the street.", category = "RANDOM", weight = 50),
                GameEventEntity(title = "Accident", description = "You have a minor accident.", category = "RANDOM", weight = 30),
                GameEventEntity(title = "Meeting", description = "You run into an old acquaintance.", category = "RANDOM", weight = 40),
                GameEventEntity(title = "Opportunity", description = "A chance for advancement presents itself.", category = "RANDOM", weight = 35)
            )
            gameEventDao.insertEvents(royaltyEvents + politicsEvents + crimeEvents + randomEvents)
        }
    }
    
    private fun GameEventEntity.toDomain() = GameEvent(
        id = id,
        title = title,
        description = description,
        category = EventCategory.valueOf(category),
        choices = emptyList(),
        triggerConditions = triggerConditions,
        isRandom = isRandom,
        weight = weight
    )
}
