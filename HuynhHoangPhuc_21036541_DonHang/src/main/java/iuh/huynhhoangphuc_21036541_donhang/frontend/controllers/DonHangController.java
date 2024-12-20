package iuh.huynhhoangphuc_21036541_donhang.frontend.controllers;

import iuh.huynhhoangphuc_21036541_donhang.backend.models.Cuahang;
import iuh.huynhhoangphuc_21036541_donhang.backend.models.Donhang;
import iuh.huynhhoangphuc_21036541_donhang.backend.services.CuahangServices;
import iuh.huynhhoangphuc_21036541_donhang.backend.services.DonhangServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/donhang")
public class DonHangController {

    @Autowired
    private DonhangServices donHangService;

    @Autowired
    private CuahangServices cuahangService;

    @GetMapping("/list")
    public String showDonHangList(Model model) {
        model.addAttribute("donhangs", donHangService.getAllDonHangs());
        return "donhang/list";
    }

    @GetMapping("/search")
    public String searchDonHang(@RequestParam(value = "search", required = false) String search,
                                @RequestParam(value = "searchType", required = false) String searchType,
                                Model model) {
        if (searchType != null && searchType.equals("madonhang") && !search.isEmpty()) {
            Donhang donHang = donHangService.getDonHangById(search);
            model.addAttribute("donhangs", List.of(donHang));
        } else if (searchType != null && searchType.equals("tencuahang") && !search.isEmpty()) {
            List<Donhang> donHangs = donHangService.searchByTenCuaHang(search);
            model.addAttribute("donhangs", donHangs);
        } else {
            model.addAttribute("donhangs", List.of());
        }
        return "donhang/list";
    }


    @GetMapping("/add")
    public String showFormAddDonHang(Model model) {
        String madonhang = donHangService.generateMaDonHang();
        List<Cuahang> danhSachCuaHang = cuahangService.getAllCuahang();
        model.addAttribute("donhang", new Donhang());
        model.addAttribute("madonhang", madonhang);
        model.addAttribute("danhSachCuaHang", danhSachCuaHang);
        return "donhang/add";
    }

    @PostMapping("/add")
    public String addDonHang(@ModelAttribute Donhang donHang, Model model) {
        if (donHang.getMadonhang() == null || donHang.getMadonhang().isEmpty()) {
            model.addAttribute("error", "Mã đơn hàng là bắt buộc.");
            return "donhang/add";
        }
        if (donHang.getTenkhachhang() == null || donHang.getTenkhachhang().isEmpty()) {
            model.addAttribute("error", "Tên khách hàng là bắt buộc.");
            return "donhang/add";
        }
        if (donHang.getEmail() == null || donHang.getEmail().isEmpty()) {
            model.addAttribute("error", "Email là bắt buộc.");
            return "donhang/add";
        }
        if (donHang.getNgaydathang() == null) {
            model.addAttribute("error", "Ngày đặt hàng là bắt buộc.");
            return "donhang/add";
        }
        if (donHang.getTensp() == null || donHang.getTensp().isEmpty()) {
            model.addAttribute("error", "Tên sản phẩm là bắt buộc.");
            return "donhang/add";
        }

        if (donHang.getTenkhachhang().length() < 5 || donHang.getTenkhachhang().length() > 50) {
            model.addAttribute("error", "Tên khách hàng phải từ 5 đến 50 ký tự.");
            return "donhang/add";
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!donHang.getEmail().matches(emailRegex)) {
            model.addAttribute("error", "Email không hợp lệ.");
            return "donhang/add";
        }

        if (donHang.getNgaydathang().isBefore(LocalDate.now())) {
            model.addAttribute("error", "Ngày đặt hàng phải lớn hơn ngày hiện tại.");
            return "donhang/add";
        }

        if (donHangService.isEmailAlreadyPlacedToday(donHang.getEmail(), donHang.getNgaydathang())) {
            model.addAttribute("error", "Trong cùng một ngày, email chỉ được đặt 1 đơn hàng tạm.");
            return "donhang/add";
        }
        donHang.setMadonhang(donHangService.generateMaDonHang());

        donHangService.addDonHang(donHang);

        return "redirect:/donhang/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteDonHang(@PathVariable int id) {
        donHangService.deleteDonHang(id);
        return "redirect:/donhang/list";
    }
}

