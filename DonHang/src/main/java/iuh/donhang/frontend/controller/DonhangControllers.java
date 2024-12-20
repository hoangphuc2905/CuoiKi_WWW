package iuh.donhang.frontend.controller;


import iuh.donhang.backend.models.Cuahang;
import iuh.donhang.backend.models.Donhang;
import iuh.donhang.backend.services.DonhangServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/donhang")
public class DonhangControllers {

    @Autowired
    private DonhangServices donhangServices;

    @GetMapping("/list")
    public ModelAndView listDonhang(ModelAndView modelAndView) {
        modelAndView.addObject("donhangs", donhangServices.getAllDonhang());
        modelAndView.setViewName("donhang/list");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addDonhang(ModelAndView modelAndView) {
        String madonhang = donhangServices.generateMaDonHang();
        List<Cuahang> cuahangs = donhangServices.getAllCuaHang();
        modelAndView.addObject("cuahangs", cuahangs);
        modelAndView.addObject("madonhang", madonhang);
        modelAndView.setViewName("donhang/add");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addDonhang(ModelAndView modelAndView, Donhang donhang) {
        if(donhang.getMadonhang() == null || donhang.getMadonhang().isEmpty()) {
            donhang.setMadonhang(donhangServices.generateMaDonHang());
        }
        if(donhang.getTenkhachhang() == null || donhang.getTenkhachhang().isEmpty() || donhang.getTenkhachhang().length() < 5 || donhang.getTenkhachhang().length() > 50) {
            modelAndView.addObject("error", "Tên khách hàng không được để trống và phải từ 5 đến 50 ký tự");
            modelAndView.setViewName("donhang/add");
            return modelAndView;
        }

        if(donhang.getTensanpham() == null || donhang.getTensanpham().isEmpty()){
            modelAndView.addObject("error", "Tên sản phẩm không được để trống");
            modelAndView.setViewName("donhang/add");
            return modelAndView;
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if(donhang.getEmail() == null || donhang.getEmail().isEmpty() || !donhang.getEmail().matches(emailRegex)) {
            modelAndView.addObject("error", "Email không được để trống và phải đúng định dạng");
            modelAndView.setViewName("donhang/add");
            return modelAndView;
        }

        if(donhang.getNgaydathang() == null || donhang.getNgaydathang().isBefore(LocalDate.now())) {
            modelAndView.addObject("error", "Ngày đặt hàng không được để trống và phải lớn hơn hoặc bằng ngày hiện tại");
            modelAndView.setViewName("donhang/add");
            return modelAndView;
        }
        if(donhangServices.checkDonhang(donhang.getEmail(), donhang.getNgaydathang())) {
            modelAndView.addObject("error", "Đơn hàng đã tồn tại");
            modelAndView.setViewName("donhang/add");
            return modelAndView;
        }

        donhang.setMadonhang(donhangServices.generateMaDonHang());
        donhangServices.addDonhang(donhang);
        modelAndView.setViewName("redirect:/donhang/list");
        return modelAndView;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/delete/{id}")
    public ModelAndView deleteDonhang(ModelAndView modelAndView, @PathVariable int id) {
        donhangServices.deleteDonhang(id);
        modelAndView.setViewName("redirect:/donhang/list");
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView searchDonhang(ModelAndView modelAndView, @RequestParam String keyword) {
        List<Donhang> results = donhangServices.searchDonhang(keyword);
        modelAndView.addObject("donhangs", results);
        modelAndView.setViewName("donhang/list");
        return modelAndView;
    }
}
