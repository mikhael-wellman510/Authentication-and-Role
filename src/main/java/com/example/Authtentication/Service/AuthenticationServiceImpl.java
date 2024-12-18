package com.example.Authtentication.Service;

import com.example.Authtentication.DTO.LoginRequest;
import com.example.Authtentication.DTO.LoginResponse;
import com.example.Authtentication.DTO.RegisterRequest;
import com.example.Authtentication.DTO.RegisterResponse;
import com.example.Authtentication.Entity.User;
import com.example.Authtentication.Respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        User save = userRepository.save(User.builder()
                        .fullName(registerRequest.getFullName())
                        .email(registerRequest.getEmail())
                        .password(passwordEncoder.encode(registerRequest.getPassword()))
                        .department(registerRequest.getDepartment())
                        .role(registerRequest.getRole())
                        .age(registerRequest.getAge())
                        .address(registerRequest.getAddress())
                        .isActive(Boolean.TRUE)
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                .build());

        return RegisterResponse.builder()
                .id(save.getId())
                .fullName(save.getFullName())
                .email(save.getEmail())
                .password(save.getPassword())
                .department(save.getDepartment())
                .role(save.getRole())
                .age(save.getAge())
                .address(save.getAddress())
                .isActive(save.getIsActive())
                .createdAt(save.getCreatedAt())
                .updatedAt(save.getUpdatedAt())
                .build();
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        // Todo -> ini akan di arahkan ke application Configuration
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        // Todo -> dapatkan data untuk di generate ke JWT token
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElse(null);

        // Todo -> Kirim ke jwtService (generateToken)

        Map<String,Object> data =  new HashMap<>();
        data.put("fullName" , user.getFullName());
        data.put("department" , user.getDepartment());
        data.put("address" , user.getAddress());

        String token = jwtService.generateToken(user , data);


        return LoginResponse.builder()
                .token(token)
                .build();


    }
}
