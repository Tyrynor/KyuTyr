package controleur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import constantes.Constantes;
import ihm.MenuPane;
import usine.SingletonJoueur;
import usine.SingletonPrincipalPane;

public class KeyControl implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_UP: 
			SingletonJoueur.getInstance().top = true;
			break;
		case KeyEvent.VK_DOWN:
			SingletonJoueur.getInstance().bot = true;
			break;
		case KeyEvent.VK_RIGHT:
			SingletonJoueur.getInstance().right = true;
			break;
		case KeyEvent.VK_LEFT:
			SingletonJoueur.getInstance().left = true;
			break;
		case KeyEvent.VK_ESCAPE:
			MenuPane p = new MenuPane();
			SingletonPrincipalPane.getInstance().changePane(p, null);
			SingletonPrincipalPane.getInstance().requestFocusInWindow();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_UP: 
			SingletonJoueur.getInstance().top = false;
			break;
		case KeyEvent.VK_DOWN:
			SingletonJoueur.getInstance().bot = false;
			break;
		case KeyEvent.VK_RIGHT:
			SingletonJoueur.getInstance().right = false;
			break;
		case KeyEvent.VK_LEFT:
			SingletonJoueur.getInstance().left = false;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}