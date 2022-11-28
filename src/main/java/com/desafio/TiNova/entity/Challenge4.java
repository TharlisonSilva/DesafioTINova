package com.desafio.TiNova.entity;


import com.desafio.TiNova.repository.IChallenge;

public class Challenge4 implements IChallenge {

    private int limitValue;
    private int valueSum;
    public Challenge4(int limitValue){
        this.limitValue = limitValue;
        this.valueSum = 0;
    }

    public void setValueSum(int valueSum) {
        this.valueSum = valueSum;
    }

    public int getLimitValue() {
        return limitValue;
    }

    public int getValueSum() {
        return valueSum;
    }

    @Override
    public String ApplyRule() {
        for(int i = 0; i < getLimitValue(); i++){
            if( (i % 3 == 0) || (i % 5 == 0) )
                setValueSum(getValueSum()+i);
        }

        return String.valueOf(getValueSum());
    }
}
