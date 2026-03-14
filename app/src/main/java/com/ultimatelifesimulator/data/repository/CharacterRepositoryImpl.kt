package com.ultimatelifesimulator.data.repository

import com.ultimatelifesimulator.data.local.dao.*
import com.ultimatelifesimulator.data.local.entity.*
import com.ultimatelifesimulator.domain.model.*
import com.ultimatelifesimulator.domain.repository.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl @Inject constructor(
    private val characterDao: CharacterDao
) : CharacterRepository {
    
    override fun getCurrentCharacter(): Flow<Character?> {
        return characterDao.getCurrentCharacter().map { it?.toDomain() }
    }
    
    override suspend fun getCharacterById(id: Long): Character? {
        return characterDao.getCharacterById(id)?.toDomain()
    }
    
    override suspend fun createCharacter(character: Character): Long {
        return characterDao.insertCharacter(character.toEntity())
    }
    
    override suspend fun updateCharacter(character: Character) {
        characterDao.updateCharacter(character.toEntity())
    }
    
    override suspend fun deleteCharacter(id: Long) {
        characterDao.getCharacterById(id)?.let { characterDao.deleteCharacter(it) }
    }
    
    private fun CharacterEntity.toDomain() = Character(
        id = id,
        name = name,
        age = age,
        gender = gender,
        birthDay = birthDay,
        birthMonth = birthMonth,
        birthYear = birthYear,
        health = health,
        energy = energy,
        stress = stress,
        charisma = charisma,
        intellect = intellect,
        cunning = cunning,
        violence = violence,
        stealth = stealth,
        perception = perception,
        willpower = willpower,
        reputation = reputation,
        wealth = wealth,
        piety = piety,
        loyalty = loyalty,
        addiction = addiction,
        heat = heat,
        education = education,
        streetCred = streetCred,
        nobleStanding = nobleStanding,
        politicalCapital = politicalCapital,
        lifePath = LifePath.valueOf(lifePath),
        currentLocationId = currentLocationId,
        gameYear = gameYear,
        gameDay = gameDay,
        gameMonth = gameMonth
    )
    
    private fun Character.toEntity() = CharacterEntity(
        id = id,
        name = name,
        age = age,
        gender = gender,
        birthDay = birthDay,
        birthMonth = birthMonth,
        birthYear = birthYear,
        health = health,
        energy = energy,
        stress = stress,
        charisma = charisma,
        intellect = intellect,
        cunning = cunning,
        violence = violence,
        stealth = stealth,
        perception = perception,
        willpower = willpower,
        reputation = reputation,
        wealth = wealth,
        piety = piety,
        loyalty = loyalty,
        addiction = addiction,
        heat = heat,
        education = education,
        streetCred = streetCred,
        nobleStanding = nobleStanding,
        politicalCapital = politicalCapital,
        lifePath = lifePath.name,
        currentLocationId = currentLocationId,
        gameYear = gameYear,
        gameDay = gameDay,
        gameMonth = gameMonth
    )
}

@Singleton
class TraitRepositoryImpl @Inject constructor(
    private val traitDao: TraitDao
) : TraitRepository {
    
    override fun getAllTraits(): Flow<List<Trait>> {
        return traitDao.getAllTraits().map { list -> list.map { it.toDomain() } }
    }
    
    override fun getPositiveTraits(): Flow<List<Trait>> {
        return traitDao.getPositiveTraits().map { list -> list.map { it.toDomain() } }
    }
    
    override fun getNegativeTraits(): Flow<List<Trait>> {
        return traitDao.getNegativeTraits().map { list -> list.map { it.toDomain() } }
    }
    
    override suspend fun addTrait(trait: Trait): Long {
        return traitDao.insertTrait(trait.toEntity())
    }
    
    private fun TraitEntity.toDomain() = Trait(
        id = id,
        name = name,
        description = description,
        isPositive = isPositive,
        isNegative = isNegative,
        statModifiers = parseStatModifiers(statModifiers)
    )
    
    private fun Trait.toEntity() = TraitEntity(
        id = id,
        name = name,
        description = description,
        isPositive = isPositive,
        isNegative = isNegative,
        statModifiers = serializeStatModifiers(statModifiers)
    )
    
    private fun parseStatModifiers(json: String): Map<String, Int> {
        if (json.isBlank()) return emptyMap()
        return json.split(";")
            .filter { it.contains(":") }
            .associate { val parts = it.split(":"); parts[0] to parts[1].toInt() }
    }
    
    private fun serializeStatModifiers(modifiers: Map<String, Int>): String {
        return modifiers.entries.joinToString(";") { "${it.key}:${it.value}" }
    }
}

@Singleton
class SkillRepositoryImpl @Inject constructor(
    private val skillDao: SkillDao
) : SkillRepository {
    
    override fun getSkillsForCharacter(characterId: Long): Flow<List<Skill>> {
        return skillDao.getSkillsForCharacter(characterId).map { list -> list.map { it.toDomain() } }
    }
    
    override fun getSkillsByCategory(characterId: Long, category: SkillCategory): Flow<List<Skill>> {
        return skillDao.getSkillsByCategory(characterId, category.name).map { list -> list.map { it.toDomain() } }
    }
    
    override suspend fun addSkill(skill: Skill, characterId: Long): Long {
        return skillDao.insertSkill(skill.toEntity(characterId))
    }
    
    override suspend fun updateSkillXp(skillId: Long, xpGain: Int) {
        // Implementation would fetch, update, and save
    }
    
    private fun SkillEntity.toDomain() = Skill(
        id = id,
        name = name,
        category = SkillCategory.valueOf(category),
        level = level,
        xp = xp
    )
    
    private fun Skill.toEntity(characterId: Long) = SkillEntity(
        id = id,
        name = name,
        category = category.name,
        level = level,
        xp = xp,
        characterId = characterId
    )
}
