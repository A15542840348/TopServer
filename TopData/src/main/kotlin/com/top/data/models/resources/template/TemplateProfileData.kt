package com.top.data.models.resources.template

import com.top.data.models.common.AvatarData
import com.top.data.models.resources.IResourceProfileData

/**
 * 模板信息
 */
data class TemplateProfileData(
    /**
     * 模板名称
     */
    override val name: String,

    /**
     * 模板头像
     */
    override val avatar: AvatarData?,

    /**
     * 模板描述
     */
    override val description: String?,
) : IResourceProfileData
