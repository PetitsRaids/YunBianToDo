package com.raids.yunbiantodo.support.utils

import android.widget.Toast
import com.raids.yunbiantodo.MyApplication

fun toast(resId: Int) {
    Toast.makeText(MyApplication.context, resId, Toast.LENGTH_SHORT).show()
}