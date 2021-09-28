package com.mysticraccoon.baseandroid.examples.activity

import android.view.LayoutInflater
import com.mysticraccoon.baseandroid.base.activity_fragment.BaseActivityMVVM
import com.mysticraccoon.baseandroid.databinding.ActivityBaseActivityMvvmBinding

class ExampleActivityMVVM: BaseActivityMVVM<ActivityBaseActivityMvvmBinding>() {

    override fun onCreateBinding(inflater: LayoutInflater): ActivityBaseActivityMvvmBinding {
        return ActivityBaseActivityMvvmBinding.inflate(inflater)
    }
}