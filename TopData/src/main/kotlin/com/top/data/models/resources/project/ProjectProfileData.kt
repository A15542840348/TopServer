package com.top.data.models.resources.project

import com.top.data.models.common.AvatarData
import com.top.data.models.resources.IResourceProfileData

/**
 * 项目信息
 */
data class ProjectProfileData(
    /**
     * 项目名称
     */
    override val name: String,

    /**
     * 项目头像
     */
    override val avatar: AvatarData?,

    /**
     * 项目描述
     */
    override val description: String?,
) : IResourceProfileData
