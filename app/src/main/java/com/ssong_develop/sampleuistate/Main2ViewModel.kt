package com.ssong_develop.sampleuistate

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class Main2ViewModel : ViewModel() {
    var uiState = MutableStateFlow(Main2UiState())

    fun updateId(id: String) {
        uiState.value = uiState.value.copy(id = id)
        updateButtonEnable()
    }

    fun updatePassword(password: String) {
        uiState.value = uiState.value.copy(password = password)
        updateButtonEnable()
    }

    private fun updateButtonEnable() {
        uiState.value = uiState.value.copy(
            buttonEnable = ((uiState.value.id.length in 1..10) && (uiState.value.password.length in 2..10))
        )
    }
}

data class Main2UiState(
    val id: String = "",
    val password: String = "",
    val buttonEnable: Boolean = false
)