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


    private val _userAge = mutableStateOf(0)
    val userAge: State<Int> = _userAge

    private val _userHeight = mutableStateOf(0)
    val userHeight: State<Int> = _userHeight

    private val _userGender = mutableStateOf("")
    val userGender: State<String> = _userGender



    fun join() {
        viewModelScope.launch {
            joinUseCase()
        }
    }

    fun updateUserAge(age:Int){
        _userAge.value=age
    }
    fun updateUserHeight(height: Int){
        _userHeight.value=height
    }
    fun updateUserGender(gender: String){
        _userGender.value=gender
    }


}