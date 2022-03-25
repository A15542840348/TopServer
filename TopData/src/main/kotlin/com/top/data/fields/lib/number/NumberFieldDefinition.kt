package com.top.data.fields.lib.number

import com.top.data.fields.IFieldDefinition

/**
 * Number 结构
 *
 * TODO
 * 1. 取值范围
 * 2. 小数位最多多少位
 * 3. 超大值的解决方案
 * 4. 如何保证客户端和服务器精度一致
 */
data class NumberFieldDefinition(
    /**
     * 是否强制要求有值
     */
    override val isRequired: Boolean?,

    /**
     * 缺省默认值
     */
    override val defaultValue: NumberFieldData?,

    /**
     * 闭区间最小值
     */
    val inclusiveMin: Int?,

    /**
     * 闭区间最大值
     */
    val inclusiveMax: Int?,

    /**
     * 开区间最小值
     */
    val exclusiveMin: Int?,

    /**
     * 开区间最大值
     */
    val exclusiveMax: Int?,

    /**
     * 数值取值类型
     */
    val rangeType: NumberRangeType?,

    /**
     * 小数位数
     *
     * 约束：
     * 1. 默认为支持最大位的小数
     * 2. 取值范围是 [0, 20]
     * 3. 若当前非十进制，则必须是整数
     */
    val decimalPlaces: Int?,

    /**
     * 进制类型
     */
    val numberSystem: NumberSystem?,

    /**
     * 使用分隔符
     *
     * TODO：不同语言下，分隔符应该不一样
     */
    val useSeparator: Boolean?
) : IFieldDefinition<NumberFieldData>