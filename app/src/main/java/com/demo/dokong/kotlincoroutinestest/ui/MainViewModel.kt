package com.demo.dokong.kotlincoroutinestest.ui

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import com.demo.dokong.kotlincoroutinestest.comm.BaseViewModel
import com.demo.dokong.kotlincoroutinestest.dao.AppDatabase
import com.demo.dokong.kotlincoroutinestest.dao.RoomHelper
import com.demo.dokong.kotlincoroutinestest.ktx.request
import com.demo.dokong.kotlincoroutinestest.response.RequestUrl
import com.demo.dokong.kotlincoroutinestest.response.bean.ResponseCacheBean
import com.google.gson.Gson

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-26. 13:23
 */
class MainViewModel(application: Application) : BaseViewModel(application) {

    val data = ObservableField<String>("Hello?")
    private val mainRepo by lazy { MainRepository() }

    init {
        data.set("来自DB \n ${mainRepo.getCommunityListByDatabase()}")
    }

    fun requestCommunity() {
        request(
            onRequest = { mainRepo.getCommunityList(0, 1, 10) },
            onStart = { data.set("loading...") },
            onSuccess = {
                data.set(it.Data.List.toString())

                val json = Gson().toJson(it)
                AppDatabase.instance
                    .getResponseDao()
                    .insertResponse(ResponseCacheBean(RequestUrl.COMMUNITY_LIST, "2019", json))
            },
            onError = { code, message -> data.set("异常 Code : $code  Message : $message") })
    }

    fun requestCommunity2() {
        request(
            onRequest = { mainRepo.getCommunityListError(0, 1, 10) },
            onStart = { data.set("loading...") },
            onSuccess = { data.set(it.Data.List.toString()) },
            onError = { code, message -> data.set("异常 Code : $code  Message : $message") })
    }
}