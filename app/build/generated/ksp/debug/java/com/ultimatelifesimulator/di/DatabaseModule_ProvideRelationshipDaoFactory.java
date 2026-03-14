package com.ultimatelifesimulator.di;

import com.ultimatelifesimulator.data.local.GameDatabase;
import com.ultimatelifesimulator.data.local.dao.RelationshipDao;
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
public final class DatabaseModule_ProvideRelationshipDaoFactory implements Factory<RelationshipDao> {
  private final Provider<GameDatabase> databaseProvider;

  public DatabaseModule_ProvideRelationshipDaoFactory(Provider<GameDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public RelationshipDao get() {
    return provideRelationshipDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideRelationshipDaoFactory create(
      Provider<GameDatabase> databaseProvider) {
    return new DatabaseModule_ProvideRelationshipDaoFactory(databaseProvider);
  }

  public static RelationshipDao provideRelationshipDao(GameDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideRelationshipDao(database));
  }
}
