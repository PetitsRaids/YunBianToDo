package com.raids.yunbiantodo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.raids.yunbiantodo.bean.ToDo

class MainFragmentViewModel(application: Application) : AndroidViewModel(application) {
    var data: LiveData<ToDo>? = null

}