package com.top.data.models.common

import com.google.gson.annotations.SerializedName

enum class AvatarDataType {
    /**
     * 图片头像
     */
    @SerializedName("1")
    IMAGE,

    /**
     * 文本头像
     */
    @SerializedName("2")
    TEXT,

    /**
     * Emoji头像
     */
    @SerializedName("3")
    EMOJI,
}
