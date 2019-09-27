package com.demo.dokong.kotlincoroutinestest.response.bean

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-27. 10:36
 */
data class BaseAccountResponse<D>(
    val StateCode: Int,
    val Message: String,
    val data: D
)