package com.top.data.models.resources.product

import com.top.data.models.resources.IResourceQuotaData

/**
 * 产品资源配额数据
 */
data class ProductQuotaData(
    /**
     * 最大的应用数目
     */
    val maxApplicationCount: Int?,

    /**
     * 最大的用户数目
     */
    val maxUserCount: Int?,

    /**
     * 最大的成员数目
     */
    val maxMemberCount: Int?,

    /**
     * 最大的管理员数目
     */
    val maxAdministratorCount: Int?,
) : IResourceQuotaData