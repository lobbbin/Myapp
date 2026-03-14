package com.ultimatelifesimulator.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String = "Player",
    val age: Int = 18,
    val gender: String = "Male",
    val birthDay: Int = 1,
    val birthMonth: Int = 1,
    val birthYear: Int = 1000,
    val health: Int = 100,
    val energy: Int = 100,
    val stress: Int = 0,
    val charisma: Int = 50,
    val intellect: Int = 50,
    val cunning: Int = 50,
    val violence: Int = 50,
    val stealth: Int = 50,
    val perception: Int = 50,
    val willpower: Int = 50,
    val reputation: Int = 0,
    val wealth: Double = 1000.0,
    val piety: Int = 50,
    val loyalty: Int = 50,
    val addiction: Int = 0,
    val heat: Int = 0,
    val education: Int = 50,
    val streetCred: Int = 0,
    val nobleStanding: Int = 0,
    val politicalCapital: Int = 0,
    val lifePath: String = "NONE",
    val currentLocationId: Long = 1,
    val gameYear: Int = 1,
    val gameDay: Int = 1,
    val gameMonth: Int = 1
)

@Entity(tableName = "traits")
data class TraitEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val description: String,
    val isPositive: Boolean,
    val isNegative: Boolean = false,
    val statModifiers: String = "" // JSON string
)

@Entity(tableName = "skills")
data class SkillEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val category: String,
    val level: Int = 0,
    val xp: Int = 0,
    val characterId: Long
)

@Entity(tableName = "locations")
data class LocationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val type: String,
    val region: String,
    val description: String = "",
    val population: Int = 0,
    val securityLevel: Int = 50,
    val prosperity: Int = 50
)

@Entity(tableName = "factions")
data class FactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val type: String,
    val power: Int = 50,
    val opinionOfPlayer: Int = 0,
    val description: String = ""
)

@Entity(tableName = "relationships")
data class RelationshipEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val characterId: Long,
    val targetCharacterId: Long,
    val type: String,
    val score: Int = 0,
    val trust: Int = 50,
    val fear: Int = 0,
    val respect: Int = 50,
    val loyalty: Int = 50,
    val debt: Int = 0
)

@Entity(tableName = "items")
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val category: String,
    val value: Double = 0.0,
    val weight: Double = 0.0,
    val quantity: Int = 1,
    val isEquipped: Boolean = false,
    val condition: Int = 100,
    val characterId: Long
)

@Entity(tableName = "game_events")
data class GameEventEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val description: String,
    val category: String,
    val choices: String = "", // JSON string
    val triggerConditions: String = "",
    val isRandom: Boolean = true,
    val weight: Int = 50
)

@Entity(tableName = "health_records")
data class HealthRecordEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val characterId: Long,
    val type: String,
    val severity: Int,
    val isChronic: Boolean = false,
    val isTreated: Boolean = false,
    val notes: String = ""
)

@Entity(tableName = "game_states")
data class GameStateEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val characterId: Long,
    val savedAt: Long = System.currentTimeMillis(),
    val gameYear: Int = 1,
    val gameMonth: Int = 1,
    val gameDay: Int = 1,
    val turnNumber: Int = 0,
    val isAutoSave: Boolean = false
)
