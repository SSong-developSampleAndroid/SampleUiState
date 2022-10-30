package com.ssong_develop.sampleuistate

import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.databinding.BindingAdapter

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("changeIdText")
    fun changeText(view : EditText, viewModel: Main2ViewModel) {
        view.doOnTextChanged { text, start, before, count ->
            viewModel.updateId(text.toString())
        }
    }

    @JvmStatic
    @BindingAdapter("changePasswordText")
    fun changePasswordText(view: EditText, viewModel: Main2ViewModel) {
        view.doOnTextChanged { text, start, before, count ->
            viewModel.updatePassword(text.toString())
        }
    }
}