package com.top.data.models.common

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum

/**
 * 头像数据
 */
@DynamoDBDocument
class AvatarData()
{
    /**
     * 头像类型
     */
    @get:DynamoDBTypeConvertedEnum()
    lateinit var type: AvatarDataType

    /**
     * 图片
     */
    var imageId: String? = null

    /**
     * 文本
     */
    var text: String? = null

    /**
     * Emoji
     */
    var emoji: String? = null
}