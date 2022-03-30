package com.top.data.models.common

/**
 * 排序数据
 */
data class Sort(
    /**
     * 排序方向
     */
    val direction: SortDirection,

    /**
     * 排序优先级
     */
    val orderBy: List<String>,
)
