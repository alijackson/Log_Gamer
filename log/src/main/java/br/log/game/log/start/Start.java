/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.log.game.log.start;

import br.log.game.log.model.Game;
import br.log.game.log.model.Kill;
import br.log.game.log.model.Player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *
 * @author alijackson.msilva
 */
@Configuration
public class Start {
    @Bean
    public void readFile() throws IOException{
        String linha = "";
        Game game = new Game("game_1");
        try (BufferedReader log =  
                new BufferedReader(new FileReader("log\\games.log"))){
            
            while(log.ready()){
                linha = log.readLine();
                game.log(linha);
            }
        }        
    }
}

