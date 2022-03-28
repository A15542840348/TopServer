package com.top.data.models.common

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter
import java.util.*

/**
 * 元数据
 */
@DynamoDBDocument
class MetaData() {
    /**
     * 创建者ID
     */
    lateinit var createdByUserId: String

    /**
     * 更新者ID
     */
    lateinit var updatedByUserId: String

    /**
     * 创建时间
     */
    @get:DynamoDBAttribute(attributeName = "createdTime")
    @get:DynamoDBTypeConverted(converter =  LongToDateConverter::class)
    @set:DynamoDBAttribute(attributeName = "createdTime")
    lateinit var createdTime: Date

    /**
     * 更新时间
     */
    @get:DynamoDBAttribute(attributeName = "updatedTime")
    @get:DynamoDBTypeConverted(converter = LongToDateConverter::class)
    @set:DynamoDBAttribute(attributeName = "updatedTime")
    lateinit var updatedTime: Date
}

class LongToDateConverter : DynamoDBTypeConverter<Long?, Date?> {
    override fun convert(`object`: Date?): Long? {
        var awsItem: Long? = null
        try {
            if (`object` != null) {
                awsItem = `object`.time
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return awsItem
    }

    override fun unconvert(`object`: Long?): Date? {
        var item = Date()
        try {
            if (`object` != null) {
                item = Date(`object`)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return item
    }
}
