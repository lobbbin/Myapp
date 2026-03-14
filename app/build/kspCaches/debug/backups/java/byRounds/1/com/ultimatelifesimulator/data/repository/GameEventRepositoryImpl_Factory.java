package com.ultimatelifesimulator.data.repository;

import com.ultimatelifesimulator.data.local.dao.GameEventDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class GameEventRepositoryImpl_Factory implements Factory<GameEventRepositoryImpl> {
  private final Provider<GameEventDao> gameEventDaoProvider;

  public GameEventRepositoryImpl_Factory(Provider<GameEventDao> gameEventDaoProvider) {
    this.gameEventDaoProvider = gameEventDaoProvider;
  }

  @Override
  public GameEventRepositoryImpl get() {
    return newInstance(gameEventDaoProvider.get());
  }

  public static GameEventRepositoryImpl_Factory create(
      Provider<GameEventDao> gameEventDaoProvider) {
    return new GameEventRepositoryImpl_Factory(gameEventDaoProvider);
  }

  public static GameEventRepositoryImpl newInstance(GameEventDao gameEventDao) {
    return new GameEventRepositoryImpl(gameEventDao);
  }
}
