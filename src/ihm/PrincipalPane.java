package ihm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.JPanel;

import constantes.Constantes;
import controleur.KeyControl;
import usine.EntityStock;
import usine.SingletonFrame;
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
	private KeyListener keyControler;
	private JPanel currentPane = null;
	
	public PrincipalPane() {
		this.setPreferredSize(Constantes.IHM_TAILLE_FENETRE);
		this.setLayout(null);
		this.timeIn = new Date().getTime();
		this.nbOfRedraw = 0;
		this.currentPane = new MenuPane();
		keyControler = new KeyControl();
		this.addKeyListener(keyControler);
		this.currentPane.setBounds(0, 0, Constantes.IHM_TAILLE_FENETRE.width, Constantes.IHM_TAILLE_FENETRE.height);
		this.add(this.currentPane);
	}
	
	public void changePane(JPanel p, KeyListener k) {
		this.remove(this.currentPane);
		if (p != null) {
			this.currentPane = p;
			this.currentPane.setBounds(0, 0, Constantes.IHM_TAILLE_FENETRE.width, Constantes.IHM_TAILLE_FENETRE.height);
			this.add(this.currentPane);
		}
		SingletonFrame.getInstance().removeKeyControl().addKeyControl(k);
		this.removeKeyControl().addKeyControl(k);
		this.repaint();
	}
	
	public void addKeyControl(KeyListener k) {
		this.addKeyListener(k);
		this.keyControler = k;
	}
	
	public PrincipalPane removeKeyControl() {
		this.removeKeyListener(this.keyControler);
		return this;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		nbOfRedraw++;
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		if (timeIn + 1000 < new Date().getTime()) {
			timeIn = new Date().getTime();
			lastNbOfRedraw = nbOfRedraw;
			nbOfRedraw = 0;
		}
		if (this.currentPane != null) this.currentPane.repaint();
		EntityStock.instanceList.forEach(e -> {
			e.draw(g);
		});
		SingletonJoueur.getInstance().draw(g);
		g.setColor(Color.RED);
		g.drawString(lastNbOfRedraw+"", 50,50);
	}
}
