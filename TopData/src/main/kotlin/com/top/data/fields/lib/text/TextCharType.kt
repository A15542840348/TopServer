package com.top.data.fields.lib.text

import com.google.gson.annotations.SerializedName

/**
 * 文本输入类型
 */
enum class TextCharType {
    /**
     * 数值
     */
    @SerializedName("1")
    NUMBER,

    /**
     * 字母
     */
    @SerializedName("2")
    LETTER,
}