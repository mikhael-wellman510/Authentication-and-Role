package com.example.Authtentication.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminControllerExample {

    @GetMapping("/dataAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin(){
        return "Admin Only";
    }

    @GetMapping("/dataAdmin/cek")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminCek(){
        return "Admin Only";
    }

}
