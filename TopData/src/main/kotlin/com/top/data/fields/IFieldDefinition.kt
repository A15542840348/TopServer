package com.top.data.fields

/**
 * 基础结构体
 *
 * TODO:
 * 1. 是否要支持其他记录的值，作为约束当前记录的值。例如：某一个动物对象具有属性 age，
 * 那么它可以作为该对象其他参数的约束。
 */
interface IFieldDefinition<T : IFieldData> {
    /**
     * 是否强制要求有值
     */
    val isRequired: Boolean?

    /**
     * 缺省值或默认值
     */
    val defaultValue: T?
}