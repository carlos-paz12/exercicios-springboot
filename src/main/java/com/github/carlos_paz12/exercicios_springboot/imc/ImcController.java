package com.github.carlos_paz12.exercicios_springboot.imc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/imc")
public class ImcController {

    @GetMapping
    public String index() {
        return "imc/index";
    }

    @PostMapping("/calcular")
    public String calcular(double altura, double massa, Model model) {
        double imc = massa / (altura * altura);

        model.addAttribute("imc", imc);
        return "imc/resultado";
    }
}
