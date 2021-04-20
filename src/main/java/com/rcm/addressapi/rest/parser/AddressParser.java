package com.rcm.addressapi.rest.parser;

import com.rcm.addressapi.domain.entity.Address;
import com.rcm.addressapi.domain.entity.User;
import com.rcm.addressapi.rest.dto.AddressRequestDto;
import com.rcm.addressapi.rest.dto.ViaCepDto;

public class AddressParser {

    public static AddressParser getInstance(){return new AddressParser();}

    public Address entityFromRequest(AddressRequestDto dto){
        User user = new User();
        user.setId(dto.getUser());
        Address address = new Address(null,dto.getPublicPlace(),
                dto.getNumber(),
                dto.getComplement(),
                dto.getDistrict(),
                dto.getCity(),
                dto.getState(),
                dto.getZipCode(),
                user);
        return address;
    }

    public Address mergeFromViaCepDto(Address entity, ViaCepDto dto){
        if(!dto.getLogradouro().equals(""))entity.setPublicPlace(dto.getLogradouro());
        if(!dto.getBairro().equals(""))entity.setDistrict(dto.getBairro());
        if(!dto.getComplemento().equals(""))entity.setComplement(dto.getComplemento());
        if(!dto.getUf().equals(""))entity.setState(dto.getUf());
        if(!dto.getLocalidade().equals(""))entity.setCity(dto.getLocalidade());
        return entity;
    }


}
