package com.demo.dokong.kotlincoroutinestest.ui

import android.app.Application
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.demo.dokong.kotlincoroutinestest.comm.BaseViewModel
import com.demo.dokong.kotlincoroutinestest.dao.AppDatabase
import com.demo.dokong.kotlincoroutinestest.ktx.loge
import com.demo.dokong.kotlincoroutinestest.ktx.request
import com.demo.dokong.kotlincoroutinestest.response.RequestUrl
import com.demo.dokong.kotlincoroutinestest.response.RetrofitClient.apiServer
import com.demo.dokong.kotlincoroutinestest.response.bean.*
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDateTime

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-26. 13:23
 */
class MainViewModel(application: Application) : BaseViewModel(application) {

    val data = ObservableField<String>("Hello?")
    val content = ObservableField<CommunityBean>()
    private val mainRepo by lazy { MainRepository() }

    init {
//        data.set("来自DB \n ${mainRepo.getCommunityListByDatabase()}")
    }

    fun requestCommunity() {
        request(onStart = {},
            onRequest = {
                val id = mainRepo.getCommunityList(page = 1).List[0].Id
                mainRepo.getCommunityList(page = id)
            },
            onSuccess = { data.set(it.List[0].Content) },
            onError = {},
            onComplete = {})
    }

    fun requestCommunity2() {
        content.get()?.Content = "he???"
        request(
            onRequest = { mainRepo.getCommunityListError(0, 1, 10) },
            onStart = { data.set("loading...") },
            onSuccess = { data.set(it.toString()) },
            onError = { e -> data.set("dokong : ${e.message}") })
    }
}