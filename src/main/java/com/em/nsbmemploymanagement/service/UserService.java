package com.em.nsbmemploymanagement.service;

import com.em.nsbmemploymanagement.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmail(String email);
}
