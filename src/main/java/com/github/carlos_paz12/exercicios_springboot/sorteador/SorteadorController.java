package com.github.carlos_paz12.exercicios_springboot.sorteador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sorteador")
public class SorteadorController {
    
    @GetMapping
    public String sorteador() {
        return "sorteador/index";
    }

    @GetMapping("/sortear")
    public String sorteador(int i1, int i2, int n, Model model) {
        if (i2 < i1)
        {
            model.addAttribute("alerta", "intervalo inválido.");
            return "sorteador/index";
        }
        else if (n > i2 - i1 + 1)
        {
            model.addAttribute("alerta", "quantidade de números inválida.");
            return "sorteador/index";
        }
        else
        {
            model.addAttribute("numeros", Sorteador.sortear(i1, i2, n));
            return "sorteador/resultado";
        }
    }

}
