package com.example.Authtentication.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@ToString
public class RegisterResponse {
    private String id;
    private String fullName;
    private String email;
    private String password;
    private String department;
    private String role;
    private Integer age;
    private String address;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
