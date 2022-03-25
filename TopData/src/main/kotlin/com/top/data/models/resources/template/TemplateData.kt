package com.top.data.models.resources.template

import com.top.data.ResourceStatus
import com.top.data.ResourceType
import com.top.data.models.common.MetaData
import com.top.data.models.resources.IResourceData

/**
 * 模板资源
 */
data class TemplateData(
    /**
     * 模板ID
     */
    override val id: String,

    /**
     * 父模板ID
     *
     * 若为 null，代表继承自元模板
     */
    val parentId: String?,

    /**
     * 模板所属的资源ID
     */
    override val ownerId: String,

    /**
     * 模板所属的资源类型
     */
    override val ownerType: ResourceType,

    /**
     * 模板信息
     */
    val profile: TemplateProfileData,

    /**
     * 模板状态
     */
    override val status: ResourceStatus,

    /**
     * 模板元数据
     */
    override val meta: MetaData
) : IResourceData
