/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.log.game.log.service;

import lombok.Getter;

/**
 *
 * @author alijackson.msilva
 */
@Getter
public class Expressao {
    private String kill = "";
    private String player = "";
    
    public Expressao(String who){
        if(who.toUpperCase().trim().equals("PLAYER"))
            player();
        
    }
    private void player(){
        this.player = "(\\s?\\d{1,2}:\\d{1,2}){1}\\s?Kill:(\\s?\\d{1,4}){1,3}:\\s?(<world>|(\\w*\\s?))*";
    }
        
}
