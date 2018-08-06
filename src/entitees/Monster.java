package entitees;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import constantes.Constantes;
import outils.Stats;
import usine.SingletonJoueur;
import usine.SingletonStatsJoueur;

public  class Monster extends Entity {
	
	public Monster(Stats sts) {
		super(sts);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		int posXD = SingletonStatsJoueur.getInstance().posX;
		int posYD = SingletonStatsJoueur.getInstance().posY;
		g.fillOval(this.stats.posX+ Constantes.REFERENTIEL_JOUEUR.width-posXD, this.stats.posY+Constantes.REFERENTIEL_JOUEUR.height-posYD, 20, 20);
		g.setColor(Color.RED);
		Rectangle r = this.getHitBox();
		g.drawRect(r.x, r.y, r.width, r.height);
	}

}
