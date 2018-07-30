package entitees;

import java.awt.Color;
import java.awt.Graphics;

import constantes.Constantes;
import outils.Stats;

public  class Monster extends Entity {
	
	public Monster(Stats sts) {
		super(sts);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(this.stats.posX, this.stats.posY, 20, 20);
	}

}
