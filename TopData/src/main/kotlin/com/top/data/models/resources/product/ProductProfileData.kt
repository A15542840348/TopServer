package com.top.data.models.resources.product

import com.top.data.models.common.AvatarData
import com.top.data.models.resources.IResourceProfileData

/**
 * 产品资源 信息
 */
data class ProductProfileData(
    /**
     * 产品名称
     */
    override val name: String,

    /**
     * 产品头像
     */
    override val avatar: AvatarData?,

    /**
     * 产品描述
     */
    override val description: String?,
) : IResourceProfileData
