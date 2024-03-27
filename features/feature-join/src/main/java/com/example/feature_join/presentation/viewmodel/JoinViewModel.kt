package com.example.feature_join.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.ResultState.JoinResult
import com.example.core.model.JoinModel
import com.example.feature_join.domain.usecase.JoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JoinViewModel @Inject constructor(
    private val joinUseCase: JoinUseCase
) : ViewModel() {


    private val _userId = mutableStateOf("")
    val userId: State<String> = _userId

    private val _userPassword = mutableStateOf("")
    val userPassword: State<String> = _userPassword

    private val _userPosition = mutableStateOf("")
    val userPosition: State<String> = _userPosition

    private val _userFoot = mutableStateOf("")
    val userFoot: State<String> = _userFoot

    private val _userAge = mutableStateOf("")
    val userAge: State<String> = _userAge

    private val _userHeight = mutableStateOf("")
    val userHeight: State<String> = _userHeight

    private val _userGender = mutableStateOf("")
    val userGender: State<String> = _userGender

    private val _userName = mutableStateOf("")
    val userName: State<String> = _userName


    private val _selectedInfo = mutableStateOf("" to "")
    val selectedInfo: State<Pair<String, String>> get() = _selectedInfo


    private val _JoinResult = MutableSharedFlow<JoinResult>(replay = 1)
    val JoinResult: SharedFlow<JoinResult> = _JoinResult.asSharedFlow()


    fun join() {
        viewModelScope.launch {

            Log.d("test_joinViewModel_join", "joinviewModel_join_function_test")


            val result = joinUseCase(
                JoinModel(
                    "18011771",
                    "chanhue467",
                    _userPosition.value,
                    _userFoot.value,
                    _userGender.value,
                    _userAge.value.toInt(),
                    _userHeight.value.toInt()
                )
            )
            _JoinResult.emit(result)
        }
    }


    fun updateSelectedInfo(position: String = "", foot: String = "") {
        _selectedInfo.value = position to foot
        if (position.isNotEmpty()) {
            _userPosition.value = position
        }
        if (foot.isNotEmpty()) {
            _userFoot.value = foot
        }
    }

    fun updateUserAge(age: String) {
        _userAge.value = age
    }

    fun updateUserHeight(height: String) {
        _userHeight.value = height
    }

    fun updateUserGender(gender: String) {
        _userGender.value = gender
    }

    fun updateUserName(name: String) {
        _userName.value = name
    }


}