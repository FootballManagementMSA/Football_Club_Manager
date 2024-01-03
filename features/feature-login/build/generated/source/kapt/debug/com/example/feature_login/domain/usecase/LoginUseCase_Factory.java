package com.example.feature_login.domain.usecase;

import com.example.core.datasource.UserDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class LoginUseCase_Factory implements Factory<LoginUseCase> {
  private final Provider<UserDataSource> userDataSourceProvider;

  public LoginUseCase_Factory(Provider<UserDataSource> userDataSourceProvider) {
    this.userDataSourceProvider = userDataSourceProvider;
  }

  @Override
  public LoginUseCase get() {
    return newInstance(userDataSourceProvider.get());
  }

  public static LoginUseCase_Factory create(Provider<UserDataSource> userDataSourceProvider) {
    return new LoginUseCase_Factory(userDataSourceProvider);
  }

  public static LoginUseCase newInstance(UserDataSource userDataSource) {
    return new LoginUseCase(userDataSource);
  }
}
