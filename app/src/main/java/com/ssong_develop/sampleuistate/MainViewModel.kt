package com.ssong_develop.sampleuistate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class MainViewModel : ViewModel() {

    var idState = MutableStateFlow("")

    var passwordState = MutableStateFlow("")

    val enableState = combine(
        idState,
        passwordState
    ) { id, password ->
        id.length in 1..10 && password.length in 2..10
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = false
    )
}