package com.demo.dokong.kotlincoroutinestest.response.bean

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-26. 11:59
 */
data class BaseResponse<T>(
    val Code: Int,
    val Message: String,
    val Data: T
)