package com.top.data.fields.lib.table

import com.top.data.fields.IFieldDefinition

data class TableFieldDefinition(
    /**
     * 是否强制要求有值
     */
    override val isRequired: Boolean?,

    /**
     * 缺省默认值
     */
    override val defaultValue: TableFieldData?,

    /**
     * 值为 `true` 时的标签
     */
    val trueValue: String?,

    /**
     * 值为 `false` 时的标签
     */
    val falseValue: String?,
) : IFieldDefinition<TableFieldData>