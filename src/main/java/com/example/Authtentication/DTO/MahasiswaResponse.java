package com.example.Authtentication.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@ToString
public class MahasiswaResponse {

    private String id;
    private String name;
    private String nik;
    private Integer age;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
