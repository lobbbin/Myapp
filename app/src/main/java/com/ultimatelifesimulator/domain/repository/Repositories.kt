package com.ultimatelifesimulator.domain.repository

import com.ultimatelifesimulator.data.local.entity.*
import com.ultimatelifesimulator.domain.model.*
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCurrentCharacter(): Flow<Character?>
    suspend fun getCharacterById(id: Long): Character?
    suspend fun createCharacter(character: Character): Long
    suspend fun updateCharacter(character: Character)
    suspend fun deleteCharacter(id: Long)
}

interface TraitRepository {
    fun getAllTraits(): Flow<List<Trait>>
    fun getPositiveTraits(): Flow<List<Trait>>
    fun getNegativeTraits(): Flow<List<Trait>>
    suspend fun addTrait(trait: Trait): Long
}

interface SkillRepository {
    fun getSkillsForCharacter(characterId: Long): Flow<List<Skill>>
    fun getSkillsByCategory(characterId: Long, category: SkillCategory): Flow<List<Skill>>
    suspend fun addSkill(skill: Skill, characterId: Long): Long
    suspend fun updateSkillXp(skillId: Long, xpGain: Int)
}

interface LocationRepository {
    fun getAllLocations(): Flow<List<Location>>
    fun getLocationsByRegion(region: String): Flow<List<Location>>
    fun getLocationsByType(type: LocationType): Flow<List<Location>>
    suspend fun getLocationById(id: Long): Location?
    suspend fun initializeDefaultLocations()
}

interface FactionRepository {
    fun getAllFactions(): Flow<List<Faction>>
    fun getFactionsByType(type: FactionType): Flow<List<Faction>>
    suspend fun getFactionById(id: Long): Faction?
    suspend fun updateFactionOpinion(factionId: Long, opinionChange: Int)
    suspend fun initializeDefaultFactions()
}

interface RelationshipRepository {
    fun getRelationshipsForCharacter(characterId: Long): Flow<List<Relationship>>
    fun getRelationshipsByType(characterId: Long, type: RelationshipType): Flow<List<Relationship>>
    suspend fun addRelationship(relationship: Relationship): Long
    suspend fun updateRelationshipScore(relationshipId: Long, scoreChange: Int)
}

interface ItemRepository {
    fun getItemsForCharacter(characterId: Long): Flow<List<Item>>
    fun getItemsByCategory(characterId: Long, category: ItemCategory): Flow<List<Item>>
    fun getEquippedItems(characterId: Long): Flow<List<Item>>
    suspend fun addItem(item: Item, characterId: Long): Long
    suspend fun updateItem(item: Item)
    suspend fun removeItem(itemId: Long)
}

interface GameEventRepository {
    fun getAllEvents(): Flow<List<GameEvent>>
    fun getEventsByCategory(category: EventCategory): Flow<List<GameEvent>>
    suspend fun getRandomEvent(): GameEvent?
    suspend fun initializeDefaultEvents()
}

interface HealthRecordRepository {
    fun getHealthRecordsForCharacter(characterId: Long): Flow<List<HealthRecord>>
    fun getHealthRecordsByType(characterId: Long, type: HealthType): Flow<List<HealthRecord>>
    suspend fun addHealthRecord(record: HealthRecord): Long
    suspend fun updateHealthRecord(record: HealthRecord)
}

interface GameStateRepository {
    fun getLatestGameState(): Flow<GameState?>
    fun getSavedGames(): Flow<List<GameState>>
    suspend fun saveGame(characterId: Long, isAutoSave: Boolean = false): Long
    suspend fun loadGame(gameStateId: Long): GameState?
    suspend fun deleteSave(gameStateId: Long)
}
