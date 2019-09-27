package com.demo.dokong.kotlincoroutinestest.response

import com.demo.dokong.kotlincoroutinestest.response.bean.BaseResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-26. 14:58
 */
suspend fun executeResponse(
    response: BaseResponse<Any>,
    successBlock: suspend CoroutineScope.() -> Unit,
    errorBlock: suspend CoroutineScope.() -> Unit
) {
    coroutineScope {
        if (response.Code != 0) {
            successBlock()
        } else {
            errorBlock()
        }
    }
}