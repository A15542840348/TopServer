package com.top.data.models.resources.document_field

import com.top.data.ResourceStatus
import com.top.data.ResourceType
import com.top.data.fields.IFieldData
import com.top.data.models.common.MetaData
import com.top.data.models.resources.IResourceData

/**
 * 文档属性（资源）
 */
data class DocumentFieldData(
    /**
     * 文档属性ID
     */
    override val id: String,

    /**
     * 文档属性所属的资源ID
     */
    override val ownerId: String,

    /**
     * 文档属性所属的资源类型
     */
    override val ownerType: ResourceType,

    /**
     * 文档属性状态
     */
    override val status: ResourceStatus,

    /**
     * 文档属性元数据
     */
    override val meta: MetaData,

    val key: String,

    val data: IFieldData,
) : IResourceData
