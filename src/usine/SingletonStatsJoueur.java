package usine;

import outils.Stats;

public class SingletonStatsJoueur {
	private static Stats instance = null;
	
	public static Stats getIntance() {
		if (instance == null) {
			instance = new Stats();
			instance.posX = 500;
			instance.posY = 500;
		}
		return instance;
	}
	
	public static void clearInstance() {
		instance = null;
	}
}
