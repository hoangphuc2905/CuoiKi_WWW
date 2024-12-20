package iuh.huynhhoangphuc_21036541_donhang.backend.repositories;

import iuh.huynhhoangphuc_21036541_donhang.backend.models.Donhang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DonhangRepository extends JpaRepository<Donhang, Integer> {

    Donhang findByMadonhang(String madonhang);
    @Query("SELECT d FROM Donhang d WHERE d.email = ?1 AND d.ngaydathang = ?2")
    List<Donhang> findByEmailAndNgaydathang(String email, LocalDate ngaydathang);

    @Query("SELECT d FROM Donhang d JOIN d.macuahang c WHERE c.ten LIKE %:tencuahang%")
    List<Donhang> findByTenCuaHang(@Param("tencuahang") String tencuahang);

//    List<Donhang> getDonHangByTenCuaHang(String macuahang);
}