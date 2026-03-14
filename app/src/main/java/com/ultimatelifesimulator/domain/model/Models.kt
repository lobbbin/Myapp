package com.ultimatelifesimulator.domain.model

data class Trait(
    val id: Long = 0,
    val name: String,
    val description: String,
    val isPositive: Boolean,
    val isNegative: Boolean = false,
    val statModifiers: Map<String, Int> = emptyMap()
)

data class Skill(
    val id: Long = 0,
    val name: String,
    val category: SkillCategory,
    val level: Int = 0,
    val xp: Int = 0
)

enum class SkillCategory {
    SOCIAL,
    COMBAT,
    INTELLECTUAL,
    PHYSICAL,
    CRIMINAL,
    PROFESSIONAL,
    CREATIVE,
    CRAFTS
}

data class Location(
    override val id: Long = 0,
    val name: String,
    val type: LocationType,
    val region: String,
    val description: String = "",
    val population: Int = 0,
    val securityLevel: Int = 50,
    val prosperity: Int = 50
) : GameEntity

enum class LocationType {
    PALACE,
    CASTLE,
    COURT,
    NOBLE_ESTATE,
    SLUMS,
    PRISON,
    POLICE_STATION,
    HOSPITAL,
    BANK,
    CHURCH,
    UNIVERSITY,
    LIBRARY,
    MARKETPLACE,
    SHOP,
    FACTORY,
    OFFICE,
    COURTHOUSE,
    RESTAURANT,
    NIGHTCLUB,
    GYM,
    PARK,
    MILITARY_BASE,
    GOVERNMENT_BUILDING,
    CITY_HALL,
    SCHOOL,
    HOMELESS_SHELTER
}

data class Faction(
    override val id: Long = 0,
    val name: String,
    val type: FactionType,
    val power: Int = 50,
    val opinionOfPlayer: Int = 0,
    val description: String = ""
) : GameEntity

enum class FactionType {
    ROYAL,
    NOBLE,
    RELIGIOUS,
    MILITARY,
    MERCHANT,
    CRIMINAL,
    POLITICAL,
    LABOR,
    MEDIA
}

data class Relationship(
    override val id: Long = 0,
    val characterId: Long,
    val targetCharacterId: Long,
    val type: RelationshipType,
    val score: Int = 0,
    val trust: Int = 50,
    val fear: Int = 0,
    val respect: Int = 50,
    val loyalty: Int = 50,
    val debt: Int = 0
) : GameEntity

enum class RelationshipType {
    PARENT,
    CHILD,
    SIBLING,
    SPOUSE,
    LOVER,
    FRIEND,
    ENEMY,
    MENTOR,
    PROTÉGÉ,
    EMPLOYER,
    EMPLOYEE,
    COLLEAGUE,
    NEIGHBOR,
    GANG_MEMBER,
    CELLMATE
}

data class Item(
    override val id: Long = 0,
    val name: String,
    val category: ItemCategory,
    val value: Double = 0.0,
    val weight: Double = 0.0,
    val quantity: Int = 1,
    val isEquipped: Boolean = false,
    val condition: Int = 100
) : GameEntity

enum class ItemCategory {
    CURRENCY,
    FOOD,
    DRINK,
    CLOTHING,
    WEAPON,
    TOOL,
    BOOK,
    DOCUMENT,
    DRUG,
    MEDICAL_SUPPLY,
    ELECTRONIC,
    FURNITURE,
    VEHICLE,
    REAL_ESTATE,
    ART,
    JEWELRY,
    GIFT,
    CONTRABAND
}

data class GameEvent(
    override val id: Long = 0,
    val title: String,
    val description: String,
    val category: EventCategory,
    val choices: List<EventChoice>,
    val triggerConditions: String = "",
    val isRandom: Boolean = true,
    val weight: Int = 50
) : GameEntity

data class EventChoice(
    val text: String,
    val successChance: Int = 100,
    val effects: List<String> = emptyList(),
    val requiredStats: Map<String, Int> = emptyMap()
)

enum class EventCategory {
    ROYALTY,
    POLITICS,
    CRIME,
    BUSINESS,
    CAREER,
    RELATIONSHIP,
    HEALTH,
    RANDOM
}

data class HealthRecord(
    override val id: Long = 0,
    val characterId: Long,
    val type: HealthType,
    val severity: Int,
    val isChronic: Boolean = false,
    val isTreated: Boolean = false,
    val notes: String = ""
) : GameEntity

enum class HealthType {
    INJURY,
    ILLNESS,
    MENTAL_HEALTH,
    ADDICTION
}

data class GameState(
    override val id: Long = 0,
    val characterId: Long,
    val savedAt: Long = System.currentTimeMillis(),
    val gameYear: Int = 1,
    val gameMonth: Int = 1,
    val gameDay: Int = 1,
    val turnNumber: Int = 0,
    val isAutoSave: Boolean = false
) : GameEntity
