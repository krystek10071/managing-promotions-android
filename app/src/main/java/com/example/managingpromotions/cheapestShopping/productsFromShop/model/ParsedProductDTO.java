package com.example.managingpromotions.cheapestShopping.productsFromShop.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.validation.Valid;

import io.swagger.annotations.ApiModelProperty;

public class ParsedProductDTO implements Serializable {
    @JsonProperty("name")
    private String name;

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("amount")
    private Integer amount = null;

    @JsonProperty("price")
    private BigDecimal price;

    public ParsedProductDTO name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * @return name
     */
    @ApiModelProperty(value = "")


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParsedProductDTO unit(String unit) {
        this.unit = unit;
        return this;
    }

    /**
     * Get unit
     * @return unit
     */
    @ApiModelProperty(value = "")


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public ParsedProductDTO amount(Integer amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Get amount
     * @return amount
     */
    @ApiModelProperty(value = "")


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public ParsedProductDTO price(BigDecimal price) {
        this.price = price;
        return this;
    }

    /**
     * Get price
     * @return price
     */
    @ApiModelProperty(value = "")

    @Valid

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ParsedProductDTO parsedProductDTO = (ParsedProductDTO) o;
        return Objects.equals(this.name, parsedProductDTO.name) &&
                Objects.equals(this.unit, parsedProductDTO.unit) &&
                Objects.equals(this.amount, parsedProductDTO.amount) &&
                Objects.equals(this.price, parsedProductDTO.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, unit, amount, price);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ParsedProductDTO {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}


