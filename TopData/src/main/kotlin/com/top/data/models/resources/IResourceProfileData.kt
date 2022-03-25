package com.top.data.models.resources

import com.top.data.models.common.AvatarData

/**
 * 资源概要
 */
interface IResourceProfileData {
    /**
     * 资源名称
     */
    val name: String

    /**
     * 资源头像
     */
    val avatar: AvatarData?

    /**
     * 资源描述
     */
    val description: String?
}