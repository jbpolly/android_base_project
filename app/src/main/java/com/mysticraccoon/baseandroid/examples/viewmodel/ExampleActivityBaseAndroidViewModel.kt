package com.mysticraccoon.baseandroid.examples.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ExampleActivityBaseAndroidViewModel(private val app: Application): AndroidViewModel(app){



    @Suppress("UNCHECKED_CAST")
    class StatisticsViewModelFactory (
        private val app: Application
    ) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>) =
            (ExampleActivityBaseAndroidViewModel(app) as T)
    }

}

