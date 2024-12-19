package iuh.huynhhoangphuc_21036541_donhang.backend.services.Impl;

import iuh.huynhhoangphuc_21036541_donhang.backend.models.Cuahang;
import iuh.huynhhoangphuc_21036541_donhang.backend.models.Donhang;
import iuh.huynhhoangphuc_21036541_donhang.backend.repositories.CuahangRepository;
import iuh.huynhhoangphuc_21036541_donhang.backend.services.CuahangServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuahangServicesImpl implements CuahangServices {
    @Autowired
    private CuahangRepository cuahangRepository;

    @Override
    public List<Cuahang> getAllCuahang() {
        return cuahangRepository.findAll();
    }

}
