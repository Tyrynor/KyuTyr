package outils;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

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
	
	public static List<Entity> allHittedEntity(Shape sp, Entity linkedEntity) {
		List<Entity> lE = new ArrayList<Entity>();
		for (Entity entity : EntityStock.instanceList) {
			if (linkedEntity.EntityId != entity.EntityId && sp.intersects(entity.getHitBox())) {
				lE.add(entity);
			}
		}
		return lE;
	}
}