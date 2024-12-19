package iuh.huynhhoangphuc_21036541_donhang.backend.services.Impl;

import iuh.huynhhoangphuc_21036541_donhang.backend.models.Donhang;
import iuh.huynhhoangphuc_21036541_donhang.backend.repositories.CuahangRepository;
import iuh.huynhhoangphuc_21036541_donhang.backend.repositories.DonhangRepository;
import iuh.huynhhoangphuc_21036541_donhang.backend.services.DonhangServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class DonhangServicesImpl implements DonhangServices {

    @Autowired
    private DonhangRepository donHangRepository;

    @Autowired
    private CuahangRepository cuahangRepository;

    @Override
    public List<Donhang> getAllDonHangs() {
        return donHangRepository.findAll();
    }

    @Override
    public Donhang getDonHangById(String madonhang) {
        return donHangRepository.findByMadonhang(madonhang);
//        return donHangRepository.findByMadonhang(madonhang).orElseThrow(() -> new RuntimeException("Don hang not found"));
    }


    @Override
    public String generateMaDonHang() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    @Override
    public void addDonHang(Donhang donHang) {
        donHangRepository.save(donHang);
    }

    @Override
    public void deleteDonHang(int id) {
        Donhang donHang = donHangRepository.findById(id).orElseThrow(() -> new RuntimeException("Don hang not found"));
        if (donHang.getTrangthai().getValue() == 0) {
            donHangRepository.delete(donHang);
        } else {
            throw new RuntimeException("Không thể xóa đơn hàng đã chấp nhận");
        }
    }

    @Override
    public boolean isEmailAlreadyPlacedToday(String email, LocalDate ngaydathang) {

        List<Donhang> donHangs = donHangRepository.findByEmailAndNgaydathang(email, ngaydathang);
        return !donHangs.isEmpty();
    }


    @Override
    public List<Donhang> findByEmailAndNgaydatHangStartingWith(String email, LocalDate ngaydathang) {
        return donHangRepository.findByEmailAndNgaydathang(email, ngaydathang);
    }

    @Override
    public List<Donhang> searchByTenCuaHang(String tencuahang) {
        return donHangRepository.findByTenCuaHang(tencuahang);
    }



}
