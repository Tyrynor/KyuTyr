package usine;

import outils.Stats;

public class SingletonStatsJoueur {
	private static Stats instance = null;
	
	public static Stats getInstance() {
		if (instance == null) {
			instance = new Stats();
			instance.posX = 0;
			instance.posY = 0;
		}
		return instance;
	}
	
	public static void clearInstance() {
		instance = null;
	}
}
