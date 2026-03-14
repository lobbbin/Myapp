package com.ultimatelifesimulator.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ultimatelifesimulator.data.local.dao.*
import com.ultimatelifesimulator.data.local.entity.*

@Database(
    entities = [
        CharacterEntity::class,
        TraitEntity::class,
        SkillEntity::class,
        LocationEntity::class,
        FactionEntity::class,
        RelationshipEntity::class,
        ItemEntity::class,
        GameEventEntity::class,
        HealthRecordEntity::class,
        GameStateEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class GameDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun traitDao(): TraitDao
    abstract fun skillDao(): SkillDao
    abstract fun locationDao(): LocationDao
    abstract fun factionDao(): FactionDao
    abstract fun relationshipDao(): RelationshipDao
    abstract fun itemDao(): ItemDao
    abstract fun gameEventDao(): GameEventDao
    abstract fun healthRecordDao(): HealthRecordDao
    abstract fun gameStateDao(): GameStateDao
    
    companion object {
        const val DATABASE_NAME = "ultimate_life_simulator_db"
    }
}
