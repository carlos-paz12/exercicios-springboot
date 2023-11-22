package com.github.carlos_paz12.exercicios_springboot.equacao_quadratica;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equacao-quadratica")
public class EquacaoQuadraticaController {

    @GetMapping
    public String index() {
        return "equacao_quadratica/index";
    }

    @PostMapping("/calcular")
    public String calcular(float coeficienteA, float coeficienteB, float coeficienteC, Model model) {
        float delta = (coeficienteB * coeficienteB) - (4 * coeficienteA * coeficienteC);
        float x1 = (float) ((-1 * coeficienteB) + Math.sqrt(delta)) / (2 * coeficienteA);
        float x2 = (float) ((-1 * coeficienteB) - Math.sqrt(delta)) / (2 * coeficienteA);

        model.addAttribute("delta", delta);
        model.addAttribute("x1", x1);
        model.addAttribute("x2", x2);

        return "equacao_quadratica/resultado";
    }

}
