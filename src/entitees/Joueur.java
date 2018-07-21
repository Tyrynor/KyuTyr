package entitees;

import java.awt.Color;
import java.awt.Graphics;

public class Joueur extends Entity {

	public Joueur(int initPosX, int initPosY) {
		super(initPosX, initPosY);
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(this.getPosX(),this.getPosY(),20,20);
	}

}
