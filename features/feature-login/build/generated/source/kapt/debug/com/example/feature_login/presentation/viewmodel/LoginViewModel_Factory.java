package com.example.feature_login.presentation.viewmodel;

import com.example.feature_login.domain.usecase.LoginUseCase;
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
public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
  private final Provider<LoginUseCase> loginUseCaseProvider;

  public LoginViewModel_Factory(Provider<LoginUseCase> loginUseCaseProvider) {
    this.loginUseCaseProvider = loginUseCaseProvider;
  }

  @Override
  public LoginViewModel get() {
    return newInstance(loginUseCaseProvider.get());
  }

  public static LoginViewModel_Factory create(Provider<LoginUseCase> loginUseCaseProvider) {
    return new LoginViewModel_Factory(loginUseCaseProvider);
  }

  public static LoginViewModel newInstance(LoginUseCase loginUseCase) {
    return new LoginViewModel(loginUseCase);
  }
}
