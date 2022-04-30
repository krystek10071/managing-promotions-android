package com.example.managingpromotions.addGrocery.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

public class GroceryListProductDTO implements Serializable {
    @JsonProperty("name")
    private String name;

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("amount")
    private Integer amount = null;


    public GroceryListProductDTO name(String name) {
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

    public GroceryListProductDTO unit(String unit) {
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

    public GroceryListProductDTO amount(Integer amount) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GroceryListProductDTO groceryListProductDTO = (GroceryListProductDTO) o;
        return Objects.equals(this.name, groceryListProductDTO.name) &&
                Objects.equals(this.unit, groceryListProductDTO.unit) &&
                Objects.equals(this.amount, groceryListProductDTO.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, unit, amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GroceryListProductDTO {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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
