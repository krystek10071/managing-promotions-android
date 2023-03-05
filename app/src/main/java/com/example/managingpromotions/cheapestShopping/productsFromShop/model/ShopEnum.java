package com.example.managingpromotions.cheapestShopping.productsFromShop.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets ShopEnum
 */
public enum ShopEnum {

    ELECLERC("ELECLERC"),

    CARREFOUR("CARREFOUR"),

    AUCHAN("AUCHAN"),

    GROSZEK("GROSZEK");

    private String value;

    ShopEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static ShopEnum fromValue(String value) {
        for (ShopEnum b : ShopEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}


