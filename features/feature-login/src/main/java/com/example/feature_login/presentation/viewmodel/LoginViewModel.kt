package com.example.feature_login.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.LoginResult
import com.example.core.model.LoginModel
import com.example.feature_login.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    private val _userId = mutableStateOf("")
    val userId: State<String> = _userId

    private val _userPassword = mutableStateOf("")
    val userPassword: State<String> = _userPassword

    private val _loginResult = MutableStateFlow<LoginResult?>(null)
    val loginResult: StateFlow<LoginResult?> get() = _loginResult

    fun login() {
        viewModelScope.launch {
            _loginResult.value = loginUseCase(LoginModel(_userId.value, _userPassword.value))
        }
    }

    fun updateUserId(userId: String) {
        _userId.value = userId
    }

    fun updateUserPassword(userPassword: String) {
        _userPassword.value = userPassword
    }

}