package com.mysticraccoon.baseandroid.di.koin

import android.app.Application
import com.mysticraccoon.baseandroid.examples.viewmodel.ExampleActivityBaseAndroidViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { ExampleActivityBaseAndroidViewModel(get<Application>())  }

}