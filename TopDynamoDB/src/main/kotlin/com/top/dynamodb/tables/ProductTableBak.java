package com.top.dynamodb.tables;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.top.data.models.resources.product.ProductData;

public class ProductTableBak {

    public static void main(String[] args) {

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
            System.err.println("π ’œ:");
            System.err.println(e.getMessage());
            System.err.println("π ’œ¥Ú”°Ω· ¯!");
        }

        return pd;
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
            System.err.println("π ’œ:");
            System.err.println(e.getMessage());
            System.err.println("π ’œ¥Ú”°Ω· ¯!");
        }

        return item;
    }
}
