package com.top.data

import com.google.gson.annotations.SerializedName

/**
 * 资源类型
 */
enum class ResourceType {
    /**
     * 0. 系统
     */
    @SerializedName("0")
    SYSTEM,

    /**
     * 1. 产品
     */
    @SerializedName("1")
    PRODUCT,

    /**
     * 2. 应用
     */
    @SerializedName("2")
    APP,

    /**
     * 3. 空间
     */
    @SerializedName("3")
    SPACE,

    /**
     * 4. 项目
     */
    @SerializedName("4")
    PROJECT,

    /**
     * 5. 库
     */
    @SerializedName("5")
    LIBRARY,

    /**
     * 6. 模板
     */
    @SerializedName("6")
    TEMPLATE,

    /**
     * 7. 模板属性
     */
    @SerializedName("7")
    TEMPLATE_FIELD,

    /**
     * 8. 文档
     */
    @SerializedName("8")
    DOCUMENT,

    /**
     * 9. 文档属性
     */
    @SerializedName("9")
    DOCUMENT_FIELD,

    /**
     * 10. 用户
     */
    @SerializedName("10")
    USER,

    /**
     * 11. 群组
     */
    @SerializedName("11")
    GROUP,

    /**
     * 12. 角色
     */
    @SerializedName("12")
    ROLE,

    /**
     * 13. 成员
     */
    @SerializedName("13")
    MEMBER,

    /**
     * 14. 授权
     */
    @SerializedName("14")
    AUTHORIZATION,
}

