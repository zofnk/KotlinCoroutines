package com.demo.dokong.kotlincoroutinestest.ktx

import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.dokong.kotlincoroutinestest.response.ApiException
import com.google.gson.JsonSyntaxException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.EOFException
import java.net.ConnectException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-26. 15:16
 */
fun AndroidViewModel.toast(str: String) {
    if (str.isEmpty()) return
    Toast.makeText(getApplication(), str, Toast.LENGTH_SHORT).show()
}

fun <T> AndroidViewModel.request(
    onRequest: suspend () -> T,
    onStart: (() -> Unit)? = null,
    onSuccess: suspend (T) -> Unit,
    onError: suspend (Int, String) -> Unit,
    onComplete: (() -> Unit)? = null
) {
    viewModelScope.launch {
        withContext(Dispatchers.Main) { onStart?.invoke() }
        try {
            val result = withContext(Dispatchers.IO) { return@withContext onRequest.invoke() }
            withContext(Dispatchers.Main) { onSuccess.invoke(result) }
        } catch (e: Exception) {
            e.printStackTrace()
            var code = 0
            val message = when (e) {
                is SocketTimeoutException -> "SocketTimeoutException"
                is ConnectException -> "ConnectException"
                is UnknownHostException -> "UnknownHostException"
                is EOFException -> "EOFException"
                is JsonSyntaxException -> "JsonSyntaxException"
                is TimeoutException -> "TimeoutException"
                is SocketException -> "SocketException"
                is ApiException -> {
                    code = e.code
                    e.msg
                }
                is HttpException -> {
                    code = e.code()
                    e.message()
                }
                else -> "OTHER"
            }
            withContext(Dispatchers.Main) { onError.invoke(code, message) }
        } finally {
            //延时1秒结束,避免loading动画执行不完整
            kotlinx.coroutines.delay(1000)
            withContext(Dispatchers.Main) { onComplete?.invoke() }
        }
    }
}