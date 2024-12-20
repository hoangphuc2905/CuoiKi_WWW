package iuh.huynhhoangphuc_21036541_donhang.backend.resources;

import iuh.huynhhoangphuc_21036541_donhang.backend.models.Donhang;
import iuh.huynhhoangphuc_21036541_donhang.backend.services.DonhangServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/donhang")
public class DonhangResources {
    @Autowired
    private DonhangServices services;

    @RequestMapping("/list")
    public ResponseEntity<List<Donhang>> listDonhangs() {
        return ResponseEntity.ok(services.getAllDonHangs());
    }

    @RequestMapping("/search")
    public ResponseEntity<List<Donhang>> searchDonhangs() {
        return ResponseEntity.ok(services.getAllDonHangs());
    }

    @RequestMapping("/add")
    public ResponseEntity<Donhang> addDonhang() {
        return ResponseEntity.ok().body(new Donhang());
    }

    @RequestMapping("/update")
    public ResponseEntity<Donhang> updateDonhang() {
        return ResponseEntity.ok().body(new Donhang());
    }

    @RequestMapping("/delete")
    public ResponseEntity<Donhang> deleteDonhang() {
        return ResponseEntity.ok().body(new Donhang());
    }
}
