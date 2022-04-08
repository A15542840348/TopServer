import com.top.data.ResourceStatus;
import com.top.data.ResourceType;
import com.top.data.models.common.AvatarDataType;
import kotlin.coroutines.CoroutineContext;
import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.enhanced.dynamodb.model.*;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.utils.AttributeMap;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ProductTableV2Bak {

    public static void main(String[] args) {

//        DynamoDbEnhancedClient enhancedClient = TableMethod.getClientV2();
//
////        putRecord(enhancedClient);
//        String result = getItem(enhancedClient);

        MetaData1 md = new MetaData1();
        md.setCreatedByUserId("200");
        md.setUpdatedByUserId("100");
        md.setCreatedTime(new Date());
        md.setUpdatedTime(new Date());

        AvatarData1 ad = new AvatarData1();
        ad.setType(AvatarDataType.EMOJI);
        ad.setEmoji("100");
        ad.setImageId("100");
        ad.setText("100");

        ProductProfileData1 ppd = new ProductProfileData1();
        ppd.setAvatar(ad);
        ppd.setDescription("100");
        ppd.setName("100");

        //保存
        ProductData1 item = new ProductData1();
        item.setId("7");
        item.setOwnerId("200");
        item.setOwnerType(ResourceType.APP);
        item.setProfile(ppd);
        item.setStatus(ResourceStatus.DELETED);
        item.setMeta(md);

        saveV2(item);
    }

    public static ProductData1 saveV2(ProductData1 pd1){
        DynamoDbEnhancedClient enhancedClient = TableMethod.getClientV2();

        try {
            DynamoDbTable<ProductData1> mappedTable = enhancedClient.table("Product", TableSchema.fromBean(ProductData1.class));

            AttributeValue att = AttributeValue.builder()
                    .s(pd1.id)
                    .build();

            Map<String, AttributeValue> expressionValues = new HashMap<>();
            expressionValues.put(":id", att);

            Expression expression = Expression.builder()
                    .expression("id = :id")
                    .expressionValues(expressionValues)
                    .build();

            enhancedClient.transactWriteItems(
                    TransactWriteItemsEnhancedRequest.builder()
                            .addPutItem(mappedTable, pd1)
                            .addConditionCheck(mappedTable,
                                    ConditionCheck.builder()
                                            .
                                            .conditionExpression(expression)
                                            .build())
                            .build());

        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        return pd1;
    }

    public static String getItem(DynamoDbEnhancedClient enhancedClient) {
        try {
            //Create a DynamoDbTable object
            DynamoDbTable<ProductData1> mappedTable = enhancedClient.table("Product", TableSchema.fromBean(ProductData1.class));

            //Create a KEY object
            Key key = Key.builder()
                    .partitionValue("7")
                    .sortValue("200")
                    .build();

            // Get the item by using the key
            ProductData1 result = mappedTable.getItem(r->r.key(key));
            return "The email value is "+result.getId();

        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        return "";
    }

    public static void putRecord(DynamoDbEnhancedClient enhancedClient) {

        try {
            DynamoDbTable<ProductData1> custTable = enhancedClient.table("Product", TableSchema.fromBean(ProductData1.class));

            MetaData1 md = new MetaData1();
            md.setCreatedByUserId("200");
            md.setUpdatedByUserId("100");
            md.setCreatedTime(new Date());
            md.setUpdatedTime(new Date());

            AvatarData1 ad = new AvatarData1();
            ad.setType(AvatarDataType.EMOJI);
            ad.setEmoji("100");
            ad.setImageId("100");
            ad.setText("100");

            ProductProfileData1 ppd = new ProductProfileData1();
            ppd.setAvatar(ad);
            ppd.setDescription("100");
            ppd.setName("100");

            //保存
            ProductData1 item = new ProductData1();
            item.setId("7");
            item.setOwnerId("200");
            item.setOwnerType(ResourceType.APP);
            item.setProfile(ppd);
            item.setStatus(ResourceStatus.DELETED);
            item.setMeta(md);

            // Put the customer data into a DynamoDB table
            custTable.putItem(item);

        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("done");

    }
}
