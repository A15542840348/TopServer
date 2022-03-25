package com.top.data.models.resources.project

import com.top.data.ResourceStatus
import com.top.data.ResourceType
import com.top.data.models.common.MetaData
import com.top.data.models.resources.IResourceData

/**
 * 项目（资源）
 */
data class ProjectData(
    /**
     * 项目ID
     */
    override val id: String,

    /**
     * 空间所属的资源ID
     */
    override val ownerId: String,

    /**
     * 空间所属资源类型
     */
    override val ownerType: ResourceType,

    /**
     * 项目信息
     */
    val profile: ProjectProfileData,

    /**
     * 项目状态
     */
    override val status: ResourceStatus,

    /**
     * 元数据
     */
    override val meta: MetaData,
) : IResourceData
