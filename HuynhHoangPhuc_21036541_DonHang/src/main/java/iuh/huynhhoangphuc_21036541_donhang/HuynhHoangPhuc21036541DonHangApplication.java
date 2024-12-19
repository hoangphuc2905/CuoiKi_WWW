package iuh.huynhhoangphuc_21036541_donhang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class HuynhHoangPhuc21036541DonHangApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuynhHoangPhuc21036541DonHangApplication.class, args);
    }

}
