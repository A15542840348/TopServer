package com.top.data.models.common

data class Pageable(
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
    val sort: Sort,
)
