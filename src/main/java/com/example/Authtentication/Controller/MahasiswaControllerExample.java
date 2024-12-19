package com.example.Authtentication.Controller;

import com.example.Authtentication.DTO.MahasiswaRequest;
import com.example.Authtentication.DTO.MahasiswaResponse;
import com.example.Authtentication.Service.MahasiswaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MahasiswaControllerExample {

    private final MahasiswaService mahasiswaService;

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


    @PostMapping("/addData")
    public ResponseEntity<?> addMahasiswa(@RequestBody MahasiswaRequest mahasiswaRequest){

        MahasiswaResponse mahasiswaResponse =  mahasiswaService.addMahasiswa(mahasiswaRequest);

        return ResponseEntity.status(HttpStatus.OK).body(mahasiswaResponse);
    }

    @PutMapping("/editData")
    public ResponseEntity<?> editMahasiswa(@RequestBody MahasiswaRequest mahasiswaRequest){

        MahasiswaResponse mahasiswaResponse = mahasiswaService.editMahasiswa(mahasiswaRequest);

        return ResponseEntity.status(HttpStatus.OK).body(mahasiswaResponse);
    }


}
