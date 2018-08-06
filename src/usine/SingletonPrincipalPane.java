package usine;

import ihm.PrincipalPane;

public class SingletonPrincipalPane {
	private static PrincipalPane instance = null;
	
	public static PrincipalPane getInstance() {
		if (instance == null) {
			instance = new PrincipalPane();
		}
		return instance;

	}
	public static void clearInstance() {
		instance = null;
	}
}
