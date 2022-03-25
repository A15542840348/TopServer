package com.top.data.models.resources.document

import com.top.data.models.common.AvatarData
import com.top.data.models.resources.IResourceProfileData

/**
 * 记录信息
 */
data class DocumentProfileData(
    /**
     * 记录名称
     */
    override val name: String,

    /**
     * 记录头像
     */
    override val avatar: AvatarData?,

    /**
     * 记录描述
     */
    override val description: String?,
) : IResourceProfileData
