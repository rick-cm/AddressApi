package com.rcm.addressapi.rest.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserRequestDto {

    @NotBlank(message = "The name field is required")
    private String name;

    @NotBlank(message = "The e-mail field is required")
    private String email;

    @NotBlank(message = "The cpf field is required")
    private String cpf;

    @NotBlank(message = "The birth date field is required")
    private String birthDate;

    public UserRequestDto(@NotBlank(message = "The name field is required") String name,
                          @NotBlank(message = "The e-mail field is required") String email,
                          @NotBlank(message = "The cpf field is required") String cpf,
                          @NotNull(message = "The birth date field is required") String birthDate) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public UserRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
