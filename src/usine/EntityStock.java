package usine;

import java.awt.Rectangle;
import java.util.ArrayList;

import entitees.AttackingEntity;
import entitees.Entity;
import entitees.MovingEntity;
import outils.Calcules;

public abstract class EntityStock {
	public static ArrayList<Entity> instanceList = new ArrayList<Entity>();
	
	public static boolean addNewEntity(Entity e) {
		for (Entity check : instanceList) {
			if (e.EntityId == check.EntityId) {
				return false;
			}
		}
		instanceList.add(e);
		return true;
	}
	
	public static void doActions() {
		for (Entity e : instanceList) {
			if (e instanceof MovingEntity && Calcules.distB2E(e, SingletonJoueur.getInstance()) <= 500) {
				Rectangle rj = SingletonJoueur.getInstance().getHitBox();
				Rectangle re = e.getHitBox();
				e.move((int)(rj.getCenterX()-re.getCenterX()) ,(int)(rj.getCenterY()-re.getCenterY()) ,true);
			}
			if (e instanceof AttackingEntity && Calcules.distB2E(e, SingletonJoueur.getInstance()) <= 100) {
				((AttackingEntity)e).attaquer(); 
			}
		}
	}
}
