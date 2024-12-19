package com.example.Authtentication.Service;

import com.example.Authtentication.DTO.MahasiswaRequest;
import com.example.Authtentication.DTO.MahasiswaResponse;
import com.example.Authtentication.Entity.Mahasiswa;
import com.example.Authtentication.Respository.MahasiswaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MahasiswaServiceImpl implements MahasiswaService {

    private final MahasiswaRepository mahasiswaRepository;

    @Override
    public MahasiswaResponse addMahasiswa(MahasiswaRequest mahasiswaRequest) {
        log.info("data req {} " , mahasiswaRequest);
        Mahasiswa addMhs = mahasiswaRepository.save(Mahasiswa.builder()
                        .name(mahasiswaRequest.getName())
                        .nik(mahasiswaRequest.getNik())
                        .age(mahasiswaRequest.getAge())
                .build());

        log.info("Data mhs {} :" , addMhs);
        return MahasiswaResponse.builder()
                .id(addMhs.getId())
                .name(addMhs.getName())
                .nik(addMhs.getNik())
                .age(addMhs.getAge())
                .createdAt(addMhs.getCreatedAt())
                .updatedAt(addMhs.getCreatedAt())
                .build();
    }

    @Override
    public MahasiswaResponse editMahasiswa(MahasiswaRequest mahasiswaRequest) {

        // Todo find By id
        Mahasiswa mhs = findById(mahasiswaRequest.getId());
        log.info("sebelum updated {} : " , mhs);
        mhs.setName(mahasiswaRequest.getName());
        mhs.setNik(mahasiswaRequest.getNik());
        mhs.setAge(mahasiswaRequest.getAge());
        log.info("setelah updated {} : " , mhs);
        Mahasiswa updated =  mahasiswaRepository.save(mhs);
        log.info("fix update {} : " , updated);
        return MahasiswaResponse.builder()
                .id(updated.getId())
                .name(updated.getName())
                .nik(updated.getNik())
                .age(updated.getAge())
                .updatedAt(updated.getUpdatedAt())
                .createdAt(updated.getCreatedAt())
                .build();
    }

    @Override
    public Mahasiswa findById(String id) {
        return mahasiswaRepository.findById(id).orElse(null);
    }
}
