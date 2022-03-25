package com.top.data.models.resources.group

import com.top.data.ResourceStatus
import com.top.data.ResourceType
import com.top.data.models.common.MetaData
import com.top.data.models.resources.IResourceData

/**
 * 群组（资源）
 */
data class GroupData(
    /**
     * 群组ID
     */
    override val id: String,

    /**
     * 群组所有者ID
     */
    override val ownerId: String,

    /**
     * 群组所有者类型
     */
    override val ownerType: ResourceType,

    /**
     * 群组信息
     */
    val profile: GroupProfileData,

    /**
     * 群组状态
     */
    override val status: ResourceStatus,

    /**
     * 群组的元数据
     */
    override val meta: MetaData,
) : IResourceData
