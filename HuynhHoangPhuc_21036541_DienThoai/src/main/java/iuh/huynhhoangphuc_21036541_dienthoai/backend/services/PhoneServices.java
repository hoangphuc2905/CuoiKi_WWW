package iuh.huynhhoangphuc_21036541_dienthoai.backend.services;

import iuh.huynhhoangphuc_21036541_dienthoai.backend.models.Phone;
import iuh.huynhhoangphuc_21036541_dienthoai.backend.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServices {

    @Autowired
    private PhoneRepository phoneRepository;

    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }
}
