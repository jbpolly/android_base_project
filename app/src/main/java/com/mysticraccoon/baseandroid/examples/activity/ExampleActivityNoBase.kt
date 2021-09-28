package com.mysticraccoon.baseandroid.examples.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mysticraccoon.baseandroid.BR
import com.mysticraccoon.baseandroid.databinding.ActivityBaseActivityMvvmBinding
import com.mysticraccoon.baseandroid.examples.viewmodel.ExampleActivityBaseAndroidViewModel
import com.mysticraccoon.baseandroid.examples.viewmodel.ExampleActivityViewModel

class ExampleActivityNoBase: AppCompatActivity() {

    private lateinit var binding: ActivityBaseActivityMvvmBinding
    private val viewModel: ExampleActivityViewModel by viewModels{
        ExampleActivityBaseAndroidViewModel.StatisticsViewModelFactory(application)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding = ActivityBaseActivityMvvmBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, viewModel)

    }


}