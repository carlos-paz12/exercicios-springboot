package com.github.carlos_paz12.exercicios_springboot.fibonacci;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fibonacci")
public class FibonacciController {

    @GetMapping
    public String index() {
        return "fibonacci/index";
    }

    @PostMapping("/gerar")
    public String gerarSequencia(int numeros, Model model) {
        int[] fibonacci = new int[numeros];
        int primeiroNumero = 0;
        int segundoNumero = 1;

        for (int i = 0; i < fibonacci.length; i++) {

            fibonacci[i] = primeiroNumero;
            int proximo = primeiroNumero + segundoNumero;
            primeiroNumero = segundoNumero;
            segundoNumero = proximo;

        }

        model.addAttribute("fibonacci", fibonacci);
        return "fibonacci/resultado";
    }

}
