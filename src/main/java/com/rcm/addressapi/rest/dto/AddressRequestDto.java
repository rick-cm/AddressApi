package com.rcm.addressapi.rest.dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddressRequestDto {

    @NotBlank(message = "The public place field is required")
    private String publicPlace;

    @NotBlank(message = "The number field is required")
    private String number;

    @NotBlank(message = "The complement field is required")
    private String complement;

    @NotBlank(message = "The district field is required")
    private String district;

    @NotBlank(message = "The city field is required")
    private String city;

    @NotBlank(message = "The state field is required")
    private String state;

    @Length(min = 8, max = 8, message = "The zip code must contain 8 numbers")
    @NotBlank(message = "The zip code field is required")
    private String zipCode;

    @NotNull(message = "The user field is required")
    private long user;

    public AddressRequestDto(@NotBlank(message = "The public place field is required") String publicPlace,
                             @NotBlank(message = "The number field is required") String number,
                             @NotBlank(message = "The complement field is required") String complement,
                             @NotBlank(message = "The district field is required") String district,
                             @NotBlank(message = "The city field is required") String city,
                             @NotBlank(message = "The state field is required") String state,
                             @NotBlank(message = "The zip code field is required") String zipCode,
                             @NotBlank(message = "The user field is required") long user) {
        this.publicPlace = publicPlace;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.user = user;
    }

    public AddressRequestDto() {
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }
}
