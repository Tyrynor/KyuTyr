package controleur;

/**
 * @author Tyrynor
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import constantes.Constantes;
import ihm.MenuPane;
import usine.SingletonJoueur;
import usine.SingletonPrincipalPane;

public class KeyContolMenu implements KeyListener {
	
	public boolean isChangingControl = false;
	/**
	 * 
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			SingletonPrincipalPane.getInstance().changePane(null,new KeyControl());
			SingletonPrincipalPane.getInstance().requestFocusInWindow();
			break;
		default : 
			if (isChangingControl) {
				
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}
