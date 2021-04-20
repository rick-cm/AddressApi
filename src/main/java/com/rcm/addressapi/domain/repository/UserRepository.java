package com.rcm.addressapi.domain.repository;

import com.rcm.addressapi.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByCpfOrEmail(String cpf, String email);
}
