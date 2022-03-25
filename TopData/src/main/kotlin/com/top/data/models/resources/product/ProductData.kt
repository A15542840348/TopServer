package com.top.data.models.resources.product

import com.top.data.ResourceStatus
import com.top.data.ResourceType
import com.top.data.models.common.MetaData
import com.top.data.models.resources.IResourceData

/**
 * 产品（资源）
 */
data class ProductData(
    /**
     * 产品ID
     */
    override val id: String,

    /**
     * 产品所有者ID
     */
    override val ownerId: String,

    /**
     * 产品所有者类型
     */
    override val ownerType: ResourceType,

    /**
     * 产品概述
     */
    val profile: ProductProfileData,

    /**
     * 产品状态
     */
    override val status: ResourceStatus,

    /**
     * 元数据
     */
    override val meta: MetaData,
) : IResourceData
