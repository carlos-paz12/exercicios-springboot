package com.github.carlos_paz12.exercicios_springboot.juros_simples;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/juros-simples")
public class JurosController {

    private static final int LIMITE_PARCELAS = 24;
    private static final double JUROS_MINIMO = 5.0;
    private static final double JUROS_MAXIMO = 15.0;

    @GetMapping
    public String jurosSimples() {
        return "juros_simples/index";
    }

    @GetMapping("/calcular")
    public String calcular(int valorCompra, int parcelas, double jurosPorcentagem, Model model) {
        if (!isEntradaValida(valorCompra, parcelas, jurosPorcentagem, model)) {
            return "juros_simples/index";
        }

        calcularJuros(valorCompra, parcelas, jurosPorcentagem, model);
        return "juros_simples/resultado";
    }

    private boolean isEntradaValida(int valorCompra, int parcelas, double jurosPorcentagem, Model model) {
        if (parcelas > LIMITE_PARCELAS || parcelas <= 0)
        {
            model.addAttribute("alerta", "Número de parcelas inválido");
            return false;
        }

        if (jurosPorcentagem < JUROS_MINIMO || jurosPorcentagem > JUROS_MAXIMO)
        {
            model.addAttribute("alerta", "Juros inválido");
            return false;
        }

        return true;
    }

    private void calcularJuros(int valorCompra, int parcelas, double jurosPorcentagem, Model model) {
        double jurosDecimal = jurosPorcentagem / 100 * valorCompra;
        double montante = jurosDecimal + valorCompra;
        double valorParcela = montante / parcelas;
        String[] textoParcela = new String[parcelas];

        for (int i = 0; i < textoParcela.length; i++) {
            textoParcela[i] = (i + 1) + "ª parcela R$" + valorParcela;
        }

        model.addAttribute("montante", montante);
        model.addAttribute("valorParcela", valorParcela);
        model.addAttribute("textoParcela", textoParcela);
    }

}
