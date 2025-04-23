package com.em.nsbmemploymanagement.service.impl;

import com.em.nsbmemploymanagement.entity.User;
import com.em.nsbmemploymanagement.repository.UserRepository;
import com.em.nsbmemploymanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> findByEmail(String email) {
      return userRepository.findByEmail(email);
    }
}
