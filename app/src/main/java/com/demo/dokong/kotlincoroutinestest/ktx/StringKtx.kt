package com.demo.dokong.kotlincoroutinestest.ktx

import android.util.Log
import android.widget.Toast
import com.demo.dokong.kotlincoroutinestest.App

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-29. 10:13
 */
fun String.toaster() {
    if (isNotEmpty()) Toast.makeText(App.context(), this, Toast.LENGTH_SHORT).show()
}

fun String.loge() {
    Log.e("DOKONG", "DOKONG : $this")
}