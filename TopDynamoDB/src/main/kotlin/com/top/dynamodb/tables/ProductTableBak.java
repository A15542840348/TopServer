package com.top.dynamodb.tables;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.ScanResultPage;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.top.data.models.common.Page;
import com.top.data.models.common.Pageable;
import com.top.data.models.common.SortDirection;
import com.top.data.models.resources.product.ProductData;

import java.lang.reflect.Field;
import java.util.*;

public class ProductTableBak {

    public static void main(String[] args) {

    }

    //override fun findAll(pageable: Pageable): Page<Product>
    public static Page<ProductData> findAll(Pageable pageable){
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

            //总结果除以每页个数 + 1，不足加1
            pg.setTotalPages((int) Math.ceil((double)pdPage.getCount() / (double)pageable.getPageSize()));
            pg.setTotalElements(pdPage.getCount());
            pg.setTotalElements(pdPage.getCount());
            //复制
            List<Product> pds = new ArrayList<>();
            int loopTime = Math.min(pdPage.getCount(),pageable.getPageNumber()* pageable.getPageSize());//剩下的不足pageSize个，显示剩下所有元素
            int loopInit = (pageable.getPageNumber() - 1) * pageable.getPageSize();//当前页起始数据下标为前面页含有元素个数
            for(int i = loopInit; i < loopTime;i++) {
                pds.add(pdPage.getResults().get(i));
            }
            pg.setData(pds);
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

    public void deleteAllById(List<String> ids){
        DynamoDBMapper mapper = TableMethod.getMapper();

        try {
            List<ProductData> pds = findAllById(ids);
            mapper.batchDelete(pds);
        }
        catch (Exception e) {
            System.err.println("Unable to delete item ");
            System.err.println(e.getMessage());
        }
    }

    public void deleteById(String id){
        try {
            ProductData pd = findById(id);
            delete(pd);
        }
        catch (Exception e) {
            System.err.println("Unable to delete item ");
            System.err.println(e.getMessage());
        }
    }

    public void delete(ProductData pd){
        DynamoDBMapper mapper = TableMethod.getMapper();

        try {
            mapper.delete(pd);
        }
        catch (Exception e) {
            System.err.println("Unable to delete item: ");
            System.err.println(e.getMessage());
        }
    }

    public List<ProductData> updateAll(List<ProductData> items){
        return saveAll(items);
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

    public static Boolean existsById(String id){
        ProductData pd = findById(id);

        return pd != null;
    }

    //返回符合条件的所有信息
    public static List<ProductData> findAllById(List<String> ids)
    {
        List<ProductData> pds = new ArrayList<>();
        DynamoDBMapper mapper = TableMethod.getMapper();

        try {
            HashMap<String, AttributeValue> eav = new HashMap<>();

            eav.put(":val0", new AttributeValue().withS(ids.get(0)));
            StringBuilder filterExperssion = new StringBuilder("id = :val0");

            for(int i = 1;i < ids.size();i++) {
                eav.put(":val" + i, new AttributeValue().withS(ids.get(i)));
                filterExperssion.append(" or id = :val").append(i);
            }

            DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                    .withFilterExpression(String.valueOf(filterExperssion))
                    .withExpressionAttributeValues(eav);

            pds =  mapper.scan(ProductData.class, scanExpression);

            System.out.println(pds.toString());
        }
        catch (Exception e) {
            System.err.println("故障2:");
            System.err.println(e.getMessage());
            System.err.println("故障打印结束!");
        }

        return pds;
    }

    //返回查询到的第一条数据
    public static ProductData findById(String id)
    {
        ProductData pd = null;
        DynamoDBMapper mapper = TableMethod.getMapper();

        try {
            HashMap<String, AttributeValue> eav = new HashMap<>();
            eav.put(":val1", new AttributeValue().withS(id));

            DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                    .withFilterExpression("id = :val1")
                    .withExpressionAttributeValues(eav);

            List<ProductData> pds =  mapper.scan(ProductData.class, scanExpression);

            pd = pds.get(1);

            System.out.println(pd.toString());
        }
        catch (Exception e) {
            System.err.println("故障2:");
            System.err.println(e.getMessage());
            System.err.println("故障打印结束!");
            return pd;
        }

        return pd;
    }

    public List<ProductData> findAllByIdOwnerId(List<String> ids,List<String> ownerIds){
        List<ProductData> listPd = new ArrayList<>();

        for(int i = 0;i < ids.size();i++){
            listPd.add(findByIdOwnerId(ids.get(i), ownerIds.get(i)));
        }

        return listPd;
    }

    public static ProductData findByIdOwnerId(String id,String ownerId){
        ProductData pd = null;
        DynamoDBMapper mapper = TableMethod.getMapper();

        try {
            pd = mapper.load(ProductData.class,id,ownerId);

            System.out.println(pd.toString());
        }
        catch (Exception e) {
            System.err.println("故障2:");
            System.err.println(e.getMessage());
            System.err.println("故障打印结束!");
        }

        return pd;
    }

    public ProductData update(ProductData pd){
        DynamoDBMapper mapper = TableMethod.getMapper();

        try {
            DynamoDBSaveExpression de = new DynamoDBSaveExpression()
                    .withConditionalOperator("condition-expression ::= Id = " + pd.getId());
            //https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Expressions.OperatorsAndFunctions.html

            mapper.save(pd,de);
        }
        catch (Exception e) {
            System.err.println("故障:");
            System.err.println(e.getMessage());
            System.err.println("故障打印结束!");
        }

        return pd;
    }

    public static List<ProductData> saveAll(List<ProductData> items){
        DynamoDBMapper mapper = TableMethod.getMapper();

        try {
            mapper.batchSave(items);
        }
        catch (Exception e) {
            System.err.println("故障:");
            System.err.println(e.getMessage());
            System.err.println("故障打印结束!");
        }

        return items;
    }

    public static ProductData save(ProductData item){
        DynamoDBMapper mapper = TableMethod.getMapper();

        try {
            DynamoDBSaveExpression de = new DynamoDBSaveExpression()
                    .withConditionalOperator("condition-expression ::= Id <> " + item.getId())
                    .withConditionalOperator("condition-expression ::= ownerId <> " + item.getOwnerId());

            mapper.save(item,de);
        }
        catch (Exception e) {
            System.err.println("故障:");
            System.err.println(e.getMessage());
            System.err.println("故障打印结束!");
        }

        return item;
    }
}
