package com.demo.dokong.kotlincoroutinestest.response.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-27. 15:47
 */
@Entity(tableName = "responses_cache")
data class ResponseCacheBean(
    @PrimaryKey
    var url: String,

    @ColumnInfo(name = "request_time")
    var time: String,

    @ColumnInfo(name = "response")
    val result: String
)