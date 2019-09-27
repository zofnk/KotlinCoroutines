package com.demo.dokong.kotlincoroutinestest.comm

import com.demo.dokong.kotlincoroutinestest.response.bean.BaseResponse

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-27. 15:17
 */
open class BaseRepository {

    suspend fun <T : Any> request(req: suspend () -> BaseResponse<T>): BaseResponse<T> {
        return req.invoke()
    }

}