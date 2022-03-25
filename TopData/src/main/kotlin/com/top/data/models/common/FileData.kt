package com.top.data.models.common

import java.util.*

/**
 * 文件数据
 */
data class FileData(
    /**
     * 文件 ID
     */
    val id: String,

    /**
     * 文件名称
     */
    val name: String?,

    /**
     * 文件大小
     */
    val length: Long,

    /**
     * 文件的 URL
     */
    val url: String,

    /**
     * 文件创建者ID
     */
    val creatorId: String,

    /**
     * 文件被创建的时间
     */
    val createdTime: Date,
)
