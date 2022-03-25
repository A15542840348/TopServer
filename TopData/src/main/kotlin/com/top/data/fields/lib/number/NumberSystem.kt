package com.top.data.fields.lib.number

import com.google.gson.annotations.SerializedName

/**
 * 数值的进制类型
 *
 * TODO
 * 1. 是否要支持任意进制？至少是10以下的进制
 */
enum class NumberSystem {
    /**
     * 二进制
     */
    @SerializedName("bin")
    BIN,

    /**
     * 八进制
     */
    @SerializedName("oct")
    OCT,

    /**
     * 十进制
     */
    @SerializedName("dec")
    DEC,

    /**
     * 十六进制
     */
    @SerializedName("hex")
    HEX,
}