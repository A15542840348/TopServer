package com.top.data.models.resources.role

import com.google.gson.annotations.SerializedName

/**
 * 角色类型
 */
enum class RoleType {
    /**
     * 系统预置角色
     */
    @SerializedName("0")
    BUILT_IN,

    /**
     * 自定义角色
     */
    @SerializedName("1")
    CUSTOM,
}