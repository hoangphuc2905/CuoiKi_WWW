package iuh.huynhhoangphuc_21036541_donhang.backend.services;

import iuh.huynhhoangphuc_21036541_donhang.backend.models.Donhang;

import java.time.LocalDate;
import java.util.List;

public interface DonhangServices {
    List<Donhang> getAllDonHangs();
    Donhang getDonHangById(String madonhang);

    void addDonHang(Donhang donHang);
    void deleteDonHang(int id);

    String generateMaDonHang();

    boolean isEmailAlreadyPlacedToday(String email, LocalDate ngaydathang);

    List<Donhang> searchByTenCuaHang(String tencuahang);

    List<Donhang> findByEmailAndNgaydatHangStartingWith(String email, LocalDate ngaydathang);
}
