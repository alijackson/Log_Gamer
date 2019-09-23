/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.log.game.log.model;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author alijackson.msilva
 */
@ToString
@Getter
@Setter
public class Player implements IGame{
    private String nome;
    private ArrayList<Kill> kill = null;
    
    public Player(String player) {
    	this.nome = player;
    	kill = new ArrayList<>();
    }
    public Player() {
    	kill = new ArrayList<>();
    }
    
}
