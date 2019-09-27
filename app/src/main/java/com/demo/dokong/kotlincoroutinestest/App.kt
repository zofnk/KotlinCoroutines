package com.demo.dokong.kotlincoroutinestest

import android.app.Application
import android.util.Log
import com.amitshekhar.DebugDB
import com.facebook.stetho.Stetho

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-27. 11:54
 */
class App : Application() {

    companion object {
        lateinit var ctx: Application
        fun context() = ctx
    }

    override fun onCreate() {
        super.onCreate()
        ctx = this
        Stetho.initializeWithDefaults(this)
        Log.e("DOKONG", "DOKONG SQLite_DEBUG_URL : " + DebugDB.getAddressLog())
    }


}