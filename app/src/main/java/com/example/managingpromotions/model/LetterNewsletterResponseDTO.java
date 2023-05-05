package com.example.managingpromotions.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.Valid;

import io.swagger.annotations.ApiModelProperty;

public class LetterNewsletterResponseDTO implements Serializable {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("shopName")
    private ShopEnum shopName;

    @JsonProperty("fileName")
    private String fileName;

    @JsonProperty("extension")
    private String extension;

    @JsonProperty("startDate")
    private String startDate;

    @JsonProperty("endDate")
    private String endDate;

    public LetterNewsletterResponseDTO id(Long id) {
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

    public LetterNewsletterResponseDTO shopName(ShopEnum shopName) {
        this.shopName = shopName;
        return this;
    }

    /**
     * Get shopName
     *
     * @return shopName
     */
    @ApiModelProperty(value = "")

    @Valid

    public ShopEnum getShopName() {
        return shopName;
    }

    public void setShopName(ShopEnum shopName) {
        this.shopName = shopName;
    }

    public LetterNewsletterResponseDTO fileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    /**
     * Get fileName
     *
     * @return fileName
     */
    @ApiModelProperty(value = "")


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LetterNewsletterResponseDTO extension(String extension) {
        this.extension = extension;
        return this;
    }

    /**
     * Get extension
     *
     * @return extension
     */
    @ApiModelProperty(value = "")


    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public LetterNewsletterResponseDTO startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Get startDate
     *
     * @return startDate
     */
    @ApiModelProperty(value = "")


    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public LetterNewsletterResponseDTO endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Get endDate
     *
     * @return endDate
     */
    @ApiModelProperty(value = "")


    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LetterNewsletterResponseDTO letterNewsletterResponseDTO = (LetterNewsletterResponseDTO) o;
        return Objects.equals(this.id, letterNewsletterResponseDTO.id) &&
                Objects.equals(this.shopName, letterNewsletterResponseDTO.shopName) &&
                Objects.equals(this.fileName, letterNewsletterResponseDTO.fileName) &&
                Objects.equals(this.extension, letterNewsletterResponseDTO.extension) &&
                Objects.equals(this.startDate, letterNewsletterResponseDTO.startDate) &&
                Objects.equals(this.endDate, letterNewsletterResponseDTO.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shopName, fileName, extension, startDate, endDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LetterNewsletterResponseDTO {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    shopName: ").append(toIndentedString(shopName)).append("\n");
        sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
        sb.append("    extension: ").append(toIndentedString(extension)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
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

