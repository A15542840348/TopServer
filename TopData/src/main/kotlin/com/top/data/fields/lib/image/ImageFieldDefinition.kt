package com.top.data.fields.lib.image

import com.top.data.fields.IFieldDefinition

/**
 * TODO
 * 1. 支持的图片类型
 * 2. 支持的图片文件后缀
 */
data class ImageFieldDefinition(
    /**
     * 是否强制要求有值
     */
    override val isRequired: Boolean?,

    /**
     * 缺省默认值
     */
    override val defaultValue: ImageFieldData?,
) : IFieldDefinition<ImageFieldData>