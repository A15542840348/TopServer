package com.top.data.models.resources.user

import com.top.data.ResourceStatus
import com.top.data.ResourceType
import com.top.data.models.common.MetaData
import com.top.data.models.resources.IResourceData

/**
 * 用户（资源）
 */
data class UserData(
    /**
     * 用户ID
     */
    override val id: String,

    /**
     * 用户所有者ID
     */
    override val ownerId: String,

    /**
     * 用户所有者类型
     */
    override val ownerType: ResourceType,

    /**
     * 用户信息
     */
    val profile: UserProfileData,

    /**
     * 用户状态
     */
    override val status: ResourceStatus,

    /**
     * 用户元数据
     */
    override val meta: MetaData
) : IResourceData
