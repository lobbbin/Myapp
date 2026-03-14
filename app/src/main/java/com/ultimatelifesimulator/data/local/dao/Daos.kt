package com.ultimatelifesimulator.data.local.dao

import androidx.room.*
import com.ultimatelifesimulator.data.local.entity.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {
    @Query("SELECT * FROM characters WHERE id = :id")
    suspend fun getCharacterById(id: Long): CharacterEntity?
    
    @Query("SELECT * FROM characters LIMIT 1")
    fun getCurrentCharacter(): Flow<CharacterEntity?>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: CharacterEntity): Long
    
    @Update
    suspend fun updateCharacter(character: CharacterEntity)
    
    @Delete
    suspend fun deleteCharacter(character: CharacterEntity)
    
    @Query("DELETE FROM characters")
    suspend fun deleteAllCharacters()
}

@Dao
interface TraitDao {
    @Query("SELECT * FROM traits")
    fun getAllTraits(): Flow<List<TraitEntity>>
    
    @Query("SELECT * FROM traits WHERE isPositive = 1")
    fun getPositiveTraits(): Flow<List<TraitEntity>>
    
    @Query("SELECT * FROM traits WHERE isNegative = 1")
    fun getNegativeTraits(): Flow<List<TraitEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrait(trait: TraitEntity): Long
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTraits(traits: List<TraitEntity>)
    
    @Delete
    suspend fun deleteTrait(trait: TraitEntity)
}

@Dao
interface SkillDao {
    @Query("SELECT * FROM skills WHERE characterId = :characterId")
    fun getSkillsForCharacter(characterId: Long): Flow<List<SkillEntity>>
    
    @Query("SELECT * FROM skills WHERE characterId = :characterId AND category = :category")
    fun getSkillsByCategory(characterId: Long, category: String): Flow<List<SkillEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSkill(skill: SkillEntity): Long
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSkills(skills: List<SkillEntity>)
    
    @Update
    suspend fun updateSkill(skill: SkillEntity)
    
    @Delete
    suspend fun deleteSkill(skill: SkillEntity)
}

@Dao
interface LocationDao {
    @Query("SELECT * FROM locations")
    fun getAllLocations(): Flow<List<LocationEntity>>
    
    @Query("SELECT * FROM locations WHERE id = :id")
    suspend fun getLocationById(id: Long): LocationEntity?
    
    @Query("SELECT * FROM locations WHERE region = :region")
    fun getLocationsByRegion(region: String): Flow<List<LocationEntity>>
    
    @Query("SELECT * FROM locations WHERE type = :type")
    fun getLocationsByType(type: String): Flow<List<LocationEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(location: LocationEntity): Long
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocations(locations: List<LocationEntity>)
    
    @Update
    suspend fun updateLocation(location: LocationEntity)
    
    @Delete
    suspend fun deleteLocation(location: LocationEntity)
}

@Dao
interface FactionDao {
    @Query("SELECT * FROM factions")
    fun getAllFactions(): Flow<List<FactionEntity>>
    
    @Query("SELECT * FROM factions WHERE id = :id")
    suspend fun getFactionById(id: Long): FactionEntity?
    
    @Query("SELECT * FROM factions WHERE type = :type")
    fun getFactionsByType(type: String): Flow<List<FactionEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFaction(faction: FactionEntity): Long
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFactions(factions: List<FactionEntity>)
    
    @Update
    suspend fun updateFaction(faction: FactionEntity)
    
    @Delete
    suspend fun deleteFaction(faction: FactionEntity)
}

@Dao
interface RelationshipDao {
    @Query("SELECT * FROM relationships WHERE characterId = :characterId")
    fun getRelationshipsForCharacter(characterId: Long): Flow<List<RelationshipEntity>>
    
    @Query("SELECT * FROM relationships WHERE characterId = :characterId AND type = :type")
    fun getRelationshipsByType(characterId: Long, type: String): Flow<List<RelationshipEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRelationship(relationship: RelationshipEntity): Long
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRelationships(relationships: List<RelationshipEntity>)
    
    @Update
    suspend fun updateRelationship(relationship: RelationshipEntity)
    
    @Delete
    suspend fun deleteRelationship(relationship: RelationshipEntity)
}

@Dao
interface ItemDao {
    @Query("SELECT * FROM items WHERE characterId = :characterId")
    fun getItemsForCharacter(characterId: Long): Flow<List<ItemEntity>>
    
    @Query("SELECT * FROM items WHERE characterId = :characterId AND category = :category")
    fun getItemsByCategory(characterId: Long, category: String): Flow<List<ItemEntity>>
    
    @Query("SELECT * FROM items WHERE characterId = :characterId AND isEquipped = 1")
    fun getEquippedItems(characterId: Long): Flow<List<ItemEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: ItemEntity): Long
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items: List<ItemEntity>)
    
    @Update
    suspend fun updateItem(item: ItemEntity)
    
    @Delete
    suspend fun deleteItem(item: ItemEntity)
}

@Dao
interface GameEventDao {
    @Query("SELECT * FROM game_events")
    fun getAllEvents(): Flow<List<GameEventEntity>>
    
    @Query("SELECT * FROM game_events WHERE category = :category")
    fun getEventsByCategory(category: String): Flow<List<GameEventEntity>>
    
    @Query("SELECT * FROM game_events WHERE isRandom = 1 ORDER BY RANDOM() LIMIT 1")
    suspend fun getRandomEvent(): GameEventEntity?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvent(event: GameEventEntity): Long
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvents(events: List<GameEventEntity>)
    
    @Delete
    suspend fun deleteEvent(event: GameEventEntity)
}

@Dao
interface HealthRecordDao {
    @Query("SELECT * FROM health_records WHERE characterId = :characterId")
    fun getHealthRecordsForCharacter(characterId: Long): Flow<List<HealthRecordEntity>>
    
    @Query("SELECT * FROM health_records WHERE characterId = :characterId AND type = :type")
    fun getHealthRecordsByType(characterId: Long, type: String): Flow<List<HealthRecordEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHealthRecord(record: HealthRecordEntity): Long
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHealthRecords(records: List<HealthRecordEntity>)
    
    @Update
    suspend fun updateHealthRecord(record: HealthRecordEntity)
    
    @Delete
    suspend fun deleteHealthRecord(record: HealthRecordEntity)
}

@Dao
interface GameStateDao {
    @Query("SELECT * FROM game_states ORDER BY savedAt DESC LIMIT 1")
    fun getLatestGameState(): Flow<GameStateEntity?>
    
    @Query("SELECT * FROM game_states WHERE isAutoSave = 0 ORDER BY savedAt DESC LIMIT 5")
    fun getSavedGames(): Flow<List<GameStateEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGameState(gameState: GameStateEntity): Long
    
    @Delete
    suspend fun deleteGameState(gameState: GameStateEntity)
    
    @Query("DELETE FROM game_states WHERE id = :id")
    suspend fun deleteGameStateById(id: Long)
}
