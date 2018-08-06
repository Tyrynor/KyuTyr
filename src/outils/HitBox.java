package outils;
import java.awt.Rectangle;

import entitees.Entity;
import entitees.Joueur;
import usine.EntityStock;
import usine.SingletonJoueur;

public final class HitBox{
	public static boolean isHitted(Rectangle hitter, Entity hitted) {
		return hitter.intersects(hitted.getHitBox());
	}
	
	public static boolean canMove(Entity e) {
		for (Entity entity : EntityStock.instanceList) {
			if (e.EntityId != entity.EntityId && e.getHitBox().intersects(entity.getHitBox())) {
				return false;
			}
		}
		if (!(e instanceof Joueur)) {
			if (e.getHitBox().intersects(SingletonJoueur.getInstance().getHitBox())) {
				return false;
			}
		}
		return true;
	}
}