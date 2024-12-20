package iuh.donhang.backend.services;

import iuh.donhang.backend.models.Cuahang;
import iuh.donhang.backend.models.Donhang;

import java.time.LocalDate;
import java.util.List;

public interface DonhangServices {
    List<Donhang> getAllDonhang();
    Donhang addDonhang(Donhang donhang);
    List<Cuahang> getAllCuaHang();
    void deleteDonhang(int id);
    List<Donhang> searchDonhang(String keyword);
    String generateMaDonHang();
    boolean checkDonhang(String email, LocalDate ngaydathang);
}
