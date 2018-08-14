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

public class KeyControlMenu implements KeyListener {
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			SingletonPrincipalPane.getInstance().changePane(null,new KeyControl());
			SingletonPrincipalPane.getInstance().requestFocusInWindow();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}
