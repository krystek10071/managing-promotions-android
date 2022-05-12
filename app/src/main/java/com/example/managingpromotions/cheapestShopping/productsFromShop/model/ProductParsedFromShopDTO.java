package com.example.managingpromotions.cheapestShopping.productsFromShop.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import io.swagger.annotations.ApiModelProperty;

public class ProductParsedFromShopDTO   {
    @JsonProperty("shopName")
    private String shopName;

    @JsonProperty("groceryListId")
    private Long groceryListId;

    @JsonProperty("products")
    @Valid
    private List<ParsedProductDTO> products = null;

    public ProductParsedFromShopDTO shopName(String shopName) {
        this.shopName = shopName;
        return this;
    }

    /**
     * Get shopName
     * @return shopName
     */
    @ApiModelProperty(value = "")


    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public ProductParsedFromShopDTO groceryListId(Long groceryListId) {
        this.groceryListId = groceryListId;
        return this;
    }

    /**
     * Get groceryListId
     * @return groceryListId
     */
    @ApiModelProperty(value = "")


    public Long getGroceryListId() {
        return groceryListId;
    }

    public void setGroceryListId(Long groceryListId) {
        this.groceryListId = groceryListId;
    }

    public ProductParsedFromShopDTO products(List<ParsedProductDTO> products) {
        this.products = products;
        return this;
    }

    public ProductParsedFromShopDTO addProductsItem(ParsedProductDTO productsItem) {
        if (this.products == null) {
            this.products = new ArrayList<ParsedProductDTO>();
        }
        this.products.add(productsItem);
        return this;
    }

    /**
     * Get products
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
        ProductParsedFromShopDTO productParsedFromShopDTO = (ProductParsedFromShopDTO) o;
        return Objects.equals(this.shopName, productParsedFromShopDTO.shopName) &&
                Objects.equals(this.groceryListId, productParsedFromShopDTO.groceryListId) &&
                Objects.equals(this.products, productParsedFromShopDTO.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopName, groceryListId, products);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductParsedFromShopDTO {\n");

        sb.append("    shopName: ").append(toIndentedString(shopName)).append("\n");
        sb.append("    groceryListId: ").append(toIndentedString(groceryListId)).append("\n");
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
