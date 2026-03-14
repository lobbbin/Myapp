package com.ultimatelifesimulator.data.repository;

import com.ultimatelifesimulator.data.local.dao.LocationDao;
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
public final class LocationRepositoryImpl_Factory implements Factory<LocationRepositoryImpl> {
  private final Provider<LocationDao> locationDaoProvider;

  public LocationRepositoryImpl_Factory(Provider<LocationDao> locationDaoProvider) {
    this.locationDaoProvider = locationDaoProvider;
  }

  @Override
  public LocationRepositoryImpl get() {
    return newInstance(locationDaoProvider.get());
  }

  public static LocationRepositoryImpl_Factory create(Provider<LocationDao> locationDaoProvider) {
    return new LocationRepositoryImpl_Factory(locationDaoProvider);
  }

  public static LocationRepositoryImpl newInstance(LocationDao locationDao) {
    return new LocationRepositoryImpl(locationDao);
  }
}
