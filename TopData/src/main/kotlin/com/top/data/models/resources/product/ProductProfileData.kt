package com.top.data.models.resources.product

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument
import com.top.data.models.common.AvatarData

/**
 * 产品资源 信息
 */
@DynamoDBDocument
class ProductProfileData()
{
    /**
     * 产品名称
     */
    lateinit var name: String

    /**
     * 产品头像
     */
    lateinit var avatar: AvatarData

    /**
     * 产品描述
     */
    lateinit var description: String
}
