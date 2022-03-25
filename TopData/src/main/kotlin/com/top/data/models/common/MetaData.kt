package com.top.data.models.common

import java.util.*

/**
 * 元数据
 */
data class MetaData(
    /**
     * 创建者ID
     */
    val createdByUserId: String,

    /**
     * 更新者ID
     */
    val updatedByUserId: String,

    /**
     * 创建时间
     */
    val createdTime: Date,

    /**
     * 更新时间
     */
    val updatedTime: Date,
)