package com.top.data.models.resources.library

import com.top.data.models.common.AvatarData
import com.top.data.models.common.MetaData
import com.top.data.models.resources.IResourceProfileData

/**
 * 库信息
 */
data class LibraryProfileData(
    /**
     * 库名称
     */
    override val name: String,

    /**
     * 库头像
     */
    override val avatar: AvatarData?,

    /**
     * 库描述
     */
    override val description: String?,

    /**
     * 元数据
     */
    val meta: MetaData,
) : IResourceProfileData
