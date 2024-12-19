package com.example.Authtentication.DTO;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@ToString
public class MahasiswaRequest {

    private String id;
    private String name;
    private String nik;
    private Integer age;
}
