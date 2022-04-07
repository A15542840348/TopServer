import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.enhanced.dynamodb.internal.converter.attribute.EnhancedAttributeValue;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.Date;

class LongToDataConverter1 implements AttributeConverter<Date>{

    @Override
    public AttributeValue transformFrom(Date input) {
        return AttributeValue.builder().n(String.valueOf(input.getTime())).build();
    }

    @Override
    public Date transformTo(AttributeValue input) {

        if (input.n() != null) {
            return new Date(input.n());
        }

        return new Date(EnhancedAttributeValue.fromAttributeValue(input).toString());
//        return EnhancedAttributeValue.fromAttributeValue(input);
    }

    @Override
    public EnhancedType<Date> type() {
        return EnhancedType.of(Date.class);
    }

    @Override
    public AttributeValueType attributeValueType() {
        return AttributeValueType.N;
    }
}