package com.demo.dokong.kotlincoroutinestest.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demo.dokong.kotlincoroutinestest.response.bean.RoomBean

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-27. 11:32
 */
//@Dao
interface RoomDao {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRoom(bean: RoomBean)

//    @Query("SELECT * FROM testRoom WHERE id = :id")
    fun queryRoom(id: Int): RoomBean

}