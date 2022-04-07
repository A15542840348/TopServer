import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean

/**
 * 产品资源 信息
 */
@DynamoDbBean
class ProductProfileData1()
{
    /**
     * 产品名称
     */
    lateinit var name: String

    /**
     * 产品头像
     */
    lateinit var avatar: AvatarData1

    /**
     * 产品描述
     */
    lateinit var description: String
}
