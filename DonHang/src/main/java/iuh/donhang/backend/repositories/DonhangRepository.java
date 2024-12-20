package iuh.donhang.backend.repositories;

import iuh.donhang.backend.models.Cuahang;
import iuh.donhang.backend.models.Donhang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DonhangRepository extends JpaRepository<Donhang, Integer> {
    @Query("SELECT d FROM Donhang d")
    List<Donhang> findAll();

    @Query("SELECT c FROM Cuahang c")
    List<Cuahang> getAllCuahang();

    @Query("SELECT d FROM Donhang d WHERE d.madonhang LIKE %:keyword% OR d.macuahang.ten LIKE %:keyword%")
    List<Donhang> searchDonhang(@Param("keyword") String keyword);

    @Query("SELECT d FROM Donhang d WHERE d.email = :email AND d.trangthai = 0 AND d.ngaydathang = :ngaydathang")
    Donhang checkDonhang(@Param("email") String email, @Param("ngaydathang") LocalDate ngaydathang);
}