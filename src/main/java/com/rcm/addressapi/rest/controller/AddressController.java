package com.rcm.addressapi.rest.controller;

import com.rcm.addressapi.error.ErrorDetail;
import com.rcm.addressapi.error.ValidationErrorDetail;
import com.rcm.addressapi.exception.BadRequestException;
import com.rcm.addressapi.rest.dto.AddressRequestDto;
import com.rcm.addressapi.service.AddressService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @PostMapping
    @ApiOperation("Create a address")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Address created", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ValidationErrorDetail.class)
    })
    public ResponseEntity create(@Valid @RequestBody AddressRequestDto dto){
        this.service.create(dto);
        return ResponseEntity.status(201).build();
    }
}

