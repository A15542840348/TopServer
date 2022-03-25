package com.top.data.models.resources.role

import com.top.data.ResourceStatus
import com.top.data.ResourceType
import com.top.data.models.common.MetaData
import com.top.data.models.resources.IResourceData

/**
 * 自定义角色（资源）
 */
data class RoleData(
    /**
     * 角色ID
     */
    override val id: String,

    /**
     * 角色类型
     */
    val type: RoleType,

    /**
     * 角色所属的资源ID
     */
    override val ownerId: String,

    /**
     * 角色所属的资源类型
     */
    override val ownerType: ResourceType,

    /**
     * 角色概要
     */
    val profile: RoleProfileData,

    /**
     * 角色状态
     */
    override val status: ResourceStatus,

    /**
     * 角色元数据
     */
    override val meta: MetaData,
) : IResourceData
