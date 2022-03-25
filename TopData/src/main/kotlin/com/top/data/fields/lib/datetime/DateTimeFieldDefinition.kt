package com.top.data.fields.lib.datetime

import com.top.data.fields.IFieldDefinition
import com.top.data.models.common.localization.TimeZoneType
import java.util.*

/**
 * TODO
 * 1. 日期的最小值和最大值也需要考虑边界值的情况
 * 2. 还应考虑日期的最大值和最小值
 * 3. 日期完全有可能是历史时间
 * 4. 日期是否应该表示一段时间
 * 5. 日期是否应该表示时间
 * 6. 如何仅表达时间范围，而完全不包含日期
 */
data class DateTimeFieldDefinition(
    /**
     * 是否强制要求有值
     */
    override val isRequired: Boolean?,

    /**
     * 缺省默认值
     */
    override val defaultValue: DateTimeFieldData?,

    /**
     * 最小日期
     */
    val min: Date?,

    /**
     * 最大日期
     */
    val max: Date?,

    /**
     * 日期范围类型
     */
    val rangeType: DateTimeRangeType?,

    /**
     * 时区类型
     */
    val zone: TimeZoneType?,

    /**
     * 日期格式
     */
    val format: String?
) : IFieldDefinition<DateTimeFieldData>