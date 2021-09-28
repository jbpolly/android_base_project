package com.mysticraccoon.baseandroid.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel() {

    //used to control the loaders on the view
    val isLoading = MutableLiveData(false)

    fun launchLoading(
        context: CoroutineContext,
        loadStateLiveData: MutableLiveData<Boolean> = isLoading,
        block: suspend CoroutineScope.() -> Unit
    ) {
        //if there is an operation already loading with the same loadState controller then do not execute
        if (loadStateLiveData.value == true) return
        loadStateLiveData.value = true
        viewModelScope.launch(context) {
            block.invoke(this)
            loadStateLiveData.postValue(false)
        }
    }


}