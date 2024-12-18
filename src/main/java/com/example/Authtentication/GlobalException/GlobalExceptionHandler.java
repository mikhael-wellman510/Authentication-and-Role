package com.example.Authtentication.GlobalException;

import org.springframework.boot.context.config.ConfigDataNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Todo -> Jika email atau Password salah
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?>handleBadCredentialException(BadCredentialsException ex){
        Map<String , Object> data  = new HashMap<>();

        data.put("msg : " , "Email or Password Wrong");
        data.put("status : " , 401);
        return new ResponseEntity<>(data , HttpStatus.UNAUTHORIZED);
    }

    // Todo -> Handle Uniq error(Email already exsist)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?>handleDataIntegrityViolationException(DataIntegrityViolationException ex){

        return new ResponseEntity<>("Duplicate key : " +ex.getMessage() ,HttpStatus.BAD_REQUEST);
    }
}
