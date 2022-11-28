package com.desafio.TiNova.controller;

import com.desafio.TiNova.entity.Challenge1;
import com.desafio.TiNova.entity.Challenge2;
import com.desafio.TiNova.entity.Challenge3;
import com.desafio.TiNova.entity.Challenge4;
import com.desafio.TiNova.repository.IChallenge;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChallengeController {


    @RequestMapping(value = "Challenge1", method = RequestMethod.GET)
    public String Challenge1(){
        IChallenge item = new Challenge1();
        return item.ApplyRule();
    }

    @RequestMapping(value = "Challenge2", method = RequestMethod.GET)
    public String Challenge2(){
        IChallenge item = new Challenge2();
        return item.ApplyRule();
    }

    @RequestMapping(value = "Challenge3/{valor}", method = RequestMethod.GET)
    public String Challenge3(@PathVariable(value = "valor") int Value){
        IChallenge item = new Challenge3(Value);
        return item.ApplyRule();
    }

    @RequestMapping(value = "Challenge4/{valor}", method = RequestMethod.GET)
    public String Challenge4(@PathVariable(value = "valor") int Value){
        IChallenge item = new Challenge4(Value);
        return item.ApplyRule();
    }
}
