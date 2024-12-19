package com.example.Authtentication.Service;

import com.example.Authtentication.DTO.MahasiswaRequest;
import com.example.Authtentication.DTO.MahasiswaResponse;
import com.example.Authtentication.Entity.Mahasiswa;

public interface MahasiswaService {

    MahasiswaResponse addMahasiswa(MahasiswaRequest mahasiswaRequest);
    MahasiswaResponse editMahasiswa(MahasiswaRequest mahasiswaRequest);
    Mahasiswa findById(String id);
}
