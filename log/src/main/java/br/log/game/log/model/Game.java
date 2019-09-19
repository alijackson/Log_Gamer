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

/**
 *
 * @author alijackson.msilva
 */
@Getter
public class Game {
    private final String sessao;
    private ArrayList<Player> players = null;
    
    public Game(String sessao){
        this.sessao = sessao;
        players = new ArrayList<>();
    }
    public void log (String log){
      Player player = null;
      
      Kill kill = new Kill();
      
      Expressao ex = new Expressao("player");
      // Create a Pattern object
      Pattern r = Pattern.compile(ex.getPlayer());
      // Now create matcher object.
      Matcher m = r.matcher(log);
      while(m.find()){
          
          String [] all = m.group().split(" ");
          String [] modPlayers = new String[2];
          int cont = 0;
          for(String detalhe : all){
              switch (detalhe.toUpperCase().trim()){
                  case "\\d{1,2}:\\d{1,2}":
                      kill.setLog(detalhe);
                      break;
                  case "\\w*":
                      if(detalhe.trim().equalsIgnoreCase("KILLED")){
                          cont++;   
                          break;
                      }
                      else{
                          if(cont>1)
                              throw new InternalError("Erro ao tentar criar o objeto");
                          
                          modPlayers[cont] += detalhe;
                      }
                      if(cont == 0 && !modPlayers[cont].trim().equals("")){
                          player = new Player(modPlayers[cont]);
                      }
                      else if(cont == 1 && !modPlayers[cont].trim().equals("")){
                          kill.setMatou(new Player(modPlayers[cont]));
                      }
                          
              }
              System.out.println(detalhe);
          }
      }
    }
    private boolean exists(ArrayList<Player> players, String player){
                return false;
    }
}
