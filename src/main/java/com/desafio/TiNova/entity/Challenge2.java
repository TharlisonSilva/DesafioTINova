package com.desafio.TiNova.entity;

import com.desafio.TiNova.repository.IChallenge;

public class Challenge2 implements IChallenge {
    private int[] v = {5, 3, 2, 4, 7, 1, 0, 6};

    @Override
    public String ApplyRule() {
        String Sorted = "";
        for(int i = 0; i < v.length - 1; i++) {
            for(int j = 0; j < v.length - 1 - i; j++) {
                if(v[j] > v[j + 1]) {
                    int aux = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = aux;
                }
            }
        }

        for (int value : v)
            Sorted += "[" +String.valueOf(value) + "] ";

        return Sorted;
    }
}
