package com.example.Authtentication.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MahasiswaControllerExample {

    @GetMapping("/dataMahasiswa/test")
    @PreAuthorize("hasRole('MAHASISWA')")
    public String getdataMhs(){
        return "Mhs Only";
    }

    @GetMapping("/dataMahasiswa/cek")
    @PreAuthorize("hasRole('MAHASISWA')")
    public String getdataMhsNew(){
        return "Mhs Only new";
    }

}
