import com.top.data.ResourceStatus
import com.top.data.ResourceType
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey

/**
 * 产品（资源）
 */
@DynamoDbBean
class ProductData1(

) {
    /**
     * 产品ID
     */
    @get:DynamoDbPartitionKey
    lateinit var id: String

    /**
     * 所有者ID
     */
    @get:DynamoDbSortKey
    lateinit var ownerId: String

    /**
     * 所有者类型
     */
//    @get:DynamoDbConvertedBy(EnumAttributeConverter::class)
    lateinit var ownerType: ResourceType

    /**
     * 产品概述
     */
    lateinit var profile: ProductProfileData1

    /**
     * 产品状态
     */
//    @get:DynamoDbConvertedBy(EnumAttributeConverter::class)
    lateinit var status: ResourceStatus

    /**
     * 元数据
     */
    lateinit var meta: MetaData1
}