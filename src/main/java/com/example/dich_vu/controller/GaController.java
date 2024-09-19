package com.example.dich_vu.controller;
import com.example.dich_vu.entity.Ga;
import com.example.dich_vu.service.GaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ga")
public class GaController {
    @Autowired
    private GaService gaService;

    @GetMapping
    public String viewGaList(Model model) {
        model.addAttribute("listGa", gaService.getAllGa());
        return "ga_list";
    }

    @GetMapping("/new")
    public String showNewGaForm(Model model) {
        Ga ga=new Ga();
        model.addAttribute("ga", ga);
        return "ga_form";
    }

    @PostMapping("/save")
    public String saveGa(@ModelAttribute("ga") Ga ga) {
        gaService.saveGa(ga);
        return "redirect:/ga";
    }

    @GetMapping("/edit/{id}")
    public String showEditGaForm(@PathVariable("id") Long id, Model model) {
        Ga ga  = gaService.getGaById(id);
        model.addAttribute("ga", ga);
        return "ga_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteGa(@PathVariable("id") Long id) {
        gaService.deleteGaById(id);
        return "redirect:/ga";
    }
}
