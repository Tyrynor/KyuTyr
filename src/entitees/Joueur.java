package entitees;

import java.awt.Color;
import java.awt.Graphics;

import outils.Stats;
import usine.SingletonStatsJoueur;

public class Joueur extends Entity {
	
	public Joueur() {
		super(null);
	}
	
	@Override
	public boolean move(int x,int y) {
		SingletonStatsJoueur.getIntance().posX+=x;
		SingletonStatsJoueur.getIntance().posY+=y;
		this.setChanged();
		this.notifyObservers();
		return true;
	}

	@Override
	public void draw(Graphics g) {
		System.out.println("Ma bite");
		g.setColor(Color.GREEN);
		g.fillOval(SingletonStatsJoueur.getIntance().posX,SingletonStatsJoueur.getIntance().posY,20,20);
	}

}
