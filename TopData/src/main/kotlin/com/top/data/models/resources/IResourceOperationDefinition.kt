package com.top.data.models.resources

import com.top.data.ResourceType

interface IResourceOperationDefinition {
    /**
     * 资源类型
     */
    val resourceType: ResourceType

    /**
     * 访问级别
     */
    val accessLevel: ResourceOperationAccessLevel

    /**
     * 操作名称
     */
    val operationName: String
}