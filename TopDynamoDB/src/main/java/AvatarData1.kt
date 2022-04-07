import com.top.data.models.common.AvatarDataType
import software.amazon.awssdk.enhanced.dynamodb.internal.converter.attribute.EnumAttributeConverter
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy

/**
 * 头像数据
 */
class AvatarData1()
{
    /**
     * 头像类型
     */
//    @get:DynamoDbConvertedBy(EnumAttributeConverter::class)
    lateinit var type: AvatarDataType

    /**
     * 图片
     */
    var imageId: String? = null

    /**
     * 文本
     */
    var text: String? = null

    /**
     * Emoji
     */
    var emoji: String? = null
}