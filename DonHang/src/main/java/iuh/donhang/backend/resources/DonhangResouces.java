package iuh.donhang.backend.resources;

import iuh.donhang.backend.services.DonhangServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/vi/donhang")
public class DonhangResouces {

    @Autowired
    private DonhangServices donhangServices;
}
