package com.top.data.fields.lib.cascadeselection

import com.top.data.fields.IFieldDefinition

data class CascadeSelectionFieldDefinition(
    /**
     * 是否强制要求有值
     */
    override val isRequired: Boolean?,

    /**
     * 缺省默认值
     */
    override val defaultValue: CascadeSelectionFieldData?,

    /**
     * 值为 `true` 时的标签
     */
    val trueValue: String?,

    /**
     * 值为 `false` 时的标签
     */
    val falseValue: String?,
) : IFieldDefinition<CascadeSelectionFieldData>

