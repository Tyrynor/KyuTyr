package outils;

import constantes.Constantes;
import usine.SingletonStatsJoueur;

public class Calcules {
	public static int posXRefPlayer(int truePosX) {
		return truePosX + Constantes.REFERENTIEL_JOUEUR.width - SingletonStatsJoueur.getInstance().posX;
	}
	
	public static int posYRefPlayer(int truePosY) {
		return truePosY + Constantes.REFERENTIEL_JOUEUR.height - SingletonStatsJoueur.getInstance().posY;
	}
	
}
