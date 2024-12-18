package com.example.Authtentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
* Dokumentasi -> https://medium.com/@tericcabrel/implement-jwt-authentication-in-a-spring-boot-3-application-5839e4fd8fac
* */

@SpringBootApplication
public class AuthtenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthtenticationApplication.class, args);
		System.out.println("Runing in 8080");
	}

}