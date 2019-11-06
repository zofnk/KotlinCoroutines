package com.demo.dokong.kotlincoroutinestest.ktx

import com.demo.dokong.kotlincoroutinestest.response.ApiException
import com.demo.dokong.kotlincoroutinestest.response.bean.BaseAccountResponse
import com.demo.dokong.kotlincoroutinestest.response.bean.BaseResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hjq.toast.ToastUtils
import okhttp3.ResponseBody

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-26. 17:04
 */
fun <T> BaseResponse<T>.isSuccess() = Code == 0

fun <T> BaseAccountResponse<T>.isSuccess() = StateCode == 1

//第一层转换 如果code=0 抛异常进入TryCatch
fun <T> BaseResponse<T>.payloadCommon() =
    apply {
        if (!isSuccess()) throw ApiException(code = Code, msg = Message)
    }.Data
