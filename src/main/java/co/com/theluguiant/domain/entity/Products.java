package co.com.theluguiant.domain.entity;

import co.com.theluguiant.utils.custom_exceptions.InvalidValueException;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.math.BigDecimal;

@DynamoDbBean
public class Products {

    private String idProduct;
    private String name;
    private String productType;
    private String status;
    private BigDecimal value;
    private String createdDate;
    private double discount;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("idProduct")
    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    @DynamoDbAttribute("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDbAttribute("status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @DynamoDbAttribute("productType")
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @DynamoDbAttribute("value")
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("createdDate")
    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @DynamoDbAttribute("discount")
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    // Logica de negocio
    public void applyDiscount(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new InvalidValueException("Discount percentage must be between 0 and 100");
        }
        this.discount = discountPercentage;
        double valueWithDiscount = this.value.doubleValue() - (this.value.doubleValue() * (discountPercentage / 100));
        this.value = BigDecimal.valueOf(valueWithDiscount);
    }

    public void validateValue() {
        if (  1000 > this.value.intValue()) {
            throw new InvalidValueException("Value is never 0");
        }
    }

    @Override
    public String toString() {
        return "Products{" +
                "idProduct='" + idProduct + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", productType='" + productType + '\'' +
                ", value=" + value +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }
}
