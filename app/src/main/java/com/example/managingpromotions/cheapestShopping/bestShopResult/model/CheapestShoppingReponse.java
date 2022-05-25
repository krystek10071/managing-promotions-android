package com.example.managingpromotions.cheapestShopping.bestShopResult.model;

import com.example.managingpromotions.cheapestShopping.productsFromShop.model.ParsedProductDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import io.swagger.annotations.ApiModelProperty;

public class CheapestShoppingReponse {
    @JsonProperty("shopName")
    private String shopName;

    @JsonProperty("groceryListId")
    private Long groceryListId;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("products")
    @Valid
    private List<ParsedProductDTO> products = null;

    public CheapestShoppingReponse shopName(String shopName) {
        this.shopName = shopName;
        return this;
    }

    /**
     * Get shopName
     *
     * @return shopName
     */
    @ApiModelProperty(value = "")


    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public CheapestShoppingReponse groceryListId(Long groceryListId) {
        this.groceryListId = groceryListId;
        return this;
    }

    /**
     * Get groceryListId
     *
     * @return groceryListId
     */
    @ApiModelProperty(value = "")


    public Long getGroceryListId() {
        return groceryListId;
    }

    public void setGroceryListId(Long groceryListId) {
        this.groceryListId = groceryListId;
    }

    public CheapestShoppingReponse price(BigDecimal price) {
        this.price = price;
        return this;
    }

    /**
     * Get price
     *
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

    public CheapestShoppingReponse products(List<ParsedProductDTO> products) {
        this.products = products;
        return this;
    }

    public CheapestShoppingReponse addProductsItem(ParsedProductDTO productsItem) {
        if (this.products == null) {
            this.products = new ArrayList<ParsedProductDTO>();
        }
        this.products.add(productsItem);
        return this;
    }

    /**
     * Get products
     *
     * @return products
     */
    @ApiModelProperty(value = "")

    @Valid

    public List<ParsedProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ParsedProductDTO> products) {
        this.products = products;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CheapestShoppingReponse cheapestShoppingReponse = (CheapestShoppingReponse) o;
        return Objects.equals(this.shopName, cheapestShoppingReponse.shopName) &&
                Objects.equals(this.groceryListId, cheapestShoppingReponse.groceryListId) &&
                Objects.equals(this.price, cheapestShoppingReponse.price) &&
                Objects.equals(this.products, cheapestShoppingReponse.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopName, groceryListId, price, products);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CheapestShoppingReponse {\n");

        sb.append("    shopName: ").append(toIndentedString(shopName)).append("\n");
        sb.append("    groceryListId: ").append(toIndentedString(groceryListId)).append("\n");
        sb.append("    price: ").append(toIndentedString(price)).append("\n");
        sb.append("    products: ").append(toIndentedString(products)).append("\n");
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

