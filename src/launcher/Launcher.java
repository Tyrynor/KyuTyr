package launcher;

import javax.swing.JFrame;

import constantes.Constantes;
import entitees.Monster;
import ihm.Fenetre;
import music.MusicListener;
import music.MusicManager;
import playerPreferences.Options;
import traductions.TranslationManager;
import usine.EntityStock;
import usine.SingletonFrame;
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
		TranslationManager.toFrensh();
		EntityStock.addNewEntity(new Monster(StatsFactory.createNewStats((int)(Math.random()*Constantes.IHM_TAILLE_FENETRE.getWidth()),(int)(Math.random()*Constantes.IHM_TAILLE_FENETRE.getHeight()))));
		Options.loadFromFile();
		MusicManager.setMenuMusic();
		MusicManager.launchMusic();
		SingletonFrame.getInstance().loop();
	}

}
