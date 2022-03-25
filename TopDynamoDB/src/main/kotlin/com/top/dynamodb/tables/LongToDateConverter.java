package com.top.dynamodb.tables;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.util.Date;

public class LongToDateConverter implements DynamoDBTypeConverter<Long, Date> {
    @Override
    public Long convert(Date object) {
        Long awsItem = null;
        try {
            if (object != null) {
                awsItem = object.getTime();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return awsItem;
    }

    @Override
    public Date unconvert(Long object) {
        Date item = new Date();
        try {
            if (object != null) {
                item = new Date(object);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }
}
