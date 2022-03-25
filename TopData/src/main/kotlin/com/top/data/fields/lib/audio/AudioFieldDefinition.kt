package com.top.data.fields.lib.audio

import com.top.data.fields.IFieldDefinition

data class AudioFieldDefinition(
    /**
     * 是否强制要求有值
     */
    override val isRequired: Boolean?,

    /**
     * 缺省值或默认值
     */
    override val defaultValue: AudioFieldData?,
) : IFieldDefinition<AudioFieldData>

