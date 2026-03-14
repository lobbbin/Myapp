package com.ultimatelifesimulator.di;

import com.ultimatelifesimulator.data.local.GameDatabase;
import com.ultimatelifesimulator.data.local.dao.HealthRecordDao;
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
public final class DatabaseModule_ProvideHealthRecordDaoFactory implements Factory<HealthRecordDao> {
  private final Provider<GameDatabase> databaseProvider;

  public DatabaseModule_ProvideHealthRecordDaoFactory(Provider<GameDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public HealthRecordDao get() {
    return provideHealthRecordDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideHealthRecordDaoFactory create(
      Provider<GameDatabase> databaseProvider) {
    return new DatabaseModule_ProvideHealthRecordDaoFactory(databaseProvider);
  }

  public static HealthRecordDao provideHealthRecordDao(GameDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideHealthRecordDao(database));
  }
}
