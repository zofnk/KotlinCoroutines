package com.demo.dokong.kotlincoroutinestest.dao

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.demo.dokong.kotlincoroutinestest.App
import com.demo.dokong.kotlincoroutinestest.response.bean.ResponseCacheBean
import com.demo.dokong.kotlincoroutinestest.response.bean.RoomBean

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-27. 11:23
 */
@Database(entities = [RoomBean::class, ResponseCacheBean::class], version = 4)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getRoomDao(): RoomDao
    abstract fun getResponseDao(): ResponseCacheDao

    companion object{
        private const val DB_NAME = "room_db"
        val instance = Single.sin
    }

    private object Single {
        val sin = Room
            .databaseBuilder(App.context(), AppDatabase::class.java, DB_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}