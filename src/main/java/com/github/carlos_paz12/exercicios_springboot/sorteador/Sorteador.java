package com.github.carlos_paz12.exercicios_springboot.sorteador;

import java.util.Random;

public class Sorteador {

    public static int[] sortear(int i1, int i2, int n) {
        Random objRandom = new Random();
        int[] numeros = new int[n];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = objRandom.nextInt(i1, i2 + 1);
        }

        return numeros;
    }

}
