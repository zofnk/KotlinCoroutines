package com.demo.dokong.kotlincoroutinestest.ktx

import com.demo.dokong.kotlincoroutinestest.comm.BaseRepository
import com.demo.dokong.kotlincoroutinestest.response.bean.BaseResponse
import com.google.gson.Gson

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-27. 16:55
 */
fun <T> BaseRepository.conver(json: String) = Gson()
    .fromJson<BaseResponse<T>>(json)

inline fun <reified T> Gson.fromJson(json: String): T = fromJson(json, T::class.java)