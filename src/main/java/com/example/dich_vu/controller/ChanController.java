package com.example.dich_vu.controller;
import com.example.dich_vu.entity.Chan;
import com.example.dich_vu.service.ChanSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    public String saveChan(@ModelAttribute("chan") Chan chan) {
        chanService.saveChan(chan);
        return "redirect:/chan";
    }

    @GetMapping("/edit/{id}")
    public String showEditChanForm(@PathVariable("id") Long id, Model model) {
        Chan chan = chanService.getChanById(id);
        model.addAttribute("chan", chan);
        return "chan_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteChan(@PathVariable("id") Long id) {
        chanService.deleteChanById(id);
        return "redirect:/chan";
    }
}

