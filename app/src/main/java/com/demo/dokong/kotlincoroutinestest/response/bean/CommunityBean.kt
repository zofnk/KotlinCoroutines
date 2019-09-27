package com.demo.dokong.kotlincoroutinestest.response.bean

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-26. 11:43
 */
data class CommunityBean(
    val Content: String,
    val DisplayScore: Int,
    val Id: Int,
    val IsTop: Int,
    val Likes: Int,
    val NickName: String,
    val ReplyCount: Int,
    val ScoreDescription: String,
    val Type: Int,
    val TypeId: Int,
    val TypeReplyCount: Int,
    val TypeTitle: String,
    val Uid: Int,
    val UidLikes: Boolean,
    val UpdateTime: String,
    val UrlList: List<String>,
    val UserImg: String
)