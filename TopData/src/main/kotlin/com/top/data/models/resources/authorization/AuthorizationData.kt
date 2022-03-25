package com.top.data.models.resources.authorization

import com.top.data.ResourceStatus
import com.top.data.ResourceType
import com.top.data.models.common.MetaData
import com.top.data.models.resources.IResourceData

/**
 * 授权（资源）
 */
data class AuthorizationData(
    /**
     * 授权资源ID
     */
    override val id: String,

    /**
     * 授权所有者ID
     */
    override val ownerId: String,

    /**
     * 授权所有者类型
     */
    override val ownerType: ResourceType,

    /**
     * 授权资源状态
     */
    override val status: ResourceStatus,

    /**
     * 授权资源概述
     */
    override val meta: MetaData,
) : IResourceData
