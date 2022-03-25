package com.top.data.fields.lib.currency

import com.top.data.fields.IFieldDefinition
import java.math.BigDecimal

data class CurrencyFieldDefinition(
    /**
     * 是否强制要求有值
     */
    override val isRequired: Boolean?,

    /**
     * 缺省默认值
     */
    override val defaultValue: CurrencyFieldData?,

    /**
     * 闭区间最小值
     */
    val inclusiveMin: BigDecimal?,

    /**
     * 闭区间最大值
     */
    val inclusiveMax: BigDecimal?,

    /**
     * 开区间最小值
     */
    val exclusiveMin: BigDecimal?,

    /**
     * 开区间最大值
     */
    val exclusiveMax: BigDecimal?,

    /**
     * 货币取值类型
     */
    val rangeType: CurrencyRangeType?,

    /**
     * 小数位数
     *
     * 约束：
     * 1. 默认为
     * 2. 取值范围是 [0, 30]
     */
    val decimalPlaces: Int?,

    /**
     * 货币符号
     */
    val symbol: CurrencySymbol?,
) : IFieldDefinition<CurrencyFieldData>