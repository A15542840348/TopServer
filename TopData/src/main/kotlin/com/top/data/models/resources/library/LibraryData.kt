package com.top.data.models.resources.library

import com.top.data.ResourceStatus
import com.top.data.ResourceType
import com.top.data.models.common.MetaData
import com.top.data.models.resources.IResourceData

/**
 * 库（资源）
 */
data class LibraryData(
    /**
     * 库ID
     */
    override val id: String,

    /**
     * 库所有者ID
     */
    override val ownerId: String,

    /**
     * 库所有者类型
     */
    override val ownerType: ResourceType,

    /**
     * 库信息
     */
    val profile: LibraryProfileData,

    /**
     * 库状态
     */
    override val status: ResourceStatus,

    /**
     * 库的元数据
     */
    override val meta: MetaData,
) : IResourceData
