package com.github.carlos_paz12.exercicios_springboot.estacoes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estacoes")
public class EstacaoController {

    @GetMapping
    public String index() {
        return "estacoes/index";
    }

    @PostMapping("/descobrir")
    public String descobrir(int mes) {
        switch (mes) {
            case 1, 2, 3:
                return "estacoes/outono";

            case 4, 5, 6:
                return "estacoes/inverno";

            case 7, 8, 9:
                return "estacoes/primavera";

            default:
                return "estacoes/verao";
        }

    }

}
