package com.example.Authtentication.Controller;

import com.example.Authtentication.DTO.LoginRequest;
import com.example.Authtentication.DTO.LoginResponse;
import com.example.Authtentication.DTO.RegisterRequest;
import com.example.Authtentication.DTO.RegisterResponse;
import com.example.Authtentication.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){
        RegisterResponse registerResponse = authenticationService.register(registerRequest);

        return ResponseEntity.status(HttpStatus.OK).body(registerResponse);

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = authenticationService.login(loginRequest);
        return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
    }



}
