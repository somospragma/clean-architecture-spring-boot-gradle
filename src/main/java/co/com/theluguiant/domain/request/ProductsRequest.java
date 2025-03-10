package co.com.theluguiant.domain.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductsRequest {

    @NotBlank(message = "name is mandatory")
    @Pattern(regexp = "^[ a-zA-Z0-9_-]+$", message= "name is alphanumeric.")
    private String name;

    @NotBlank(message = "productType is mandatory")
    private String productType;

    @Min(value = 1)
    @NotNull(message = "value is mandatory")
    @Positive(message = "value must be positive")
    private BigDecimal value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ProductsRequest{" +
                "name='" + name + '\'' +
                ", productType='" + productType + '\'' +
                ", value=" + value +
                '}';
    }
}