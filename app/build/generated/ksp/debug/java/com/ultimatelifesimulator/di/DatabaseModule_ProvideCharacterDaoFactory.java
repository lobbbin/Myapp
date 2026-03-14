package com.ultimatelifesimulator.di;

import com.ultimatelifesimulator.data.local.GameDatabase;
import com.ultimatelifesimulator.data.local.dao.CharacterDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class DatabaseModule_ProvideCharacterDaoFactory implements Factory<CharacterDao> {
  private final Provider<GameDatabase> databaseProvider;

  public DatabaseModule_ProvideCharacterDaoFactory(Provider<GameDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public CharacterDao get() {
    return provideCharacterDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideCharacterDaoFactory create(
      Provider<GameDatabase> databaseProvider) {
    return new DatabaseModule_ProvideCharacterDaoFactory(databaseProvider);
  }

  public static CharacterDao provideCharacterDao(GameDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideCharacterDao(database));
  }
}
