package iuh.huynhhoangphuc_21036541_dienthoai.backend.resources;

import iuh.huynhhoangphuc_21036541_dienthoai.backend.services.PhoneServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/vi/phones")
public class PhoneResources {
    @Autowired
    private PhoneServices services;
}
