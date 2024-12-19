package iuh.huynhhoangphuc_21036541_dienthoai.frontend.controllers;

import iuh.huynhhoangphuc_21036541_dienthoai.backend.models.Phone;
import iuh.huynhhoangphuc_21036541_dienthoai.backend.repositories.LoaiphoneRepository;
import iuh.huynhhoangphuc_21036541_dienthoai.backend.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/phones")
public class PhoneController {
    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private LoaiphoneRepository loaiphoneRepository;

    @GetMapping("/list")
    public String listPhones(Model model) {
        model.addAttribute("phones", phoneRepository.findAll());
        model.addAttribute("loaiphones", loaiphoneRepository.findAll());
        return "phones/list";
    }

    @GetMapping("/add")
    public ModelAndView showFormAddPhone() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("phone", new Phone());
        modelAndView.addObject("loaiphones", loaiphoneRepository.findAll());
        modelAndView.setViewName("phones/add");
        return modelAndView;
    }

    @PostMapping("/add")
    public String addPhone(@ModelAttribute Phone phone, Model model) {
        if (phone.getPhoneName() == null || phone.getPhoneName().isEmpty()) {
            model.addAttribute("error", "Tên điện thoại không được để trống.");
            return "phones/add";
        }
        if (phone.getAddress() == null || phone.getAddress().isEmpty()) {
            model.addAttribute("error", "Địa chỉ không được để trống.");
            return "phones/add";
        }
        if (phone.getCostPrice() == null || phone.getCostPrice() <= 0) {
            model.addAttribute("error", "Giá nhập phải là số dương.");
            return "phones/add";
        }

        if (phone.getCategory() == null || phone.getCategory().getId() == 0) {
            model.addAttribute("error", "Loại điện thoại không được để trống.");
            return "phones/add";
        }

        phoneRepository.save(phone);
        return "redirect:/phones/list";
    }


    @GetMapping("/update/{id}")
    public ModelAndView showUpdatePhone(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        Phone phone = phoneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid phone ID: " + id));
        modelAndView.addObject("phone", phone);
        modelAndView.addObject("loaiphones", loaiphoneRepository.findAll());
        modelAndView.setViewName("phones/update");
        return modelAndView;
    }


    @PostMapping("/update")
    public String updatePhone(@ModelAttribute("phone") Phone phone, Model model) {
        if (phone.getPhoneName() == null || phone.getPhoneName().isEmpty()) {
            model.addAttribute("error", "Tên điện thoại không được để trống.");
            return "phones/update";
        }
        if (phone.getAddress() == null || phone.getAddress().isEmpty()) {
            model.addAttribute("error", "Địa chỉ không được để trống.");
        }
        if (phone.getCostPrice() == null || phone.getCostPrice() <= 0) {
            model.addAttribute("error", "Giá nhập phải là số dương.");
            return "phones/update";
        }

        if (phone.getCategory() == null) {
            model.addAttribute("error", "Loại điện thoại không được để trống.");
            return "phones/update";
        }

        phoneRepository.save(phone);
        return "redirect:/phones/list";
    }


    @GetMapping("/delete/{id}")
    public String deletePhone(@PathVariable("id") int id) {
        Phone phone = phoneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid phone ID: " + id));
        phoneRepository.delete(phone);
        return "redirect:/phones/list";
    }

}
