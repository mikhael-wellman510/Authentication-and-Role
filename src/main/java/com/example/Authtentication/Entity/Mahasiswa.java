package com.example.Authtentication.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "m_mahasiswa")
@Builder(toBuilder = true)
public class Mahasiswa extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String nik;
    private Integer age;



}
