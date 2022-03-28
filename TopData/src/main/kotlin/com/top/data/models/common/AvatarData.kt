package com.top.data.models.common

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum

/**
 * 头像数据
 */
@DynamoDBDocument
data class AvatarData(
    /**
     * 头像类型
     */
    @get:DynamoDBTypeConvertedEnum()
    val type: AvatarDataType,

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