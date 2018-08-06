package usine;

import java.util.ArrayList;

import entitees.Entity;

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
}
