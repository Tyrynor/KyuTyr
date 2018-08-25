package controleur;

/**
 * @author Tyrynor
 * Classe qui gère les entrées clavier dans le jeu
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import constantes.Constantes;
import ihm.MenuPane;
import ihm.PausePane;
import music.MusicManager;
import outils.Variables;
import playerPreferences.Options;
import usine.SingletonJoueur;
import usine.SingletonPrincipalPane;

public class KeyControl implements KeyListener {
	/**
	 * Méthode qui permet le déplacement du joueur
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		int request = arg0.getKeyCode();
		switch (request) {
		case KeyEvent.VK_ESCAPE:
			PausePane p = new PausePane();
			SingletonPrincipalPane.getInstance().changePane(p, new KeyControlMenu());
			SingletonPrincipalPane.getInstance().requestFocusInWindow();
			MusicManager.music.playOn();
			Variables.gamePaused = true;
			SingletonJoueur.getInstance().top = false;
			SingletonJoueur.getInstance().bot = false;
			SingletonJoueur.getInstance().left = false;
			SingletonJoueur.getInstance().right = false;
			break;
		default:
			if (request == Options.up) SingletonJoueur.getInstance().top = true;
			else if (request == Options.down) SingletonJoueur.getInstance().bot = true;
			else if (request == Options.left) SingletonJoueur.getInstance().left = true;
			else if (request == Options.right) SingletonJoueur.getInstance().right = true;
		}
	}

	/**
	 * Méthode qui permet d'arreter le déplacement du joueur
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		int request = arg0.getKeyCode();
		switch (request) {
		default:
			if (request == Options.up) SingletonJoueur.getInstance().top = false;
			else if (request == Options.down) SingletonJoueur.getInstance().bot = false;
			else if (request == Options.left) SingletonJoueur.getInstance().left = false;
			else if (request == Options.right) SingletonJoueur.getInstance().right = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}
