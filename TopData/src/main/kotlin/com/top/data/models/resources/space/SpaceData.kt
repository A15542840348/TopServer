package com.top.data.models.resources.space

import com.top.data.ResourceStatus
import com.top.data.ResourceType
import com.top.data.models.common.MetaData
import com.top.data.models.resources.IResourceData

/**
 * 空间（资源）
 */
data class SpaceData(
    /**
     * 空间ID
     */
    override val id: String,

    /**
     * 空间所有者ID
     */
    override val ownerId: String,

    /**
     * 空间所有者类型
     */
    override val ownerType: ResourceType,

    /**
     * 空间信息
     */
    val profile: SpaceProfileData,

    /**
     * 空间状态
     */
    override val status: ResourceStatus,

    /**
     * 元数据
     */
    override val meta: MetaData,
) : IResourceData
