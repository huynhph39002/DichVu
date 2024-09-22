package com.example.dich_vu.controller;
import com.example.dich_vu.entity.Dem;
import com.example.dich_vu.service.DemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dem")
public class DemController {


    @Autowired
    private DemService demService;

    @GetMapping
    public String viewDemList(Model model) {
        model.addAttribute("listDem", demService.getAllDem());
        return "dem_list";
    }

    @GetMapping("/new")
    public String showNewDemForm(Model model) {
        Dem dem = new Dem();
        model.addAttribute("dem", dem);
        return "dem_form";
    }

    @PostMapping("/save")
    public String saveDem(@ModelAttribute("dem") Dem dem) {
        demService.saveDem(dem);
        return "redirect:/dem";
    }

    @GetMapping("/edit/{id}")
    public String showEditDemForm(@PathVariable("id") Integer id, Model model) {
        Dem dem  = demService.getDemById(id);
        model.addAttribute("dem", dem);
        return "dem_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteDem(@PathVariable("id") Integer id) {
        demService.deleteDemById(id);
        return "redirect:/dem";
    }
}
