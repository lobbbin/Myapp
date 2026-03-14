package com.ultimatelifesimulator.di;

import com.ultimatelifesimulator.data.local.GameDatabase;
import com.ultimatelifesimulator.data.local.dao.LocationDao;
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
public final class DatabaseModule_ProvideLocationDaoFactory implements Factory<LocationDao> {
  private final Provider<GameDatabase> databaseProvider;

  public DatabaseModule_ProvideLocationDaoFactory(Provider<GameDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public LocationDao get() {
    return provideLocationDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideLocationDaoFactory create(
      Provider<GameDatabase> databaseProvider) {
    return new DatabaseModule_ProvideLocationDaoFactory(databaseProvider);
  }

  public static LocationDao provideLocationDao(GameDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideLocationDao(database));
  }
}
