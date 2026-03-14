package com.ultimatelifesimulator.di

import android.content.Context
import androidx.room.Room
import com.ultimatelifesimulator.data.local.GameDatabase
import com.ultimatelifesimulator.data.local.dao.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideGameDatabase(
        @ApplicationContext context: Context
    ): GameDatabase {
        return Room.databaseBuilder(
            context,
            GameDatabase::class.java,
            GameDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideCharacterDao(database: GameDatabase): CharacterDao {
        return database.characterDao()
    }

    @Provides
    @Singleton
    fun provideTraitDao(database: GameDatabase): TraitDao {
        return database.traitDao()
    }

    @Provides
    @Singleton
    fun provideSkillDao(database: GameDatabase): SkillDao {
        return database.skillDao()
    }

    @Provides
    @Singleton
    fun provideLocationDao(database: GameDatabase): LocationDao {
        return database.locationDao()
    }

    @Provides
    @Singleton
    fun provideFactionDao(database: GameDatabase): FactionDao {
        return database.factionDao()
    }

    @Provides
    @Singleton
    fun provideRelationshipDao(database: GameDatabase): RelationshipDao {
        return database.relationshipDao()
    }

    @Provides
    @Singleton
    fun provideItemDao(database: GameDatabase): ItemDao {
        return database.itemDao()
    }

    @Provides
    @Singleton
    fun provideGameEventDao(database: GameDatabase): GameEventDao {
        return database.gameEventDao()
    }

    @Provides
    @Singleton
    fun provideHealthRecordDao(database: GameDatabase): HealthRecordDao {
        return database.healthRecordDao()
    }

    @Provides
    @Singleton
    fun provideGameStateDao(database: GameDatabase): GameStateDao {
        return database.gameStateDao()
    }
}
