package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Date;
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
public class PrincipalPane extends JPanel{
	
	private double timeIn;
	private int nbOfRedraw;
	private int lastNbOfRedraw = 0;
	
	public PrincipalPane() {
		this.setPreferredSize(Constantes.IHM_TAILLE_FENETRE);
		this.timeIn = new Date().getTime();
		this.nbOfRedraw = 0;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		nbOfRedraw++;
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		if (timeIn + 1000 < new Date().getTime()) {
			timeIn = new Date().getTime();
			lastNbOfRedraw = nbOfRedraw;
			nbOfRedraw = 0;
		}
		SingletonJoueur.getInstance().draw(g);
		g.setColor(Color.RED);
		g.drawString(lastNbOfRedraw+"", 50,50);
	}
}
