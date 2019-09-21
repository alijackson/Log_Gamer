/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.log.game.log.model;

import br.log.game.log.service.Expressao;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author alijackson.msilva
 */
@Getter
public class Game {
    private final String sessao;
    private ArrayList<Player> players = null;
    @Setter
    private byte cont = 0;
    private StringBuilder tmpPlayer = new StringBuilder();
    
    public Game(String sessao){
        this.sessao = sessao;
        players = new ArrayList<>();
    }
    public void log (String log){
      Player player = new Player();
      IGame igame = null;
      Kill kill = new Kill();
      
      Expressao ex = new Expressao("player");
      // Create a Pattern object
      Pattern r = Pattern.compile(ex.getPlayer());
      // Now create matcher object.
      Matcher m = r.matcher(log);
      while(m.find()){

          System.out.println(m.group());
          String [] all = m.group().split(" ");
          String [] modPlayers = new String[2];
          
          for(String detalhe : all) {
        	  igame = decisao(detalhe, kill, player);
	          System.out.println(player);
	          System.out.println(kill);
          }
      }
    }
    private boolean exists(ArrayList<Player> players, String player){
                return false;
    }
    private IGame decisao(String detalhe, Kill kill, Player player) {
    	if(detalhe.matches("\\d{1,2}:\\d{1,2}")) {
    		kill.setLog(detalhe);
    		return kill;
  	  	}
    	if(cont == 0  && !detalhe.equalsIgnoreCase("killed") && detalhe.matches("\\w*")) {
    		this.tmpPlayer.append(detalhe);
    	}
    	if(detalhe.equalsIgnoreCase("killed")) {
    		kill.setMatou(new Player(tmpPlayer.toString()));
    		tmpPlayer = new StringBuilder();
    		cont++;
    		return kill;
    	}
    	if(cont == 1 && !detalhe.equalsIgnoreCase("by") && detalhe.matches("\\w*")) {
    		this.tmpPlayer.append(detalhe);
    	}
    	if(detalhe.equalsIgnoreCase("by")) {
    		player.setNome(tmpPlayer.toString());
    		tmpPlayer = new StringBuilder();
    		cont++;
    		return player;
    	}
    	if(cont == 2 && detalhe.matches("\\w*")) {
    		kill.setCausa(detalhe);
    		cont++;
    		return kill;
    	}
    	return player;
    }
}
