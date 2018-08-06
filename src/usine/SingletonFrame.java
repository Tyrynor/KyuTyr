package usine;

import ihm.Fenetre;

public class SingletonFrame {
	private static Fenetre instance = null;
	
	public static Fenetre getInstance() {
		if (instance == null) {
			instance = new Fenetre();
		}
		return instance;

	}
	public static void clearInstance() {
		instance = null;
	}
}
