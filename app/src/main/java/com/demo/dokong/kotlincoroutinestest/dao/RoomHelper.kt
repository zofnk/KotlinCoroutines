package com.demo.dokong.kotlincoroutinestest.dao

import android.content.Context
import androidx.room.Room

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-27. 11:44
 */
class RoomHelper private constructor() {
    companion object {
        private const val DB_NAME = "room_db"
        val instance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            RoomHelper()
        }
    }

    var database: AppDatabase? = null

    fun setup(ctx: Context) {
        database = Room
            .databaseBuilder(ctx.applicationContext, AppDatabase::class.java, DB_NAME)
            .build()
    }
}