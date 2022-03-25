package com.top.data.models.common

/**
 * 头像数据
 */
data class AvatarData(
    /**
     * 头像类型
     */
    val type: com.top.data.models.common.AvatarDataType,

    /**
     * 图片
     */
    val imageId: String?,

    /**
     * 文本
     */
    val text: String?,

    /**
     * Emoji
     */
    val emoji: String?,
)