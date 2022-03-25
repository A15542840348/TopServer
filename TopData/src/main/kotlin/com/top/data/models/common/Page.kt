package com.top.data.models.common

/**
 * 分页对象
 */
data class Page<T>(
    /**
     * 总页数
     */
    val totalPages: Int,

    /**
     * 总元素数
     */
    val totalElements: Long,

    /**
     * 页码数
     */
    val pageNumber: Int,

    /**
     * 每页个数
     */
    val pageSize: Int,

    /**
     * 排序数据
     */
    val sort: com.top.data.models.common.Sort,

    /**
     * 元素列表
     */
    val data: List<T>
)
