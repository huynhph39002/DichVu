package com.example.dich_vu.controller;
import com.example.dich_vu.entity.BuaSang;
import com.example.dich_vu.service.BuaSangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bs")
public class BuaSangController {

    @Autowired
    private BuaSangService buaSangService;

    @GetMapping
    public String viewBSList(Model model) {
        model.addAttribute("listBuaSang", buaSangService.getAllBuaSang());
        return "bs_list";
    }

    @GetMapping("/new")
    public String showNewBSForm(Model model) {
        BuaSang buaSang = new BuaSang();
        model.addAttribute("bs",buaSang);
        return "bs_form";
    }

    @PostMapping("/save")
    public String saveBS(@ModelAttribute("bs") BuaSang buaSang) {
        buaSangService.saveBS(buaSang);
        return "redirect:/bs";
    }

    @GetMapping("/edit/{id}")
    public String showEditBSForm(@PathVariable("id") Integer id, Model model) {
        BuaSang buaSang = buaSangService.getBSById(id);
        model.addAttribute("bs", buaSang);
        return "bs_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteBS(@PathVariable("id") Integer id) {
        buaSangService.deleteBSById(id);
        return "redirect:/bs";
    }
}
