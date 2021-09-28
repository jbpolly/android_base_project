package com.mysticraccoon.baseandroid.base.activity_fragment

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.mysticraccoon.baseandroid.BR

abstract class BaseActivityMVVM <B : ViewBinding> : AppCompatActivity() {

    // Inner mutable binding
    private var _binding: B? = null

    // Binding used by subclasses
    val binding: B
        get() = _binding ?: throw IllegalStateException(
            "Trying to access the binding outside of the view lifecycle."
        )


    protected open val viewModel: ViewModel? = null

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindView(layoutInflater).apply { setContentView(root) }

    }

    abstract fun onCreateBinding(inflater: LayoutInflater): B

    @CallSuper
    protected open fun bindView(inflater: LayoutInflater): B {
        return onCreateBinding(inflater).apply {
            if (this is ViewDataBinding) {
                lifecycleOwner = this@BaseActivityMVVM
                viewModel?.let { setVariable(BR.viewModel, it) }
            }
        }
    }
}