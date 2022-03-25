package com.top.data.fields.lib.file

import com.top.data.fields.IFieldDefinition

data class FileFieldDefinition(
    /**
     * 是否强制要求有值
     */
    override val isRequired: Boolean?,

    /**
     * 缺省默认值
     */
    override val defaultValue: FileFieldData?,

    /**
     * 最大体积
     */
    val maxBytes: Long?,

    /**
     * 支持的后缀类型
     */
    val extensions: List<String>?,
) : IFieldDefinition<FileFieldData>