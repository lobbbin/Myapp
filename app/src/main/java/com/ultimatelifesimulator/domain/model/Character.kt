package com.ultimatelifesimulator.domain.model

interface GameEntity {
    val id: Long
}

data class Character(
    override val id: Long = 0,
    val name: String = "Player",
    val age: Int = 18,
    val gender: String = "Male",
    val birthDay: Int = 1,
    val birthMonth: Int = 1,
    val birthYear: Int = 1000,
    
    // Primary Stats (0-100)
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
    
    // Secondary Stats
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
    
    // Life Path
    val lifePath: LifePath = LifePath.NONE,
    
    // Location
    val currentLocationId: Long = 1,
    
    // Game Time
    val gameYear: Int = 1,
    val gameDay: Int = 1,
    val gameMonth: Int = 1
) : GameEntity

enum class LifePath {
    NONE,
    ROYALTY,
    POLITICS,
    CRIME,
    BUSINESS,
    CAREER
}
