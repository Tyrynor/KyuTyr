package usine;

import entitees.Joueur;

public abstract class SingletonJoueur {
	private static Joueur instance = null;
	
	public static Joueur getInstance() {
		if (instance == null) {
			instance = new Joueur();
		}
		return instance;

	}
	public static boolean clearInstance() {
		SingletonStatsJoueur.clearInstance();
		instance = null;
		return true;
	}
}