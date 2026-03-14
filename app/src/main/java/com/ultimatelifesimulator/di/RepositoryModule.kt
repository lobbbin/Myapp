package com.ultimatelifesimulator.di

import com.ultimatelifesimulator.data.repository.*
import com.ultimatelifesimulator.domain.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCharacterRepository(
        characterRepositoryImpl: CharacterRepositoryImpl
    ): CharacterRepository

    @Binds
    @Singleton
    abstract fun bindTraitRepository(
        traitRepositoryImpl: TraitRepositoryImpl
    ): TraitRepository

    @Binds
    @Singleton
    abstract fun bindSkillRepository(
        skillRepositoryImpl: SkillRepositoryImpl
    ): SkillRepository

    @Binds
    @Singleton
    abstract fun bindLocationRepository(
        locationRepositoryImpl: LocationRepositoryImpl
    ): LocationRepository

    @Binds
    @Singleton
    abstract fun bindFactionRepository(
        factionRepositoryImpl: FactionRepositoryImpl
    ): FactionRepository

    @Binds
    @Singleton
    abstract fun bindRelationshipRepository(
        relationshipRepositoryImpl: RelationshipRepositoryImpl
    ): RelationshipRepository

    @Binds
    @Singleton
    abstract fun bindGameEventRepository(
        gameEventRepositoryImpl: GameEventRepositoryImpl
    ): GameEventRepository
}
