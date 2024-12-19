package com.example.Authtentication.Respository;

import com.example.Authtentication.Entity.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa ,String> {
}
