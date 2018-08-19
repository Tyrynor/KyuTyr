package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import usine.SingletonJoueur;

public class MouseControl implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		SingletonJoueur.getInstance().attaquer(arg0);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
