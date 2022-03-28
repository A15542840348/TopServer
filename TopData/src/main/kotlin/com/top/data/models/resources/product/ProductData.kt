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
data class ProductData(
    /**
     * 产品ID
     */
    @get:DynamoDBHashKey(attributeName = "id")
    override val id: String,

    /**
     * 产品所有者ID
     */
    @get:DynamoDBRangeKey(attributeName = "ownerId")
    override val ownerId: String,

    /**
     * 产品所有者类型
     */
    @get:DynamoDBTypeConvertedEnum()
    override val ownerType: ResourceType,

    /**
     * 产品概述
     */
    val profile: ProductProfileData,

    /**
     * 产品状态
     */
    @get:DynamoDBTypeConvertedEnum()
    override val status: ResourceStatus,

    /**
     * 元数据
     */
    override val meta: MetaData,
) : IResourceData
