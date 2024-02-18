package com.example.feature_join.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_join.domain.usecase.JoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JoinViewModel @Inject constructor(
    private val joinUseCase: JoinUseCase
) : ViewModel() {
    private val _userAge = mutableStateOf("")
    val userAge: State<String> = _userAge

    private val _userHeight = mutableStateOf("")
    val userHeight: State<String> = _userHeight

    private val _userGender = mutableStateOf("")
    val userGender: State<String> = _userGender

    private val _userName = mutableStateOf("")
    val userName: State<String> = _userName

    private val _selectedInfo = mutableStateOf("" to "")
    val selectedInfo: State<Pair<String,String>> get() =  _selectedInfo


    fun join() {
        viewModelScope.launch {
            joinUseCase()
        }
    }

    fun updateSelectedInfo(position: String = "",foot: String = ""){
        _selectedInfo.value = position to foot
    }

    fun updateUserAge(age:String){
        _userAge.value=age
    }
    fun updateUserHeight(height: String){
        _userHeight.value=height
    }
    fun updateUserGender(gender: String){
        _userGender.value=gender
    }
    fun updateUserName(name:String){
        _userName.value=name
    }


}