package com.top.data.models.common.authorization

import com.top.data.ResourceType

/**
 * 授权策略
 */
data class AuthorizationPolicy(
    /**
     * 资源类型
     */
    val resourceType: ResourceType?,

    /**
     * 资源ID
     */
    val resourceId: String?,

    /**
     * 操作类型
     */
    val operations: Set<String>,

    /**
     * 授权效果
     */
    val effect: com.top.data.models.common.authorization.AuthorizationEffect,
)
