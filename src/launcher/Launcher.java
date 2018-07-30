package launcher;

import javax.swing.JFrame;

import constantes.Constantes;
import ihm.Fenetre;

/**
 * 
 * @author Tyrynor, 21/07/2018
 * History:
 *  - Tyrynor, 22/07/2018 Création
 *
 */
public class Launcher {
	
	/**
	 * Lanceur de l'application
	 * @param args
	 */
	public static void main(String[] args) {
		Fenetre fenetre = new Fenetre();
		fenetre.loop();
	}

}
