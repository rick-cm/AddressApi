package com.rcm.addressapi.service;

import com.rcm.addressapi.domain.entity.User;
import com.rcm.addressapi.domain.repository.UserRepository;
import com.rcm.addressapi.exception.BadRequestException;
import com.rcm.addressapi.exception.ResourceNotFoundException;
import com.rcm.addressapi.rest.dto.UserRequestDto;
import com.rcm.addressapi.rest.parser.UserParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(UserRequestDto dto){
        User user = UserParser.getInstance().entityFromRequest(dto);
        validateRules(user);
        repository.save(user);
    }

    public User getById(Long id){
        return repository.findById(id).orElseThrow(() -> {throw new ResourceNotFoundException("User not found.");});
    }

    public void validateRules(User user){
        Optional<User> userFromDB = repository.findByCpfOrEmail(user.getCpf(), user.getEmail());
        if(userFromDB.isPresent()){
            throw new BadRequestException("Email or CPF already registered.");
        }
    }
}
