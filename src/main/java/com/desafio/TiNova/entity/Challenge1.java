package com.desafio.TiNova.entity;


import com.desafio.TiNova.repository.IChallenge;

import java.text.DecimalFormat;

public class Challenge1 implements IChallenge {

    private Double totalEleitores;
    private Double votosValidos;
    private Double votosBrancos;
    private Double votosNulos;

    public Challenge1(){
        totalEleitores = Double.valueOf(1000);
        votosValidos = Double.valueOf(800);
        votosBrancos = Double.valueOf(150);
        votosNulos = Double.valueOf(50);
    }
    public String PercentageVotesValid(){
        return new DecimalFormat("0.#").format(Double.valueOf((votosValidos/totalEleitores)*100)).toString() + "%";

    }
    public String PercentageVotesWhite(){
        return new DecimalFormat("0.#").format(Double.valueOf((votosBrancos /totalEleitores)*100)).toString() + "%";
    }
    public String PercentageVotesNull(){
        return new DecimalFormat("0.#").format(Double.valueOf((votosNulos/totalEleitores)*100)).toString() + "%";
    }

    @Override
    public String ApplyRule() {
        return "Percentage valid votes: " + PercentageVotesValid() + "  "+
                "Percentage white votes: " + PercentageVotesWhite() + "  "+
                "Percentage null votes: " + PercentageVotesNull();
    }
}