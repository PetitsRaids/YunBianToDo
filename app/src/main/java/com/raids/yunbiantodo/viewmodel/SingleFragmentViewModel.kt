package com.raids.yunbiantodo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

class SingleFragmentViewModel(application: Application) : AndroidViewModel(application) {

    val isInputtingLive: MediatorLiveData<Boolean> = MediatorLiveData()


    fun setInputState(isInputting: Boolean) {
        isInputtingLive.value = isInputting
    }

}