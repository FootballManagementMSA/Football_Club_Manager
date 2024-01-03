package com.example.feature_login.presentation.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/example/feature_login/presentation/viewmodel/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "loginUseCase", "Lcom/example/feature_login/domain/usecase/LoginUseCase;", "(Lcom/example/feature_login/domain/usecase/LoginUseCase;)V", "_userId", "Landroidx/compose/runtime/MutableState;", "", "_userPassword", "userId", "Landroidx/compose/runtime/State;", "getUserId", "()Landroidx/compose/runtime/State;", "userPassword", "getUserPassword", "login", "", "updateUserId", "updateUserPassword", "feature-login_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.feature_login.domain.usecase.LoginUseCase loginUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.String> _userId = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<java.lang.String> userId = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.String> _userPassword = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<java.lang.String> userPassword = null;
    
    @javax.inject.Inject
    public LoginViewModel(@org.jetbrains.annotations.NotNull
    com.example.feature_login.domain.usecase.LoginUseCase loginUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<java.lang.String> getUserId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<java.lang.String> getUserPassword() {
        return null;
    }
    
    public final void login() {
    }
    
    public final void updateUserId(@org.jetbrains.annotations.NotNull
    java.lang.String userId) {
    }
    
    public final void updateUserPassword(@org.jetbrains.annotations.NotNull
    java.lang.String userPassword) {
    }
}