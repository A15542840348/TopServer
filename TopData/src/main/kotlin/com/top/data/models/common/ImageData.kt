package com.top.data.models.common

import java.util.*

/**
 * 图片文件数据
 */
data class ImageData(
    /**
     * 图片 ID
     */
    val id: String,

    /**
     * 图片 名称
     */
    val name: String?,

    /**
     * 图片 大小
     */
    val length: Long,

    /**
     * 图片 的URL
     */
    val url: String,

    /**
     * 图片 创建者ID
     */
    val creatorId: String,

    /**
     * 图片 被创建的时间
     */
    val createdTime: Date,
)
