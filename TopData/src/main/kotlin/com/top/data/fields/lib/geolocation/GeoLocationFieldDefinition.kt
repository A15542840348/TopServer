package com.top.data.fields.lib.geolocation

import com.top.data.fields.IFieldDefinition

/**
 * 地理位置
 *
 * TODO：
 * 1. 地理位置和行政位置限定以及划分方式
 */
data class GeoLocationFieldDefinition(
    /**
     * 是否强制要求有值
     */
    override val isRequired: Boolean?,

    /**
     * 缺省值或默认值
     */
    override val defaultValue: GeoLocationFieldData?,

    /**
     * 最小纬度
     */
    val minLatitude: Int?,

    /**
     * 最大纬度
     */
    val maxLatitude: Int?,

    /**
     * 最小经度
     */
    val minLongitude: Int?,

    /**
     * 最大经度
     */
    val maxLongitude: Int?,
) : IFieldDefinition<GeoLocationFieldData>

