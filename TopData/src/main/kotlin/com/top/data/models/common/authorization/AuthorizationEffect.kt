package com.top.data.models.common.authorization

import com.google.gson.annotations.SerializedName

/**
 * 授权效果
 */
enum class AuthorizationEffect {
    /**
     * 未设置
     */
    @SerializedName("0")
    UNSET,

    /**
     * 允许
     */
    @SerializedName("1")
    ALLOW,

    /**
     * 拒绝
     */
    @SerializedName("2")
    DENY,
}
