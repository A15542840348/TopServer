package com.top.data.models.field

import com.top.data.fields.IFieldDefinition
import com.top.data.fields.lib.audio.AudioFieldDefinition
import com.top.data.fields.lib.bool.BoolFieldDefinition
import com.top.data.fields.lib.cascadeselection.CascadeSelectionFieldDefinition
import com.top.data.fields.lib.collection.CollectionFieldDefinition
import com.top.data.fields.lib.currency.CurrencyFieldDefinition
import com.top.data.fields.lib.datetime.DateTimeFieldDefinition
import com.top.data.fields.lib.file.FileFieldDefinition
import com.top.data.fields.lib.geolocation.GeoLocationFieldDefinition
import com.top.data.fields.lib.image.ImageFieldDefinition
import com.top.data.fields.lib.multiselection.MultiSelectionFieldDefinition
import com.top.data.fields.lib.number.NumberFieldDefinition
import com.top.data.fields.lib.reference.ReferenceFieldDefinition
import com.top.data.fields.lib.selection.SelectionFieldDefinition
import com.top.data.fields.lib.table.TableFieldDefinition
import com.top.data.fields.lib.text.TextFieldDefinition
import com.top.data.fields.lib.video.VideoFieldDefinition
import kotlin.reflect.KClass

/**
 * 记录值类型
 *
 * 这里记录的是最基本的类型，每一个类型都对应着自己的数据结构，
 * 也是当前系统需要一一支持的数据类型
 */
enum class StructType(val fieldDefinitionClass: KClass<out IFieldDefinition<*>>) {
    /**
     * 布尔类型
     */
    BOOLEAN(BoolFieldDefinition::class),

    /**
     * 数值类型
     */
    NUMBER(NumberFieldDefinition::class),

    /**
     * 文本
     */
    TEXT(TextFieldDefinition::class),

    /**
     * 货币
     */
    CURRENCY(CurrencyFieldDefinition::class),

    /**
     * 日期
     */
    DATE_TIME(DateTimeFieldDefinition::class),

    /**
     * 文件
     */
    FILE(FileFieldDefinition::class),

    /**
     * 视频
     */
    VIDEO(VideoFieldDefinition::class),

    /**
     * 音频
     */
    AUDIO(AudioFieldDefinition::class),

    /**
     * 图片
     */
    IMAGE(ImageFieldDefinition::class),

    /**
     * 地理位置
     */
    LOCATION(GeoLocationFieldDefinition::class),

    /**
     * 单项选择
     */
    SELECTION(SelectionFieldDefinition::class),

    /**
     * 多项选择
     */
    MULTI_SELECTION(MultiSelectionFieldDefinition::class),

    /**
     * 级联选择
     */
    CASCADE_SELECTION(CascadeSelectionFieldDefinition::class),

    /**
     * 集合
     */
    COLLECTION(CollectionFieldDefinition::class),

    /**
     * 引用
     */
    REFERENCE(ReferenceFieldDefinition::class),

    /**
     * 表格
     */
    TABLE(TableFieldDefinition::class),
}