package outils;

import java.awt.Rectangle;

import constantes.Constantes;
import entitees.Entity;
import usine.SingletonStatsJoueur;

public class Calcules {
	public static int posXRefPlayer(int truePosX) {
		return truePosX + Constantes.REFERENTIEL_JOUEUR.width - SingletonStatsJoueur.getInstance().posX;
	}
	
	public static int posYRefPlayer(int truePosY) {
		return truePosY + Constantes.REFERENTIEL_JOUEUR.height - SingletonStatsJoueur.getInstance().posY;
	}
	
	public static double distB2E(Entity e1, Entity e2) {
		Rectangle r1 = e1.getHitBox();
		Rectangle r2 = e2.getHitBox();
		return Math.sqrt(Math.pow((r1.getCenterX()-r2.getCenterX()),2)+Math.pow(r1.getCenterY()-r2.getCenterY(), 2));
	}
	
	public static int percent(int a, int b) {
		return (int)(((double)a/(double)b)*100);
	}
	
}
