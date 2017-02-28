package com.iqmsoft.security.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iqmsoft.security.boot.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmail(String email);
}
