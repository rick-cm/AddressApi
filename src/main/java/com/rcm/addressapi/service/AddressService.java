package com.rcm.addressapi.service;

import com.rcm.addressapi.domain.entity.Address;
import com.rcm.addressapi.domain.entity.User;
import com.rcm.addressapi.domain.repository.AddressRepository;
import com.rcm.addressapi.domain.repository.UserRepository;
import com.rcm.addressapi.exception.BadRequestException;
import com.rcm.addressapi.rest.dto.AddressRequestDto;
import com.rcm.addressapi.rest.dto.ViaCepDto;
import com.rcm.addressapi.rest.parser.AddressParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AddressService {

    private final UserRepository userRepository;
    private final AddressRepository repository;
    private final ViaCepService viaCepService;

    public AddressService(ViaCepService viaCepService, UserRepository userRepository, AddressRepository repository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.viaCepService = viaCepService;
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(AddressRequestDto dto){
        Address address = AddressParser.getInstance().entityFromRequest(dto);
        validateRules(address);
        address = AddressParser.getInstance().mergeFromViaCepDto(address,getFromViaCep(address.getZipCode()));
        repository.save(address);
    }

    private ViaCepDto getFromViaCep(String zipCode){
        ViaCepDto dto = viaCepService.getAddress(zipCode);
        if(dto.getCep() == null) throw new BadRequestException("The zip code is invalid.");
        return dto;
    }

    private void validateRules(Address address){
        validateZipCodeFormat(address.getZipCode());
        Optional<User> userFromDB = userRepository.findById(address.getUser().getId());
        if(userFromDB.isEmpty()){
            throw new BadRequestException("User not found.");
        }
    }

    private void validateZipCodeFormat(String zipCode){
        try {
            Long zipCodeNumber = Long.valueOf(zipCode);
        }catch (NumberFormatException exception){
            throw new BadRequestException("The zip code format must contain only numbers.");
        }
    }
}
