package com.demo.dokong.kotlincoroutinestest.response

import com.demo.dokong.kotlincoroutinestest.response.bean.BaseListResponse
import com.demo.dokong.kotlincoroutinestest.response.bean.BaseResponse
import com.demo.dokong.kotlincoroutinestest.response.bean.CommunityBean
import com.demo.dokong.kotlincoroutinestest.response.bean.CommunityBean2
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-26. 11:40
 */
interface RequestService {

    @GET(RequestUrl.COMMUNITY_LIST)
    suspend fun getCommunityList(
        @Query("uid") uid: Int,
        @Query("pageIndex") page: Int,
        @Query("pageSize") size: Int
    ): BaseResponse<BaseListResponse<CommunityBean>>

    @GET(RequestUrl.COMMUNITY_LIST)
    suspend fun getCommunityList2(
        @Query("uid") uid: Int,
        @Query("pageIndex") page: Int,
        @Query("pageSize") size: Int
    ): BaseResponse<BaseListResponse<CommunityBean2>>
}