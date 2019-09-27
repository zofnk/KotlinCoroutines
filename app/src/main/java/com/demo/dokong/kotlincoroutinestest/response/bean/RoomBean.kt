package com.demo.dokong.kotlincoroutinestest.response.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-27. 11:15
 */
@Entity(tableName = "testRoom")
data class RoomBean(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var uid: Int = 0,

    @ColumnInfo(name = "chName")
    var name: String = "",

    var age: Int = 0,

    @Ignore
    var desc: String = "",

    var address: String = ""
)