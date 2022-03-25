package com.top.data.models.common

/**
 * 区间数据
 */
data class RangeData<T>(
    /**
     * 最小值
     */
    val min: T,

    /**
     * 最大值
     */
    val max: T,
)