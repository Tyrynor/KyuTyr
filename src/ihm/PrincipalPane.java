package ihm;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import constantes.Constantes;
import entitees.Joueur;

/**
 * 
 * @author Tyrynor, 22/07/2018
 *
 */
public class PrincipalPane extends JPanel {
	
	private Joueur j;
	
	public PrincipalPane() {
		super();
		j = new Joueur(300, 300);
		this.setPreferredSize(Constantes.IHM_TAILLE_FENETRE);
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.BLUE);
		g.fillOval(100, 100, 100, 200);
		j.draw(g);
	}
	
}
