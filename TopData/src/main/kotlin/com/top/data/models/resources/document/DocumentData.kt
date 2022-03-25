package com.top.data.models.resources.document

import com.top.data.ResourceStatus
import com.top.data.ResourceType
import com.top.data.models.common.MetaData
import com.top.data.models.resources.IResourceData

/**
 * 文档（资源）
 */
data class DocumentData(
    /**
     * 文档ID
     */
    override val id: String,

    /**
     * 文档所属的资源ID
     */
    override val ownerId: String,

    /**
     * 文档所属的资源类型
     */
    override val ownerType: ResourceType,

    /**
     * 文档信息
     */
    val profile: DocumentProfileData,

    /**
     * 文档状态
     */
    override val status: ResourceStatus,

    /**
     * 文档元数据
     */
    override val meta: MetaData
) : IResourceData
