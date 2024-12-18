package com.example.Authtentication.DTO;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@ToString
public class LoginRequest {

    private String email;
    private String password;
}
