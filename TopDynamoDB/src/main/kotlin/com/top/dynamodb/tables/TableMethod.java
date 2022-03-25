package com.top.dynamodb.tables;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverterFactory;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;

import java.util.Date;

public class TableMethod {
    private static AmazonDynamoDB DynamoDBClient;

    private static DynamoDB dynamoDB;

    private static DynamoDBMapper mapper;

    public static DynamoDB getClient(){
        if(DynamoDBClient == null)
        {
            DynamoDBClient = AmazonDynamoDBClientBuilder.standard()
                    .withRegion(Regions.US_EAST_2).build();
        }

        return dynamoDB;
    }

    public static DynamoDB getDynamoDB(){
        if(dynamoDB == null)
        {
            getClient();
            dynamoDB = new DynamoDB(DynamoDBClient);
        }

        return  dynamoDB;
    }

    public static Table getTable(String tableName){
        getDynamoDB();
        return dynamoDB.getTable(tableName);
    }

    public  static DynamoDBMapper getMapper(){
        if(mapper == null) {
            getClient();

            DynamoDBMapperConfig config = DynamoDBMapperConfig.builder()
                    .withTypeConverterFactory(DynamoDBTypeConverterFactory.standard().override()
                            .with(Long.class, Date.class, new LongToDateConverter())
                            .build())
                    .build();

            mapper = new DynamoDBMapper(DynamoDBClient,config);
        }

        return mapper;
    }
}
