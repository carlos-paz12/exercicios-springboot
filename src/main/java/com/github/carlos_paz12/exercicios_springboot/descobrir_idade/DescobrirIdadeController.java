package com.github.carlos_paz12.exercicios_springboot.descobrir_idade;

import java.util.Calendar;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/descobrir-idade")
public class DescobrirIdadeController {

    @GetMapping
    public String jurosSimples() {
        return "descobrir_idade/index";
    }

    @GetMapping("/descobrir")
    public String calcular(int ano, Model model) {
        int idade = Calendar.getInstance().get(Calendar.YEAR) - ano;
        model.addAttribute("idade", idade);
        return "descobrir_idade/resultado";
    }

}
