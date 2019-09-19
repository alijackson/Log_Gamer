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
@Setter
public class Kill {
    
    private String log;
    private String causa;
    private Player matou;
    
    public Kill(){
        
    }
    
    public void playerLog(String log, int cont){
      
      Expressao ex = new Expressao("player");
      // Create a Pattern object
      Pattern r = Pattern.compile(ex.getPlayer());
      // Now create matcher object.
      Matcher m = r.matcher(log);
      while(m.find()){
          System.out.println(cont+" =====   "+m.group());
          cont++;
      }
    }
}
