package com.example.dich_vu.controller;
import com.example.dich_vu.entity.Chan;
import com.example.dich_vu.service.ChanSercice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Controller
@RequestMapping("/chan")
public class ChanController {

    @Autowired
    private ChanSercice chanService;

    @GetMapping
    public String viewChanList(Model model) {
        model.addAttribute("listChan", chanService.getAllChan());
        return "chan_list";
    }

    @GetMapping("/new")
    public String showNewChanForm(Model model) {
        Chan chan = new Chan();
        model.addAttribute("chan", chan);
        return "chan_form";
    }
//    @PostMapping("/save")
//    public String saveChan(@Valid @ModelAttribute("chan") Chan chan,
//                           BindingResult bindingResult,
//                           @RequestParam("hinhAnhFile") MultipartFile hinhAnhFile,
//                           RedirectAttributes redirectAttributes) {
//
//        // Kiểm tra validation
//        if (bindingResult.hasErrors()) {
//            return "chan_form";  // Trả về form nếu có lỗi
//        }
//        // Kiểm tra xem mã có bị trùng hay không
//        if (chanService.isMaExists(chan.getMa())) {
//            bindingResult.rejectValue("ma", "error.chan", "Mã đã tồn tại, vui lòng nhập mã khác.");
//            return "chan_form";  // Trả về form với thông báo lỗi
//        }
//
//        // Xử lý upload file nếu hợp lệ
//        if (!hinhAnhFile.isEmpty()) {
//            try {
//                String fileName = StringUtils.cleanPath(hinhAnhFile.getOriginalFilename());
//                String uploadDir = "src/main/resources/static/images/";
//
//                Path filePath = Paths.get(uploadDir).resolve(fileName);
//                Files.createDirectories(filePath.getParent());
//                Files.copy(hinhAnhFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//                String relativePath = "/images/" + fileName;
//                chan.setAnh(relativePath);
//
//            } catch (IOException e) {
//                redirectAttributes.addFlashAttribute("message", "Lỗi khi lưu tệp: " + e.getMessage());
//                e.printStackTrace();
//                return "redirect:/chan/form";
//            }
//        }
//
//        chanService.saveChan(chan);
//        redirectAttributes.addFlashAttribute("message", "Lưu thành công!");
//        return "redirect:/chan";
//    }

    @PostMapping("/save")
    public String saveChan(@ModelAttribute("chan") Chan chan, @RequestParam("hinhAnhFile") MultipartFile hinhAnhFile) {
        // Xử lý upload file
        if (!hinhAnhFile.isEmpty()) {
            try {
                String fileName = hinhAnhFile.getOriginalFilename();
                String uploadDir = "src/main/resources/static/images/";

                // Lưu file vào thư mục 'images'
                Path filePath = Paths.get(uploadDir + fileName);
                Files.copy(hinhAnhFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                // Lưu đường dẫn tương đối vào thuộc tính anh của đối tượng Chan
                String relativePath = "images/" + fileName;
                chan.setAnh(relativePath);
            }catch (IOException e) {
                System.out.println("Lỗi khi lưu tệp: " + e.getMessage());
                e.printStackTrace();
            }

        }

        // Lưu đối tượng chăn vào database
        chanService.saveChan(chan);
        return "redirect:/chan";
    }


//    @PostMapping("/save")
//    public String saveChan(@ModelAttribute("chan") Chan chan, @RequestParam("hinhAnhFile") MultipartFile hinhAnhFile) {
//        // Xử lý upload file
//        if (!hinhAnhFile.isEmpty()) {
//            try {
//                // Tạo tên file và lưu vào thư mục 'images'
//                String fileName = hinhAnhFile.getOriginalFilename();
//                String uploadDir = "src/main/resources/static/images/";
//
//                // Lưu file vào thư mục 'images'
//                Path filePath = Paths.get(uploadDir + fileName);
//                Files.copy(hinhAnhFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//
//                // Lưu đường dẫn file vào thuộc tính anh của đối tượng Chan
//                chan.setAnh(uploadDir + fileName);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        // Lưu đối tượng chăn vào database
//        chanService.saveChan(chan);
//        return "redirect:/chan";
//    }

//    @PostMapping("/save")
//    public String saveChan(@ModelAttribute("chan") Chan chan) {
//        chanService.saveChan(chan);
//        return "redirect:/chan";
//    }

    @GetMapping("/edit/{id}")
    public String showEditChanForm(@PathVariable("id") Integer id, Model model) {
        Chan chan = chanService.getChanById(id);
        model.addAttribute("chan", chan);
        return "chan_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteChan(@PathVariable("id") Integer id) {
        chanService.deleteChanById(id);
        return "redirect:/chan";
    }
}

