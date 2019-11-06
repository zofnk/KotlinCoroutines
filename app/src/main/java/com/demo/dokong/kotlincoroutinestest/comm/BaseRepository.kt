package com.demo.dokong.kotlincoroutinestest.comm

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-27. 15:17
 */
open class BaseRepository {
    suspend fun <T : Any> request(req: suspend () -> T): T {
        return req.invoke()
    }
}