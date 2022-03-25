package com.top.data.fields.lib.collection

import com.top.data.fields.IFieldDefinition

data class CollectionFieldDefinition(
    /**
     * 是否强制要求有值
     */
    override val isRequired: Boolean?,

    /**
     * 缺省值或默认值
     */
    override val defaultValue: CoolectionFieldData?,
) : IFieldDefinition<CoolectionFieldData>

