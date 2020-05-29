package com.credit.ma.agricol.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.credit.ma.agricol.entity.Compte;
import com.credit.ma.agricol.repository.CompteRepository;


@Controller
@RequestMapping("/comptes/")
public class CompteController {

    private final CompteRepository compteRepository;

    @Autowired
    public CompteController(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Compte compte) {
        return "add-compte";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("comptes", compteRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addcompte( Compte compte, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-compte";
        }

        compteRepository.save(compte);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid compte Id:" + id));
        model.addAttribute("compte", compte);
        return "update-compte";
    }

    @PostMapping("update/{id}")
    public String updatecompte(@PathVariable("id") long id,  Compte compte, BindingResult result,
                               Model model) {
        if (result.hasErrors()) {
            compte.setId(id);
            return "update-compte";
        }

        compteRepository.save(compte);
        model.addAttribute("comptes", compteRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deletecompte(@PathVariable("id") long id, Model model) {
        Compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid compte Id:" + id));
        compteRepository.delete(compte);
        model.addAttribute("comptes", compteRepository.findAll());
        return "index";
    }
}

