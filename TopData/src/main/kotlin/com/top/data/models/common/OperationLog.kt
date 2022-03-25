package com.top.data.models.common

import com.top.data.ResourceType
import com.top.data.models.resources.IResourceOperationType
import java.util.*

/**
 * 资源操作日志
 */
data class OperationLog(
    /**
     * 请求ID
     */
    val id: String,

    /**
     * 资源类型
     */
    val resourceType: ResourceType,

    /**
     * 操作类型
     */
    val operationType: IResourceOperationType,

    /**
     * 操作者ID
     */
    val operatorId: String,

    /**
     * 操作者IP
     */
    val operatorIp: String,

    /**
     * 操作时间
     */
    val operationTime: Date,

    /**
     * 操作数据
     */
    val payload: Map<String, Any>?,
)
