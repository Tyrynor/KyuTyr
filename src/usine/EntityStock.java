package usine;

import java.util.ArrayList;

import entitees.Entity;
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
			if (Calcules.distB2E(e, SingletonJoueur.getInstance()) <= 500) {
				e.move(SingletonStatsJoueur.getInstance().posX-e.getStats().posX ,SingletonStatsJoueur.getInstance().posY-e.getStats().posY ,true);
			}
		}
	}
}
