package com.github.carlos_paz12.exercicios_springboot.calculadora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculadora")
public class CalculadoraController {

    @GetMapping
    public String home() {
        return "calculadora/index";
    }

    @PostMapping("/calcular")
    public String calcular(int numero1, int numero2, int operacao, Model model) {
        int resultado;

        if (operacao == 1) {

            resultado = numero1 + numero2;

        } else if (operacao == 2) {

            resultado = numero1 - numero2;

        } else if (operacao == 3) {

            resultado = numero1 * numero2;

        } else {

            resultado = numero1 / numero2;

        }

        model.addAttribute("resultado", resultado);

        return "calculadora/resultado";
    }

}
