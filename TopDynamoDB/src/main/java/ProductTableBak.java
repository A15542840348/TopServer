import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExecuteStatementRequest;
import com.amazonaws.services.dynamodbv2.model.ExecuteStatementResult;
import com.top.data.ResourceStatus;
import com.top.data.ResourceType;
import com.top.data.models.common.*;
import com.top.data.models.resources.product.ProductData;
import com.top.data.models.resources.product.ProductProfileData;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

import java.lang.reflect.Field;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class ProductTableBak {

    public static void main(String[] args) {
//        MetaData md = new MetaData();
//        md.setCreatedByUserId("100");
//        md.setUpdatedByUserId("100");
//        md.setCreatedTime(new Date());
//        md.setUpdatedTime(new Date());
//
//        AvatarData ad = new AvatarData();
//        ad.setType(AvatarDataType.EMOJI);
//        ad.setEmoji("100");
//        ad.setImageId("100");
//        ad.setText("100");
//
//        ProductProfileData ppd = new ProductProfileData();
//        ppd.setAvatar(ad);
//        ppd.setDescription("100");
//        ppd.setName("100");
//
//        //保存
//        ProductData item = new ProductData();
//        item.setId("7");
//        item.setOwnerId("200");
//        item.setOwnerType(ResourceType.APP);
//        item.setProfile(ppd);
//        item.setStatus(ResourceStatus.DELETED);
//        item.setMeta(md);
//        save(item);

//        MetaData md1 = new MetaData();
//        md1.createdByUserId = "100";
//        md1.updatedByUserId = "100";
//        md1.createdTime = new Date();
//        md1.updatedTime = new Date();
//        //保存
//        ProductData item1 = new ProductData("8","200", ResourceType.APP,
//                new ProductProfileData("100", new AvatarData(AvatarDataType.EMOJI,"100","100","100"),"100"),
//                ResourceStatus.DELETED,md1
//        );
////        save(item);
//
//        List<ProductData> items = new ArrayList<>();
//        items.add(item);
//        items.add(item1);
//
////        List<ProductData> pdList =  saveAll(items);
//
//        update(item);

//        List<String> ids = new ArrayList<>();
//        List<String> ownerIds = new ArrayList<>();
//
//        ids.add("1");
//        ownerIds.add("2");
//        ids.add("100");
//        ownerIds.add("200");
//        ids.add("2");
//        ownerIds.add("2");
//
//        findAllById(ids,ownerIds);

//        findById("1","2");

        Pageable pageable = new Pageable(10, 10, new Sort(SortDirection.ASC, new ArrayList<>()));
//        findAllQuery(pageable);
        findAllLoad(pageable);

        Region region = Region.US_EAST_1;
        DynamoDbClient ddb = DynamoDbClient.builder()
                .region(region)
                .build();

        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(ddb)
                .build();

        putRecord(enhancedClient) ;
        ddb.close();
    }

    public static void putRecord(DynamoDbEnhancedClient enhancedClient) {

        try {
            DynamoDbTable<ProductData> custTable = enhancedClient.table("Customer", TableSchema.fromBean(ProductData.class));

            MetaData md = new MetaData();
            md.setCreatedByUserId("100");
            md.setUpdatedByUserId("100");
            md.setCreatedTime(new Date());
            md.setUpdatedTime(new Date());

            AvatarData ad = new AvatarData();
            ad.setType(AvatarDataType.EMOJI);
            ad.setEmoji("100");
            ad.setImageId("100");
            ad.setText("100");

            ProductProfileData ppd = new ProductProfileData();
            ppd.setAvatar(ad);
            ppd.setDescription("100");
            ppd.setName("100");

            //保存
            ProductData item = new ProductData();
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

    public static Page<ProductData> findAllLoad(Pageable pageable){
        Page<ProductData> pg = new Page<>(0,0, pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort(),new ArrayList<>());
        try {
            DynamoDBMapper mapper = TableMethod.getMapper();

            // Create ExecuteStatementRequest
            ExecuteStatementRequest executeStatementRequest = new ExecuteStatementRequest();

            AmazonDynamoDB dynamoDB = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_2).build();

            ExecuteStatementRequest request = new ExecuteStatementRequest();
            request.setStatement("SELECT * FROM Product WHERE ownerType = APP OR ownerType = PRODUCT ORDER BY id");

            ExecuteStatementResult a = dynamoDB.executeStatement(request);

            DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                    .withLimit(pageable.getPageSize())
//                    .withExclusiveStartKey()
                    ;

            ScanResultPage<ProductData> srp = mapper.scanPage(ProductData.class,scanExpression);

            System.out.println(srp);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println("Unable to delete item: ");
        }

        return pg;
    }

    //分页查询 https://docs.aws.amazon.com/zh_cn/zh_cn/amazondynamodb/latest/developerguide/Query.Pagination.html
    public static Page<ProductData> findAllQuery(Pageable pageable){
        Page<ProductData> pg = new Page<>(0,0, pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort(),new ArrayList<>());
        try {
            DynamoDBMapper mapper = TableMethod.getMapper();

            Map<String, AttributeValue> eav = new HashMap<>();
//            eav.put(":idStr", new AttributeValue("2"));
            eav.put(":ownerTypeStr", new AttributeValue("APP"));

            DynamoDBQueryExpression<ProductData> queryExpression = new DynamoDBQueryExpression<ProductData>()
                    .withKeyConditionExpression("ownerType = :ownerTypeStr")
                    .withExpressionAttributeValues(eav)
                    .withIndexName("ownerType")
                    .withConsistentRead(false)
                    //.withScanIndexForward(pageable.getSort().getOrderBy().equals(SortDirection.ASC))//查询方向
                    .withLimit(5)
                    ;

            QueryResultPage<ProductData> qrp = mapper.queryPage(ProductData.class,queryExpression);
            QueryResultPage<ProductData> qrp1 = null;
            //如果查询的结果中存在LastEvaluatedKey，则将该参数赋给queryExpression，重新发送申请，获取剩下的，直到不存在该参数
            Map<String,AttributeValue> lastEvaluatedKey = qrp.getLastEvaluatedKey();
            if(!lastEvaluatedKey.isEmpty())
            {
                queryExpression.withExclusiveStartKey(lastEvaluatedKey);
                qrp1 = mapper.queryPage(ProductData.class,queryExpression);
            }

            System.out.println(qrp1);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println("Unable to delete item: ");
        }

        return pg;
    }

    /**
     * 扫描方式查找，速度慢
     * @param pageable
     * @return
     */
    //override fun findAll(pageable: Pageable): Page<Product>
    public static Page<ProductData> findAllScan(Pageable pageable){
        Page<ProductData> pg = new Page<>(0,0, pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort(),new ArrayList<>());

        try {
            DynamoDBMapper mapper = TableMethod.getMapper();

            HashMap<String, AttributeValue> eav = new HashMap<>();
            eav.put(":val1", new AttributeValue().withS("2"));

            DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                    .withFilterExpression("ownerId = :val1")
//                    .withProjectionExpression("id, ownerId, profile.#nm, profile.avatar.#tp, profile.description")
//                    .withExpressionAttributeNames(new NameMap().with("#nm", "name").with("#tp", "type"))
                    .withExpressionAttributeValues(eav)
//                    .withLimit(pageable.getPageNumber() * pageable.getPageSize())//每次最多获取多少个数据，获取到限制值，停止扫描
                    ;

            ScanResultPage<ProductData> pdPage;
            pdPage =  mapper.scanPage(ProductData.class, scanExpression);

//            try {
//                Field f = Product.class.getDeclaredField(pageable.getSort().getOrderBy().get(2));
////                f.setAccessible(true);
////                System.out.println(String.class);
//
//                Object ob = f.get(pdPage.getResults().get(0));
//
//                String aa = ob.getClass().toString();
//                System.out.println(ob.getClass().toString());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

//            try {
//                String s = pageable.getSort().getOrderBy().get(3);
//                Field f = MetaData.class.getDeclaredField(pageable.getSort().getOrderBy().get(3));
////                f.setAccessible(true);
////                System.out.println(String.class);
//
//                Object ob = f.get(pdPage.getResults().get(0).getMeta());
//
//                String aa = ob.getClass().toString();
//                boolean isTrue = ob.getClass() == Date.class;
//                System.out.println(ob.getClass().toString());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

            pdPage.getResults().sort((o1, o2) -> orderRecursion(o1, o2, pageable, 0)); // 按首字母排序

            //降序
            if(pageable.getSort().getDirection() == SortDirection.DESC)
                Collections.reverse(pdPage.getResults());

//            //总结果除以每页个数 + 1，不足加1
//            pg.setTotalPages((int) Math.ceil((double)pdPage.getCount() / (double)pageable.getPageSize()));
//            pg.setTotalElements(pdPage.getCount());
//            pg.setTotalElements(pdPage.getCount());
//            //复制
//            List<Product> pds = new ArrayList<>();
//            int loopTime = Math.min(pdPage.getCount(),pageable.getPageNumber()* pageable.getPageSize());//剩下的不足pageSize个，显示剩下所有元素
//            int loopInit = (pageable.getPageNumber() - 1) * pageable.getPageSize();//当前页起始数据下标为前面页含有元素个数
//            for(int i = loopInit; i < loopTime;i++) {
//                pds.add(pdPage.getResults().get(i));
//            }
//            pg.setData(pds);
        }
        catch (Exception e) {
            System.err.println("Unable to delete item: ");
            System.err.println(e.getMessage());
        }

        return pg;
    }

    public static int orderRecursion(ProductData o1, ProductData o2, Pageable pageable, int nowOrderByNum){
        //通过名字获取属性类型
        Field f;
        Object ob1 = new Object();
        Object ob2 = new Object();
        try {
            f = ProductData.class.getDeclaredField(pageable.getSort().getOrderBy().get(nowOrderByNum));

            ob1 = f.get(o1);
            ob2 = f.get(o2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ob1.getClass() == Integer.class || ob1.getClass() == Date.class) {
            int diff;
            if(ob1.getClass() == Date.class)
            {
                diff = (int) (((Date)ob1).getTime() - ((Date)ob2).getTime());
            }
            else
                diff = (int)ob1 - (int)ob2;

            if (diff > 0)
                return 1;
            else if (diff < 0)
                return -1;

            //回调
            nowOrderByNum++;
            if(nowOrderByNum < pageable.getSort().getOrderBy().size())
            {
                return orderRecursion(o1, o2, pageable, nowOrderByNum);
            }
            return 0;
        }
        else{
            for (int i = 0; i < Math.min(ob1.toString().length(), ob2.toString().length()); i++) {
                int diff = (int) ob1.toString().charAt(i) - (int) ob2.toString().charAt(i);

                if (diff > 0)
                    return 1;
                else if (diff < 0)
                    return -1;
            }

            //前边字符都相同，按长度分
            if(ob1.toString().length() > ob2.toString().length())
                return 1;
            else if(ob1.toString().length() < ob2.toString().length())
                return -1;

            //回调
            nowOrderByNum++;
            if(nowOrderByNum < pageable.getSort().getOrderBy().size())
            {
                return orderRecursion(o1, o2, pageable, nowOrderByNum);
            }
            return 0;
        }
    }

    public void deleteAllById(List<String> ids,List<String> ownerIds){
        DynamoDBMapper mapper = TableMethod.getMapper();

        try {
            TransactionWriteRequest twr = new TransactionWriteRequest();

            for(int i = 0;i < ids.size();i++)
            {
                ProductData pd = new ProductData();
                pd.setId(ids.get(i));
                pd.setOwnerId(ownerIds.get(i));

                Map<String, AttributeValue> eav = new HashMap<>();
                eav.put(":idStr", new AttributeValue(pd.getId()));
                eav.put(":ownerIdStr", new AttributeValue(pd.getOwnerId()));

                DynamoDBTransactionWriteExpression twe = new DynamoDBTransactionWriteExpression()
                        .withExpressionAttributeValues(eav)
                        .withConditionExpression("id = :idStr AND ownerId = :ownerIdStr");

                twr.addDelete(pd, twe);
            }

            mapper.transactionWrite(twr);
        }
        catch (Exception e) {
            System.err.println("故障:项目不存在");
            System.err.println(e.getMessage());
            System.err.println("故障打印结束!");
        }
    }

    public void deleteById(String id,String ownerId){
        DynamoDBMapper mapper = TableMethod.getMapper();

        try {
            ProductData pd = new ProductData();
            pd.setId(id);
            pd.setOwnerId(ownerId);

            TransactionWriteRequest twr = new TransactionWriteRequest();

            Map<String, AttributeValue> eav = new HashMap<>();
            eav.put(":idStr", new AttributeValue(pd.getId()));
            eav.put(":ownerIdStr", new AttributeValue(pd.getOwnerId()));

            DynamoDBTransactionWriteExpression twe = new DynamoDBTransactionWriteExpression()
                    .withExpressionAttributeValues(eav)
                    .withConditionExpression("id = :idStr AND ownerId = :ownerIdStr");

            twr.addDelete(pd, twe);

            mapper.transactionWrite(twr);
        }
        catch (Exception e) {
            System.err.println("故障:项目不存在");
            System.err.println(e.getMessage());
            System.err.println("故障打印结束!");
        }
    }

    public void delete(ProductData pd){
        DynamoDBMapper mapper = TableMethod.getMapper();

        try {
            mapper.delete(pd);
        }
        catch (Exception e) {
            System.err.println("故障:删除失败");
            System.err.println(e.getMessage());
            System.err.println("故障打印结束!");
        }
    }

    public List<ProductData> updateAll(List<ProductData> pds){
        DynamoDBMapper mapper = TableMethod.getMapper();

        try {
            TransactionWriteRequest twr = new TransactionWriteRequest();

            for (ProductData pd : pds) {
                Map<String, AttributeValue> eav = new HashMap<>();
                eav.put(":idStr", new AttributeValue(pd.getId()));
                eav.put(":ownerIdStr", new AttributeValue(pd.getOwnerId()));

                DynamoDBTransactionWriteExpression twe = new DynamoDBTransactionWriteExpression()
                        .withExpressionAttributeValues(eav)
                        .withConditionExpression("id = :idStr AND ownerId = :ownerIdStr");

                twr.addPut(pd, twe);
            }

            mapper.transactionWrite(twr);
        }
        catch (Exception e) {
            System.err.println("故障:项目不存在");
            System.err.println(e.getMessage());
            System.err.println("故障打印结束!");
        }

        return pds;
    }

    public static ProductData update(ProductData pd){
        DynamoDBMapper mapper = TableMethod.getMapper();

        try {
            Map<String, AttributeValue> eav = new HashMap<>();
            eav.put(":idStr", new AttributeValue(pd.getId()));
            eav.put(":ownerIdStr", new AttributeValue(pd.getOwnerId()));

            DynamoDBTransactionWriteExpression twe = new DynamoDBTransactionWriteExpression()
                    .withExpressionAttributeValues(eav)
                    .withConditionExpression("id = :idStr AND ownerId = :ownerIdStr");

            TransactionWriteRequest twr = new TransactionWriteRequest();
            twr.addPut(pd, twe);

            mapper.transactionWrite(twr);
        }
        catch (Exception e) {
            System.err.println("故障:不存在该项");
            System.err.println(e.getMessage());
            System.err.println("故障打印结束!");
        }

        return pd;
    }

    /**
     * 每6小时才更新一次
     * @return 项目数
     */
    public static long count(){
        Table table = TableMethod.getTable("Product");

        return table.describe().getItemCount();
    }

    /**
     * 获取实时项目数，消耗资源
     * @return 项目数
     */
    public static long getRealTimeCount(){
        Table table = TableMethod.getTable("Product");
        ScanSpec scanSpec = new ScanSpec();
        long count = 0;

        try {
            ItemCollection<ScanOutcome> items = table.scan(scanSpec);
            for (Item item : items) {
                count++;
            }
        }
        catch (Exception e) {
            System.err.println("Unable to scan the table:");
            System.err.println(e.getMessage());
        }

        return count;
    }

    public static Boolean existsById(String id,String ownerId){
        ProductData pd = findById(id,ownerId);

        return pd != null;
    }

    // https://docs.aws.amazon.com/zh_cn/zh_cn/amazondynamodb/latest/developerguide/DynamoDBMapper.Methods.html#DynamoDBMapper.Methods.batchLoad
    // 原类型无法初始化，初始化时必须有值
    public static List<ProductData> findAllById(List<String> ids, List<String> ownerIds){
        List<ProductData> listPd = new ArrayList<>();
        DynamoDBMapper mapper = TableMethod.getMapper();

        Map<Class<?>, List<KeyPair>> itemsToGet = new HashMap<>();
        List<KeyPair> listKey = new ArrayList<>();

        for(int i = 0;i < ids.size();i++){
            KeyPair key = new KeyPair();
            key.setHashKey(ids.get(i));
            key.setRangeKey(ownerIds.get(i));

            listKey.add(key);
        }

        itemsToGet.put(ProductData.class,listKey);

        Map<String, List<Object>> items = mapper.batchLoad(itemsToGet);

        for(Object pdb : items.get("Product"))
        {
            listPd.add((ProductData) pdb);
        }

        return listPd;
    }

    public static ProductData findById(String id,String ownerId){
        ProductData pd = null;
        DynamoDBMapper mapper = TableMethod.getMapper();

        try {
            pd = mapper.load(ProductData.class,id,ownerId);
        }
        catch (Exception e) {
            System.err.println("故障:");
            System.err.println(e.getMessage());
            System.err.println("故障打印结束!");
        }

        return pd;
    }

    public static List<ProductData> saveAll(List<ProductData> pds){
        DynamoDBMapper mapper = TableMethod.getMapper();

        try {
            TransactionWriteRequest twr = new TransactionWriteRequest();

            for (ProductData pd : pds) {
                Map<String, AttributeValue> eav = new HashMap<>();
                eav.put(":idStr", new AttributeValue(pd.getId()));
                eav.put(":ownerIdStr", new AttributeValue(pd.getOwnerId()));

                DynamoDBTransactionWriteExpression twe = new DynamoDBTransactionWriteExpression()
                        .withExpressionAttributeValues(eav)
                        .withConditionExpression("id <> :idStr OR ownerId <> :ownerIdStr");

                twr.addPut(pd, twe);
            }

            mapper.transactionWrite(twr);
        }
        catch (Exception e) {
            System.err.println("故障:项目已存在");
            System.err.println(e.getMessage());
            System.err.println("故障打印结束!");
        }

        return pds;
    }

    public static ProductData save(ProductData pd){
        DynamoDBMapper mapper = TableMethod.getMapper();

        try {
            Map<String, AttributeValue> eav = new HashMap<>();
            eav.put(":idStr", new AttributeValue(pd.getId()));
            eav.put(":ownerIdStr", new AttributeValue(pd.getOwnerId()));

            DynamoDBTransactionWriteExpression twe = new DynamoDBTransactionWriteExpression()
                    .withExpressionAttributeValues(eav)
                    .withConditionExpression("id <> :idStr OR ownerId <> :ownerIdStr");

            TransactionWriteRequest twr = new TransactionWriteRequest();
            twr.addPut(pd, twe);

            mapper.transactionWrite(twr);
        }
        catch (Exception e) {
            System.err.println("故障:项目已存在");
            System.err.println(e.getMessage());
            System.err.println("故障打印结束!");
        }

        return pd;
    }
}
