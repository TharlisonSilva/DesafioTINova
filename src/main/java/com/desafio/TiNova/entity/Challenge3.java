package com.desafio.TiNova.entity;

import com.desafio.TiNova.repository.IChallenge;

public class Challenge3 implements IChallenge {
    private int valueFactorial;

    public Challenge3(int valueFactorial){
        this.valueFactorial = valueFactorial;
    }

    public int getValueFactorial() {
        return valueFactorial;
    }

    @Override
    public String ApplyRule() {
        if(getValueFactorial() < 0)
            return "Invalid Number";
        if(getValueFactorial() < 2)
            return String.valueOf(getValueFactorial())+"! = 1";
        if(getValueFactorial() == 2)
            return String.valueOf(getValueFactorial())+"! = 2";

        int factorial = 1;
        for (int i = 2;i <= getValueFactorial() ; i ++) {
            factorial *= i;
        }
        return String.valueOf(getValueFactorial()) +"! =" +factorial;
    }
}
