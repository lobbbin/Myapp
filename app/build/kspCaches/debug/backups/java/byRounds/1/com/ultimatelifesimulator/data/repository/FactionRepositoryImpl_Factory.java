package com.ultimatelifesimulator.data.repository;

import com.ultimatelifesimulator.data.local.dao.FactionDao;
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
public final class FactionRepositoryImpl_Factory implements Factory<FactionRepositoryImpl> {
  private final Provider<FactionDao> factionDaoProvider;

  public FactionRepositoryImpl_Factory(Provider<FactionDao> factionDaoProvider) {
    this.factionDaoProvider = factionDaoProvider;
  }

  @Override
  public FactionRepositoryImpl get() {
    return newInstance(factionDaoProvider.get());
  }

  public static FactionRepositoryImpl_Factory create(Provider<FactionDao> factionDaoProvider) {
    return new FactionRepositoryImpl_Factory(factionDaoProvider);
  }

  public static FactionRepositoryImpl newInstance(FactionDao factionDao) {
    return new FactionRepositoryImpl(factionDao);
  }
}
