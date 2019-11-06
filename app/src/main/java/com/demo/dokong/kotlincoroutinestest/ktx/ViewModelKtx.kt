package com.demo.dokong.kotlincoroutinestest.ktx

import android.util.Log
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
    showToast: Boolean = true,
    onRequest: suspend () -> T,
    onStart: (() -> Unit)? = null,
    onSuccess: suspend (T) -> Unit,
    onError: suspend (Exception) -> Unit = { _ -> },
    onComplete: (() -> Unit)? = null
) {
    viewModelScope.launch {
        withContext(Dispatchers.Main) { onStart?.invoke() }
        try {
            val result = withContext(Dispatchers.IO) { return@withContext onRequest.invoke() }
            withContext(Dispatchers.Main) { onSuccess.invoke(result) }
        } catch (e: Exception) {
            e.printStackTrace()
            var message = ""
            var code = 0
            when (e) {
                is SocketTimeoutException -> if (showToast) toast("网络连接超时,请重试")
                is ConnectException -> "ConnectException"
                is UnknownHostException -> "UnknownHostException"
                is EOFException -> "EOFException"
                is JsonSyntaxException -> "JsonSyntaxException"
                is TimeoutException -> "TimeoutException"
                is SocketException -> "SocketException"
                is HttpException -> {
                }
                is ApiException -> {
                    message = e.msg
                    code = e.code
                }
                else -> "OTHER"
            }
            withContext(Dispatchers.Main) {
                Log.e("DOKONG", "异常 Code : $code  Message : $message")
                onError.invoke(e)
            }
        } finally {
            //延时1秒结束,避免loading动画执行不完整
            kotlinx.coroutines.delay(1000)
            withContext(Dispatchers.Main) { onComplete?.invoke() }
        }
    }
}