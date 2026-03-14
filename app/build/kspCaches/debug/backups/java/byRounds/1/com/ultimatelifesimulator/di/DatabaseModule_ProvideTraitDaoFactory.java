package com.ultimatelifesimulator.di;

import com.ultimatelifesimulator.data.local.GameDatabase;
import com.ultimatelifesimulator.data.local.dao.TraitDao;
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
public final class DatabaseModule_ProvideTraitDaoFactory implements Factory<TraitDao> {
  private final Provider<GameDatabase> databaseProvider;

  public DatabaseModule_ProvideTraitDaoFactory(Provider<GameDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public TraitDao get() {
    return provideTraitDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideTraitDaoFactory create(
      Provider<GameDatabase> databaseProvider) {
    return new DatabaseModule_ProvideTraitDaoFactory(databaseProvider);
  }

  public static TraitDao provideTraitDao(GameDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideTraitDao(database));
  }
}
