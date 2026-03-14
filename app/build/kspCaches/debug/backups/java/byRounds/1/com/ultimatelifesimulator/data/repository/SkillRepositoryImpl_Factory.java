package com.ultimatelifesimulator.data.repository;

import com.ultimatelifesimulator.data.local.dao.SkillDao;
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
public final class SkillRepositoryImpl_Factory implements Factory<SkillRepositoryImpl> {
  private final Provider<SkillDao> skillDaoProvider;

  public SkillRepositoryImpl_Factory(Provider<SkillDao> skillDaoProvider) {
    this.skillDaoProvider = skillDaoProvider;
  }

  @Override
  public SkillRepositoryImpl get() {
    return newInstance(skillDaoProvider.get());
  }

  public static SkillRepositoryImpl_Factory create(Provider<SkillDao> skillDaoProvider) {
    return new SkillRepositoryImpl_Factory(skillDaoProvider);
  }

  public static SkillRepositoryImpl newInstance(SkillDao skillDao) {
    return new SkillRepositoryImpl(skillDao);
  }
}
