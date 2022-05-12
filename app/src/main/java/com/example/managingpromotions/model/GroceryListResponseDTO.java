package com.example.managingpromotions.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import io.swagger.annotations.ApiModelProperty;

public class GroceryListResponseDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("createDate")
    private Date createDate;

    @JsonProperty("modifyDate")
    private Date modifyDate;

    @JsonProperty("products")
    @Valid
    private List<GroceryListProductDTO> products = null;

    public GroceryListResponseDTO id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     */
    @ApiModelProperty(value = "")


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GroceryListResponseDTO name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */
    @ApiModelProperty(value = "")


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroceryListResponseDTO createDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    /**
     * Get createDate
     *
     * @return createDate
     */
    @ApiModelProperty(value = "")

    @Valid

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public GroceryListResponseDTO modifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
        return this;
    }

    /**
     * Get modifyDate
     *
     * @return modifyDate
     */
    @ApiModelProperty(value = "")

    @Valid

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public GroceryListResponseDTO products(List<GroceryListProductDTO> products) {
        this.products = products;
        return this;
    }

    public GroceryListResponseDTO addProductsItem(GroceryListProductDTO productsItem) {
        if (this.products == null) {
            this.products = new ArrayList<GroceryListProductDTO>();
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
        GroceryListResponseDTO groceryListResponseDTO = (GroceryListResponseDTO) o;
        return Objects.equals(this.id, groceryListResponseDTO.id) &&
                Objects.equals(this.name, groceryListResponseDTO.name) &&
                Objects.equals(this.createDate, groceryListResponseDTO.createDate) &&
                Objects.equals(this.modifyDate, groceryListResponseDTO.modifyDate) &&
                Objects.equals(this.products, groceryListResponseDTO.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createDate, modifyDate, products);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GroceryListResponseDTO {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    createDate: ").append(toIndentedString(createDate)).append("\n");
        sb.append("    modifyDate: ").append(toIndentedString(modifyDate)).append("\n");
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
