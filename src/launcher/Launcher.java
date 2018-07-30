package launcher;

import javax.swing.JFrame;

import constantes.Constantes;
import entitees.Monster;
import ihm.Fenetre;
import usine.EntityStock;
import usine.StatsFactory;

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
		EntityStock.addNewEntity(new Monster(StatsFactory.createNewStats((int)(Math.random()*Constantes.IHM_TAILLE_FENETRE.getWidth()),(int)(Math.random()*Constantes.IHM_TAILLE_FENETRE.getHeight()))));
		fenetre.loop();
	}

}
