package ihm;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import constantes.Constantes;
import controleur.KeyControl;
import entitees.Joueur;
import usine.SingletonJoueur;

/**
 * 
 * @author Tyrynor, 22/07/2018
 *
 */
public class PrincipalPane extends JPanel implements Observer{
	
	public PrincipalPane() {
		this.setPreferredSize(Constantes.IHM_TAILLE_FENETRE);
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		SingletonJoueur.getInstance().draw(g);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.repaint();
	}
	
}
