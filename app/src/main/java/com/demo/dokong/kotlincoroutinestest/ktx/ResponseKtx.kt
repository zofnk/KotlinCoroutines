package com.demo.dokong.kotlincoroutinestest.ktx

import com.demo.dokong.kotlincoroutinestest.response.ApiException
import com.demo.dokong.kotlincoroutinestest.response.bean.BaseAccountResponse
import com.demo.dokong.kotlincoroutinestest.response.bean.BaseResponse

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-26. 17:04
 */
fun <T> BaseResponse<T>.isSuccess() = Code == 0

fun <T> BaseAccountResponse<T>.isSuccess() = StateCode == 1

fun <T> BaseResponse<T>.payloadCommon() =
    apply { if (!isSuccess()) throw ApiException(code = Code, msg = Message) }

fun <T> BaseResponse<BaseAccountResponse<T>>.payloadAccount() =
    Data.apply { if (isSuccess()) throw ApiException(code = StateCode, msg = Message) }