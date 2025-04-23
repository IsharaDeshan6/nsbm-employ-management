package com.em.nsbmemploymanagement.service;

import com.em.nsbmemploymanagement.dto.request.LoginRequestDTO;

import java.util.Optional;

public interface AuthService {

    Optional<String> authenticate(LoginRequestDTO loginRequestDTO);

    boolean validateToken(String token);

}
