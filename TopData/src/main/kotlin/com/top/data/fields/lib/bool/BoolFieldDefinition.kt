package com.top.data.fields.lib.bool

import com.top.data.fields.IFieldDefinition

data class BoolFieldDefinition(
    /**
     * 是否强制要求有值
     */
    override val isRequired: Boolean?,

    /**
     * 缺省默认值
     */
    override val defaultValue: BoolFieldData?,

    /**
     * 值为 `true` 时的标签
     */
    val trueLabel: String?,

    /**
     * 值为 `false` 时的标签
     */
    val falseLabel: String?,
) : IFieldDefinition<BoolFieldData>