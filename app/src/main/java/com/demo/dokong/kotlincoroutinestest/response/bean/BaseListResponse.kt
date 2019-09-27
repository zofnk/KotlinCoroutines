package com.demo.dokong.kotlincoroutinestest.response.bean

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-26. 13:08
 */
data class BaseListResponse<D>(
    val List: List<D>,
    val TotalCount: Int,
    val TotalPage: Int
)