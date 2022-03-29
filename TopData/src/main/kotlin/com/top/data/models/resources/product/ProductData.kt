package com.top.data.models.resources.product

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum
import com.top.data.ResourceStatus
import com.top.data.ResourceType
import com.top.data.models.common.MetaData
import com.top.data.models.resources.IResourceData

/**
 * 产品（资源）
 */
@DynamoDBTable(tableName = "Product")
class ProductData(

) : IResourceData{
    /**
     * 产品ID
     */
    @get:DynamoDBHashKey(attributeName = "id")
    override lateinit var id: String

    /**
     * 所有者ID
     */
    @get:DynamoDBRangeKey(attributeName = "ownerId")
    override lateinit var ownerId: String

    /**
     * 所有者类型
     */
    @get:DynamoDBTypeConvertedEnum()
    override lateinit var ownerType: ResourceType

    /**
     * 产品概述
     */
    lateinit var profile: ProductProfileData

    /**
     * 产品状态
     */
    @get:DynamoDBTypeConvertedEnum()
    override lateinit var status: ResourceStatus

    /**
     * 元数据
     */
    override lateinit var meta: MetaData
}