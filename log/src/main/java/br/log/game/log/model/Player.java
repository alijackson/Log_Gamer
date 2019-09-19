/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.log.game.log.model;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author alijackson.msilva
 */
@Getter
@Setter
public class Player {
    private String nome;
    private ArrayList<Kill> kill = null;
    
    
}
