package com.top.data.fields.lib.currency

import com.top.data.fields.IFieldData
import java.math.BigDecimal

/**
 * Currency 结构数据
 */
data class CurrencyFieldData(
    /**
     * 数值
     *
     * 约束：货币值最小为0，不能为负值
     */
    val value: BigDecimal?
) : IFieldData