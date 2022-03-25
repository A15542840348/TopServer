package com.top.data.models.resources.user

import com.top.data.models.common.AvatarData
import com.top.data.models.resources.IResourceProfileData

/**
 * 用户信息
 */
data class UserProfileData(
    /**
     * 用户名称
     */
    override val name: String,

    /**
     * 用户头像
     */
    override val avatar: AvatarData?,

    /**
     * 用户描述
     */
    override val description: String?,
) : IResourceProfileData
