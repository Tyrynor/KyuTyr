package controleur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import usine.SingletonJoueur;

public class KeyControl implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		SingletonJoueur.getInstance().move(2, 2);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}
