package ihm;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import constantes.Constantes;

/**
 * 
 * @author Tyrynor, 22/07/2018
 *
 */
public class PrincipalPane extends JPanel {
	
	public PrincipalPane() {
		super();
		this.setPreferredSize(Constantes.IHM_TAILLE_FENETRE);
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.BLUE);
		g.fillOval(100, 100, 100, 200);
	}
	
}
