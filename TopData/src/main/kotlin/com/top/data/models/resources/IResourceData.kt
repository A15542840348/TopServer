package com.top.data.models.resources

import com.top.data.ResourceStatus
import com.top.data.ResourceType
import com.top.data.models.common.MetaData

interface IResourceData {
    /**
     * 资源ID
     */
    val id: String

    /**
     * 资源所有者ID
     */
    val ownerId: String

    /**
     * 资源所有者类型
     */
    val ownerType: ResourceType

    /**
     * 资源状态
     */
    val status: ResourceStatus

    /**
     * 元数据
     */
    val meta: MetaData
}