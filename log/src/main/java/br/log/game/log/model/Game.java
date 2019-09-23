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
    private ArrayList<Player> players = new ArrayList<>();
    private Kill kill = null;
    @Setter
    private int cont = 0;
    private int i = 0;
    @Setter
    private StringBuilder tmpPlayer = new StringBuilder();
    
    public Game(String sessao){
        this.sessao = sessao;
        players = new ArrayList<>();
        kill = new Kill();
    }
    public void log (String log){
      Expressao ex = new Expressao("player");
      // Create a Pattern object
      Pattern r = Pattern.compile(ex.getPlayer());
      // Now create matcher object.
      Matcher m = r.matcher(log);
      while(m.find()){

          Player player = new Player();
          
          String [] all = m.group().split(" ");
          
          for(String detalhe : all) {
        	  decisao(detalhe, player);
          }
	      if(hasPlayer(player) >= 0) {
	    	  player = players.get(hasPlayer(player));
	    	  player.getKill().add(kill);
	      }
	      else {
	    	  player.getKill().add(kill);
	    	  
	    	  players.add(player);
	      }
	      
	      kill = new Kill();
      }
      
    }
    private int hasPlayer(Player p) {
    	int id = 0;
    	for (Player x : this.players) {
    		if(p.getNome() != null && x.getNome().trim().equalsIgnoreCase(p.getNome()))
    			return id;
    		id++;
    	}
    	
    	return -1;
    }
    private void decisao(String detalhe, Player player) {
    	if(detalhe.matches("\\d{1,2}:\\d{1,2}")) {
    		kill.setLog(detalhe);
    		return;
  	  	}
    	
    	if(!detalhe.equalsIgnoreCase("killed") && 
    			!detalhe.trim().equalsIgnoreCase("by") &&
    			detalhe.matches("[a-zA-Z]*")) {
    		this.tmpPlayer.append(" ").append(detalhe);

    		return;
    	}
    	if(detalhe.equalsIgnoreCase("<world>")) {
    		kill.setMatou(new Player("Sistema"));
    		return;
    	}
    	if(detalhe.equalsIgnoreCase("killed")) {
    		kill.setMatou(new Player(tmpPlayer.toString().trim()));
    		setTmpPlayer(new StringBuilder());
    		return;
    	}
    	if(!detalhe.trim().equalsIgnoreCase("by") && detalhe.matches("[a-zA-Z]*")) {
    		this.tmpPlayer.append(detalhe);
    		return;
    	}
    	if(detalhe.equalsIgnoreCase("by")) {
    		player.setNome(tmpPlayer.toString().trim());
    		setTmpPlayer(new StringBuilder());
    		return;
    	}
    	if(detalhe.matches("\\w*")) {
    		kill.setCausa(detalhe);
    		return;
    	}
    	return;
    }
}
