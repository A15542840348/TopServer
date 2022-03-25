package com.top.data.models.resources.role

import com.top.data.models.common.AvatarData
import com.top.data.models.resources.IResourceProfileData

/**
 * 自定义角色概要
 */
data class RoleProfileData(
    /**
     * 角色名称
     */
    override val name: String,

    /**
     * 角色头像
     */
    override val avatar: AvatarData?,

    /**
     * 角色描述
     */
    override val description: String?,
) : IResourceProfileData
