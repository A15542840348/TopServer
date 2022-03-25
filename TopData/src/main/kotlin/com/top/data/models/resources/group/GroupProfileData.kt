package com.top.data.models.resources.group

import com.top.data.models.common.AvatarData
import com.top.data.models.common.MetaData
import com.top.data.models.resources.IResourceProfileData

/**
 * 群组信息
 */
data class GroupProfileData(
    /**
     * 群组名称
     */
    override val name: String,

    /**
     * 群组头像
     */
    override val avatar: AvatarData?,

    /**
     * 群组描述
     */
    override val description: String?,

    /**
     * 元数据
     */
    val meta: MetaData,
) : IResourceProfileData
