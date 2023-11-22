package com.github.carlos_paz12.exercicios_springboot.bingo;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bingo")
public class BingoController {

    @GetMapping
    public String index() {
        return "bingo/index";
    }

    @PostMapping("/gerarNumeros")
    public String gerarNumeros(String nome, Model model) {
        Date data = new Date();
        int[] numeros = new int[12];
        int numeroPassado = 0;

        for (int i = 0; i < numeros.length; i++) {
            int numeroGerado = (int) (Math.random() * 49);

            if (numeroGerado != numeroPassado) {

                numeros[i] = numeroGerado;

            } else {

                numeros[i] = (int) (Math.random() * 49);

            }
        }

        model.addAttribute("numeros", numeros);
        model.addAttribute("nome", nome);
        model.addAttribute("data", data.toString());

        return "bingo/resultado";
    }

}
