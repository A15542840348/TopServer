package com.top.data.fields.lib.reference

import com.top.data.ResourceType
import com.top.data.fields.IFieldDefinition

data class ReferenceFieldDefinition(
    /**
     * 是否强制要求有值
     */
    override val isRequired: Boolean?,

    /**
     * 缺省默认值
     */
    override val defaultValue: ReferenceFieldData?,

    /**
     * 引用的资源类型
     */
    val resourceType: ResourceType,

    /**
     * 若当前引用的是记录，则要约束该记录的模板类型
     *
     * TODO
     * 1. 都能引用哪些资源
     * 2. 如何对引用的资源进行约束
     */
    val belongsToTemplateId: String?,
) : IFieldDefinition<ReferenceFieldData>