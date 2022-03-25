package com.top.data.models.resources.system

import com.top.data.ResourceStatus
import com.top.data.ResourceType
import com.top.data.models.common.MetaData
import com.top.data.models.resources.IResourceData

/**
 * 系统（资源）
 */
data class SystemData(
    /**
     * 系统ID
     */
    override val id: String,

    /**
     * 系统所有者ID
     */
    override val ownerId: String,

    /**
     * 系统所有者类型
     */
    override val ownerType: ResourceType,

    /**
     * 系统状态
     */
    override val status: ResourceStatus,

    /**
     * 元数据
     */
    override val meta: MetaData,
) : IResourceData
