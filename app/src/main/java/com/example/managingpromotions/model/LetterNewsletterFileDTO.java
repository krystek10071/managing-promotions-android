package com.example.managingpromotions.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.Valid;

import io.swagger.annotations.ApiModelProperty;

public class LetterNewsletterFileDTO implements Serializable {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("shopName")
    private ShopEnum shopName;

    @JsonProperty("fileName")
    private String fileName;

    @JsonProperty("extension")
    private String extension;

    @JsonProperty("file")
    private String file;

    public LetterNewsletterFileDTO id(Long id) {
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

    public LetterNewsletterFileDTO shopName(ShopEnum shopName) {
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

    public LetterNewsletterFileDTO fileName(String fileName) {
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

    public LetterNewsletterFileDTO extension(String extension) {
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

    public LetterNewsletterFileDTO file(String file) {
        this.file = file;
        return this;
    }

    /**
     * Get file
     *
     * @return file
     */
    @ApiModelProperty(value = "")


    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LetterNewsletterFileDTO letterNewsletterFileDTO = (LetterNewsletterFileDTO) o;
        return Objects.equals(this.id, letterNewsletterFileDTO.id) &&
                Objects.equals(this.shopName, letterNewsletterFileDTO.shopName) &&
                Objects.equals(this.fileName, letterNewsletterFileDTO.fileName) &&
                Objects.equals(this.extension, letterNewsletterFileDTO.extension) &&
                Objects.equals(this.file, letterNewsletterFileDTO.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shopName, fileName, extension, file);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LetterNewsletterFileDTO {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    shopName: ").append(toIndentedString(shopName)).append("\n");
        sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
        sb.append("    extension: ").append(toIndentedString(extension)).append("\n");
        sb.append("    file: ").append(toIndentedString(file)).append("\n");
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
