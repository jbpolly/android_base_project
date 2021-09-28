package com.mysticraccoon.baseandroid.examples.activity

import android.view.LayoutInflater
import com.mysticraccoon.baseandroid.base.activity_fragment.BaseActivityMVVM
import com.mysticraccoon.baseandroid.databinding.ActivityBaseActivityMvvmBinding
import com.mysticraccoon.baseandroid.examples.viewmodel.ExampleActivityBaseAndroidViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ExampleActivityMVVMKoin: BaseActivityMVVM<ActivityBaseActivityMvvmBinding>() {

    override val viewModel: ExampleActivityBaseAndroidViewModel by viewModel()

    override fun onCreateBinding(inflater: LayoutInflater): ActivityBaseActivityMvvmBinding {
        return ActivityBaseActivityMvvmBinding.inflate(inflater)
    }



}