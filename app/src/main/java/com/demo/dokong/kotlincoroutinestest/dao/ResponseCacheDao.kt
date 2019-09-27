package com.demo.dokong.kotlincoroutinestest.dao

import androidx.room.*
import com.demo.dokong.kotlincoroutinestest.response.bean.ResponseCacheBean

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-27. 15:50
 */
@Dao
interface ResponseCacheDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertResponse(resp: ResponseCacheBean)

    @Query("SELECT * FROM responses_cache WHERE url = :url")
    fun queryResponse(url: String): ResponseCacheBean

    @Update
    fun upgradeResponse(resp: ResponseCacheBean)
}