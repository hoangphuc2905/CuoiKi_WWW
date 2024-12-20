package iuh.huynhhoangphuc_21036541_dienthoai.backend.resources;

import iuh.huynhhoangphuc_21036541_dienthoai.backend.models.Phone;
import iuh.huynhhoangphuc_21036541_dienthoai.backend.services.PhoneServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/vi/phones")
public class PhoneResources {
    @Autowired
    private PhoneServices services;

    @RequestMapping("/list")
    public ResponseEntity<List<Phone>> listPhones() {
        return ResponseEntity.ok().body(services.getAllPhones());
    }


}
