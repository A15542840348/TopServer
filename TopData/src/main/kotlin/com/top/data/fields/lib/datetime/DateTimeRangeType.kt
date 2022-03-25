package com.top.data.fields.lib.datetime

/**
 * 还有很多复杂的范围，比如：今天之后，今年之后，本世纪之后等等，明年之前等等
 */
enum class DateTimeRangeType {
    /**
     * 当前时间之前
     */
    BEFORE,

    /**
     * 当前时间之后
     */
    FUTURE,
}
