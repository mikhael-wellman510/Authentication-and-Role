package com.example.Authtentication.Service;

import com.example.Authtentication.DTO.LoginRequest;
import com.example.Authtentication.DTO.LoginResponse;
import com.example.Authtentication.DTO.RegisterRequest;
import com.example.Authtentication.DTO.RegisterResponse;

public interface AuthenticationService {

    RegisterResponse register(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);
}
