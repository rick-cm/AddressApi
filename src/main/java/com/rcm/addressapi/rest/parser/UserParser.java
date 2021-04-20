package com.rcm.addressapi.rest.parser;

import com.rcm.addressapi.domain.entity.User;
import com.rcm.addressapi.rest.dto.UserRequestDto;

import java.time.LocalDate;

public class UserParser {

    public static UserParser getInstance(){return new UserParser();}

    public User entityFromRequest(UserRequestDto dto){
        User user = new User(dto.getName(), dto.getEmail(), dto.getCpf(), LocalDate.parse(dto.getBirthDate()));
        user.setId(null);
        return user;
    }
}
