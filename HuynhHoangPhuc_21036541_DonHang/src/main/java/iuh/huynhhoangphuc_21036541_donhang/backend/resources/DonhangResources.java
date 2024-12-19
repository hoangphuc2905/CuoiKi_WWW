package iuh.huynhhoangphuc_21036541_donhang.backend.resources;

import iuh.huynhhoangphuc_21036541_donhang.backend.services.DonhangServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/vi/donhangs")
public class DonhangResources {
    @Autowired
    private DonhangServices services;
}
