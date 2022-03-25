package com.top.data.models.common.authorization

import com.top.data.ResourceType
import com.top.data.models.common.MetaData

/**
 * 授权模型
 */
data class Authorization(
    /**
     * 授权主体的资源ID
     */
    val subjectId: String,

    /**
     * 授权主体的资源类型
     *
     * 支持的类型如下：
     * 1. 角色
     * 2. 成员
     */
    val subjectType: ResourceType,

    /**
     * 授权策略
     */
    val policies: List<com.top.data.models.common.authorization.AuthorizationPolicy>,

    /**
     * 授权边界
     *
     * 用于限定用户最大的权限范围。若为空，代表无此限制。
     */
    val boundaries: List<com.top.data.models.common.authorization.AuthorizationPolicy>?,

    /**
     * 授权条件
     *
     * 用于设定用户权限生效的条件。若为空，代表无此限制。
     */
    val condition: com.top.data.models.common.authorization.AuthorizationCondition?,

    /**
     * 元数据
     */
    val meta: MetaData,
)
