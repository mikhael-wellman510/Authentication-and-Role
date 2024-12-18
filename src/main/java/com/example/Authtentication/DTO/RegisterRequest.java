package com.example.Authtentication.DTO;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@ToString
public class RegisterRequest {

    private String fullName;
    private String email;
    private String password;
    private String department;
    private String role;
    private Integer age;
    private String address;

}
