package com.top.data.models.resources.app

import com.top.data.models.common.AvatarData
import com.top.data.models.resources.IResourceProfileData

/**
 * 应用资源 信息
 */
data class ApplicationProfileData(
    /**
     * 应用名称
     */
    override val name: String,

    /**
     * 应用头像
     */
    override val avatar: AvatarData?,

    /**
     * 应用描述
     */
    override val description: String?,
) : IResourceProfileData
