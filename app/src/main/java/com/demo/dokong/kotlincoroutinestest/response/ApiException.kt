package com.demo.dokong.kotlincoroutinestest.response

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-26. 17:06
 */
class ApiException(val code: Int, val msg: String) : RuntimeException()