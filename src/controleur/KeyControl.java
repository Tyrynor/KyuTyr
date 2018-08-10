package controleur;

/**
 * @author Tyrynor
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import constantes.Constantes;
import ihm.MenuPane;
import playerPreferences.Options;
import usine.SingletonJoueur;
import usine.SingletonPrincipalPane;

public class KeyControl implements KeyListener {
	/**
	 * 
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		int request = arg0.getKeyCode();
		switch (request) {
		case KeyEvent.VK_ESCAPE:
			MenuPane p = new MenuPane();
			SingletonPrincipalPane.getInstance().changePane(p, new KeyContolMenu());
			SingletonPrincipalPane.getInstance().requestFocusInWindow();
			break;
		default:
			if (request == Options.up) SingletonJoueur.getInstance().top = true;
			else if (request == Options.down) SingletonJoueur.getInstance().bot = true;
			else if (request == Options.left) SingletonJoueur.getInstance().left = true;
			else if (request == Options.right) SingletonJoueur.getInstance().right = true;
		}
	}

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
