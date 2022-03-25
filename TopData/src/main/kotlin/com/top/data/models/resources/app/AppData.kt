package com.top.data.models.resources.app

import com.top.data.ResourceStatus
import com.top.data.ResourceType
import com.top.data.models.common.MetaData
import com.top.data.models.resources.IResourceData

/**
 * 应用（资源）
 */
data class AppData(
    /**
     * 应用资源ID
     */
    override val id: String,

    /**
     * 应用所有者ID
     */
    override val ownerId: String,

    /**
     * 应用所有者类型
     */
    override val ownerType: ResourceType,

    /**
     * 应用资源信息
     */
    val profile: ApplicationProfileData,

    /**
     * 应用资源状态
     */
    override val status: ResourceStatus,

    /**
     * 应用资源概述
     */
    override val meta: MetaData,
) : IResourceData
