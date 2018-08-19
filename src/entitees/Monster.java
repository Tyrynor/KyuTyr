package entitees;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import outils.Calcules;
import outils.Stats;

public  class Monster extends Entity implements AttackingEntity{
	
	public Monster(Stats sts) {
		super(sts);
	}
	
	@Override
	public void draw(Graphics g) {
		int refX = Calcules.posXRefPlayer(this.stats.posX), refY = Calcules.posYRefPlayer(this.stats.posY);
		g.setColor(Color.GREEN);
		g.drawString(this.stats.posX + "/" + this.stats.posY, refX, refY);
		g.setColor(Color.BLACK);
		g.fillOval(refX, refY, 20, 20);
		g.setColor(Color.RED);
		Rectangle r = this.getHitBox();
		g.drawRect(r.x, r.y, r.width, r.height);
	}

	@Override
	public boolean attaquer() {
		// TODO Auto-generated method stub
		return false;
	}

}
