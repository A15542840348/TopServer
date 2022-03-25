package com.top.data.models.resources.space

import com.top.data.models.common.AvatarData

/**
 * 空间信息
 */
data class SpaceProfileData(
    /**
     * 空间名称
     */
    val name: String,

    /**
     * 空间头像
     */
    val avatar: AvatarData,

    /**
     * 空间描述
     */
    val description: String?,
)
