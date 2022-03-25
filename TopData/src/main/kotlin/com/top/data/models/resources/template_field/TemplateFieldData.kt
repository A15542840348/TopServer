package com.top.data.models.resources.template_field

import com.top.data.ResourceStatus
import com.top.data.ResourceType
import com.top.data.fields.IFieldData
import com.top.data.fields.IFieldDefinition
import com.top.data.models.common.MetaData
import com.top.data.models.resources.IResourceData

/**
 * 模板属性（资源）
 */
data class TemplateFieldData(
    /**
     * 模板属性ID
     */
    override val id: String,

    /**
     * 模板属性所属的资源ID
     */
    override val ownerId: String,

    /**
     * 模板属性所属的资源类型
     */
    override val ownerType: ResourceType,

    /**
     * 模板属性状态
     */
    override val status: ResourceStatus,

    /**
     * 模板属性元数据
     */
    override val meta: MetaData,

    val key: String,

    val profile: TemplateFieldProfileData,

    val definition: IFieldDefinition<IFieldData>,
) : IResourceData
