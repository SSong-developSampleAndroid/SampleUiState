package com.ssong_develop.sampleuistate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ssong_develop.sampleuistate.databinding.ActivityMain2Binding
import com.ssong_develop.sampleuistate.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    val viewModel = ViewModelProvider.NewInstanceFactory.instance.create(Main2ViewModel::class.java)

    private lateinit var binding : ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMain2Binding>(this,R.layout.activity_main2)
        binding.apply {
            vm = viewModel
            lifecycleOwner = this@MainActivity2
        }

        binding.edt1.doOnTextChanged { text, start, before, count ->
            viewModel.updateId(text.toString())
        }

        binding.edt2.doOnTextChanged { text, start, before, count ->
            viewModel.updatePassword(text.toString())
        }
    }
}
