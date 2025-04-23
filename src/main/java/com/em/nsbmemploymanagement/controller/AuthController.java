package com.em.nsbmemploymanagement.controller;

import com.em.nsbmemploymanagement.dto.request.LoginRequestDTO;
import com.em.nsbmemploymanagement.dto.response.LoginResponseDTO;
import com.em.nsbmemploymanagement.service.AuthService;
import com.em.nsbmemploymanagement.util.StandardResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Tag(name = "Auth", description = "Authentication and Authorization")
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "Generate token on user login")
    @PostMapping("/login")
    public ResponseEntity<StandardResponse> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        Optional<String> tokenOptional = authService.authenticate(loginRequestDTO);

        if (tokenOptional.isEmpty()) {
            return new ResponseEntity<>(
                    new StandardResponse(401, "Invalid username or password", null),
                    HttpStatus.UNAUTHORIZED
            );
        }

        String token = tokenOptional.get();
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO(token);
        return new ResponseEntity<>(
                new StandardResponse(200, "Login successful", loginResponseDTO),
                HttpStatus.OK
        );
    }


}
