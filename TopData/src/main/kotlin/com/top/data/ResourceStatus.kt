package com.top.data

import com.google.gson.annotations.SerializedName

/**
 * 资源状态
 */
enum class ResourceStatus {
    /**
     * 活跃状态
     */
    @SerializedName("1")
    ACTIVE,

    /**
     * 已被锁定
     *
     * 仅可以被读取，但不可以被更新
     */
    @SerializedName("2")
    LOCKED,

    /**
     * 已被回收
     *
     * 不可以被读取，也不可以被更新
     */
    @SerializedName("3")
    RECYCLED,

    /**
     * 已被删除
     *
     * 资源已从系统中删除，不可以查看、更新或引用，也不可以被恢复。
     */
    @SerializedName("4")
    DELETED;
}
