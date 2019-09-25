package br.log.game.log.service;

import java.util.ArrayList;

import br.log.game.log.model.Game;
import br.log.game.log.model.Player;

public class Auxiliar {

	public Player hasPlayer(Game game, String player) {
		ArrayList<Player> lp = game.getPlayers();
		
		for(Player p : lp) {
			if(player.trim().equalsIgnoreCase(p.getNome()))
				return p;
		}
		return null;
	}
}
