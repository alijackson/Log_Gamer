package br.log.game.log.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.log.game.log.model.Game;
import br.log.game.log.model.Player;
import br.log.game.log.service.Auxiliar;
import br.log.game.log.start.Start;

@RestController
@RequestMapping
public class GameController extends Start{
	
	private Auxiliar aux = new Auxiliar();

	@Bean
	private void start() {

		readFile();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/game")
	public Game buscar() {
		
		return super.getGame();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/numero-de-jogadores")
	public int jogadores() {
		
		return super.getGame().getPlayers().size();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/mortes/{player}/detalhe")
	public Player detMorte(@PathVariable String player) {
		
		if(this.aux.hasPlayer(super.getGame(), player) == null) {
			throw new IllegalArgumentException("Jogador não identificado!");
		}
		return this.aux.hasPlayer(super.getGame(), player);
	}
	

	@RequestMapping(method = RequestMethod.GET, value = "/mortes/{player}")
	public int mortes(@PathVariable String player) {
		
		if(this.aux.hasPlayer(super.getGame(), player) == null) {
			throw new IllegalArgumentException("Jogador não identificado!");
		}
		return this.aux.hasPlayer(super.getGame(), player).getKill().size();
	}

}
