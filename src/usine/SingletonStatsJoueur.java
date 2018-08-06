package usine;

import constantes.Constantes;
import outils.Stats;

public abstract class SingletonStatsJoueur {
	private static Stats instance = null;
	
	public static Stats getInstance() {
		if (instance == null) {
			instance = new Stats();
			instance.posX = 0;
			instance.posY = 0;
			instance.width = 50;
			instance.height = 50;
		}
		return instance;
	}
	
	public static void clearInstance() {
		instance = null;
	}
}
