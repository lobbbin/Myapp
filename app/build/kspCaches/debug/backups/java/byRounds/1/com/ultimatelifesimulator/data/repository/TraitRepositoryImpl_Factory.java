package com.ultimatelifesimulator.data.repository;

import com.ultimatelifesimulator.data.local.dao.TraitDao;
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
public final class TraitRepositoryImpl_Factory implements Factory<TraitRepositoryImpl> {
  private final Provider<TraitDao> traitDaoProvider;

  public TraitRepositoryImpl_Factory(Provider<TraitDao> traitDaoProvider) {
    this.traitDaoProvider = traitDaoProvider;
  }

  @Override
  public TraitRepositoryImpl get() {
    return newInstance(traitDaoProvider.get());
  }

  public static TraitRepositoryImpl_Factory create(Provider<TraitDao> traitDaoProvider) {
    return new TraitRepositoryImpl_Factory(traitDaoProvider);
  }

  public static TraitRepositoryImpl newInstance(TraitDao traitDao) {
    return new TraitRepositoryImpl(traitDao);
  }
}
