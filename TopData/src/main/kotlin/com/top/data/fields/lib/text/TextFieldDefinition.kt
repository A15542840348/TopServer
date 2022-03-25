package com.top.data.fields.lib.text

import com.top.data.fields.IFieldDefinition

data class TextFieldDefinition(
    /**
     * 是否强制要求有值
     */
    override val isRequired: Boolean?,

    /**
     * 缺省值或默认值
     */
    override val defaultValue: TextFieldData?,

    /**
     * 最小长度
     *
     * 约束：
     * 1. 取值范围 [0, TODO]
     * 2. 取值范围 [0, maxLen]
     */
    val minLen: Int?,

    /**
     * 最大长度
     *
     * 约束：
     * 1. 取值范围 [1, TODO]
     * 2. 取值范围 [minLen, TODO]
     */
    val maxLen: Int?,

    /**
     * 最小行数
     *
     * 约束：
     * 1. 取值范围 [0, TODO]
     * 2. 取值范围 [0, maxLen]
     */
    val minLines: Int?,

    /**
     * 最大行数
     *
     * 约束：
     * 1. 取值范围 [1, TODO]
     * 2. 取值范围 [minLen, TODO]
     */
    val maxLines: Int?,

    /**
     * 文本输入类型
     */
    val charTypes: List<TextCharType>?,

    /**
     * 正则表达式
     */
    val regexExp: String?

) : IFieldDefinition<TextFieldData>
