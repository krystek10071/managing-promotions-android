package com.example.managingpromotions.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class RegistrationCredentials {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("passwordConfirmation")
    private String passwordConfirmation;

    public RegistrationCredentials username(String username) {
        this.username = username;
        return this;
    }

    /**
     * Get username
     *
     * @return username
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public RegistrationCredentials password(String password) {
        this.password = password;
        return this;
    }

    /**
     * Get password
     *
     * @return password
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RegistrationCredentials passwordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
        return this;
    }

    /**
     * Get passwordConfirmation
     *
     * @return passwordConfirmation
     */
    @ApiModelProperty(required = true, value = "")
    @NotNull


    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RegistrationCredentials registrationCredentials = (RegistrationCredentials) o;
        return Objects.equals(this.username, registrationCredentials.username) &&
                Objects.equals(this.password, registrationCredentials.password) &&
                Objects.equals(this.passwordConfirmation, registrationCredentials.passwordConfirmation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, passwordConfirmation);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RegistrationCredentials {\n");

        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    passwordConfirmation: ").append(toIndentedString(passwordConfirmation)).append("\n");
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
