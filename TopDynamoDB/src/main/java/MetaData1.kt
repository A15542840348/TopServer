import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType
import software.amazon.awssdk.enhanced.dynamodb.internal.converter.attribute.EnhancedAttributeValue
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy
import software.amazon.awssdk.services.dynamodb.model.AttributeValue
import java.util.*

/**
 * 元数据
 */
class MetaData1() {
    /**
     * 创建者ID
     */
    lateinit var createdByUserId: String

    /**
     * 更新者ID
     */
    lateinit var updatedByUserId: String

    /**
     * 创建时间
     */
//    @get:DynamoDbAttribute("createdTime")
//    @get:DynamoDbConvertedBy(LongToDateConverter1::class)
//    @set:DynamoDbAttribute("createdTime")
    lateinit var createdTime: Date


    /**
     * 更新时间
     */
//    @get:DynamoDbAttribute("updatedTime")
//    @get:DynamoDbConvertedBy(LongToDateConverter1::class)
//    @set:DynamoDbAttribute("updatedTime")
    lateinit var updatedTime: Date
}

class LongToDateConverter1 : AttributeConverter<Date>{
    override fun transformFrom(input: Date): AttributeValue {
        return AttributeValue.builder().n(input.time.toString()).build()
    }

    override fun transformTo(input: AttributeValue): Date {
        return if (input.n() != null) {
            Date(input.n())
        } else Date(EnhancedAttributeValue.fromAttributeValue(input).toString())
    }

    override fun type(): EnhancedType<Date> {
        return EnhancedType.of(Date::class.java)
    }

    override fun attributeValueType(): AttributeValueType {
        return AttributeValueType.N
    }
}
