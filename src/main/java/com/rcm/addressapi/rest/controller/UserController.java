package com.rcm.addressapi.rest.controller;

import com.rcm.addressapi.domain.entity.User;
import com.rcm.addressapi.error.ValidationErrorDetail;
import com.rcm.addressapi.rest.dto.UserRequestDto;
import com.rcm.addressapi.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a user")
    @ApiResponses({
            @ApiResponse(code = 200, message = "", response = User.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ValidationErrorDetail.class)
    })
    public ResponseEntity get(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getById(id));
    }

    @PostMapping
    @ApiOperation("Create a user")
    @ApiResponses({
            @ApiResponse(code = 201, message = "User created", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ValidationErrorDetail.class)
    })
    public ResponseEntity create(@Valid @RequestBody UserRequestDto dto){
        this.service.create(dto);
        return ResponseEntity.status(201).build();
    }
}
