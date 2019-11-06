package com.demo.dokong.kotlincoroutinestest.response.bean

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-9-26. 11:43
 */
data class CommunityBean2(
    var DisplayScore: Int,
    var IsTop: Int,
    var Likes: Int,
    var ReplyCount: Int,
    var ScoreDescription: String,
    var Type: Int,
    var TypeId: Int,
    var TypeReplyCount: Int,
    var TypeTitle: String,
    var Uid: Int,
    var UidLikes: Boolean,
    var UpdateTime: String,
    var UrlList: List<String>,
    var UserImg: String
) : BaseObservable() {

    @get:Bindable
    var NickName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.nickName)
        }

    @get:Bindable
    var Content: String = "hey"
        set(value) {
            field = value
            notifyPropertyChanged(BR.content)
        }

    @get:Bindable
    var Id: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.id)
        }
}