package com.top.data.models.resources.template_field

import com.top.data.models.common.AvatarData

/**
 * 模板属性信息
 */
data class TemplateFieldProfileData(
    /**
     * 模板属性名称
     */
    val name: String,

    /**
     * 模板属性头像
     */
    val avatar: AvatarData,

    /**
     * 模板属性描述
     */
    val description: String?,
)
