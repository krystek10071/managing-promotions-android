package com.example.managingpromotions.addGrocery.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import io.swagger.annotations.ApiModelProperty;

public class GroceryListDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("userLogin")
    private String userLogin;

    @JsonProperty("products")
    @Valid
    private List<GroceryListProductDTO> products = null;

    public GroceryListDTO name(String name) {
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

    public GroceryListDTO userLogin(String userLogin) {
        this.userLogin = userLogin;
        return this;
    }

    /**
     * Get userLogin
     * @return userLogin
     */
    @ApiModelProperty(value = "")


    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public GroceryListDTO products(List<GroceryListProductDTO> products) {
        this.products = products;
        return this;
    }

    public GroceryListDTO addProductsItem(GroceryListProductDTO productsItem) {
        if (this.products == null) {
            this.products = new ArrayList<GroceryListProductDTO>();
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

    public List<GroceryListProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<GroceryListProductDTO> products) {
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
        GroceryListDTO groceryListDTO = (GroceryListDTO) o;
        return Objects.equals(this.name, groceryListDTO.name) &&
                Objects.equals(this.userLogin, groceryListDTO.userLogin) &&
                Objects.equals(this.products, groceryListDTO.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, userLogin, products);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GroceryListRequestDTO {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    userLogin: ").append(toIndentedString(userLogin)).append("\n");
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
