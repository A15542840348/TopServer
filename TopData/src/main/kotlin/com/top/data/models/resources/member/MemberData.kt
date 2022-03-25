package com.top.data.models.resources.member

import com.top.data.ResourceStatus
import com.top.data.ResourceType
import com.top.data.models.common.MetaData
import com.top.data.models.resources.IResourceData
import com.top.data.models.resources.role.RoleType

/**
 * 成员
 */
data class MemberData(
    /**
     * 成员ID
     */
    override val id: String,

    /**
     * 成员主体ID
     */
    val subjectId: String,

    /**
     * 成员所属的资源ID
     */
    override val ownerId: String,

    /**
     * 成员所属的资源类型
     */
    override val ownerType: ResourceType,

    /**
     * 成员元数据
     */
    override val meta: MetaData,

    /**
     * 成员状态
     */
    override val status: ResourceStatus,

    /**
     * 成员主体类型
     *
     * 支持以下资源作为成员主体：
     * 1. 用户
     * 2. 群组
     */
    val subjectType: ResourceType,

    /**
     * 成员在所属资源中的角色ID
     */
    val roleId: String,

    /**
     * 成员在所属资源中的角色类型
     */
    val roleType: RoleType,
) : IResourceData