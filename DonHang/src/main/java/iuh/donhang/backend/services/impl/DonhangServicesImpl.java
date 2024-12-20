package iuh.donhang.backend.services.impl;

import iuh.donhang.backend.models.Cuahang;
import iuh.donhang.backend.models.Donhang;
import iuh.donhang.backend.repositories.DonhangRepository;
import iuh.donhang.backend.services.DonhangServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class DonhangServicesImpl implements DonhangServices {

    @Autowired
    private DonhangRepository donhangRepository;

    @Override
    public List<Donhang> getAllDonhang() {
        return donhangRepository.findAll();
    }

    @Override
    public Donhang addDonhang(Donhang donhang) {
        return donhangRepository.save(donhang);
    }

    @Override
    public List<Cuahang> getAllCuaHang() {
        return donhangRepository.getAllCuahang();
    }

    @Override
    public void deleteDonhang(int id) {
        Donhang donHang = donhangRepository.findById(id).orElseThrow(() -> new RuntimeException("Don hang not found"));
        if (donHang.getTrangthai().getValue() == 0) {
            donhangRepository.delete(donHang);
        } else {
            throw new RuntimeException("Không thể xóa đơn hàng đã chấp nhận");
        }
    }

    @Override
    public List<Donhang> searchDonhang(String keyword) {
        return donhangRepository.searchDonhang(keyword);
    }

    @Override
    public String generateMaDonHang() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    @Override
    public boolean checkDonhang(String email, LocalDate ngaydathang) {
        return donhangRepository.checkDonhang(email, ngaydathang) != null;
    }
}
