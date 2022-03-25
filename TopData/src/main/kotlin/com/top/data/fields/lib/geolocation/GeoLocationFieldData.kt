package com.top.data.fields.lib.geolocation

import com.top.data.fields.IFieldData

data class GeoLocationFieldData(
    /**
     * 纬度
     */
    val latitude: Int?,

    /**
     * 经度
     */
    val longitude: Int?,

    /**
     * 地图放大倍数
     */
    val zoom: Int?
) : IFieldData