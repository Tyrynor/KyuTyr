package ihm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.security.Principal;
import java.util.Date;

import javax.swing.JPanel;

import constantes.Constantes;
import controleur.KeyControl;
import controleur.MouseControl;
import usine.EntityStock;
import usine.SingletonFrame;
import usine.SingletonJoueur;
import usine.SingletonStatsJoueur;

/**
 * 
 * @author Tyrynor, 22/07/2018
 *
 */
public class PrincipalPane extends JPanel{
	
	private double timeIn;
	private int nbOfRedraw;
	private int lastNbOfRedraw = 0;
	private KeyListener keyControler = null;
	private MouseListener mouseListener = null;
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
		SingletonFrame.getInstance().removeKeyControl().addKeyControl(k).removeMouseControl();
		this.removeKeyControl().addKeyControl(k).removeMouseControl();
		this.repaint();
	}
	
	public void changePane(JPanel p, KeyListener k, MouseListener m) {
		this.remove(this.currentPane);
		if (p != null) {
			this.currentPane = p;
			this.currentPane.setBounds(0, 0, Constantes.IHM_TAILLE_FENETRE.width, Constantes.IHM_TAILLE_FENETRE.height);
			this.add(this.currentPane);
		}
		SingletonFrame.getInstance().removeKeyControl().addKeyControl(k).removeMouseControl().addMouseControl(m);
		this.removeKeyControl().addKeyControl(k).removeMouseControl().addMouseControl(m);
		this.repaint();
	}
	
	public PrincipalPane addKeyControl(KeyListener k) {
		this.addKeyListener(k);
		this.keyControler = k;
		return this;
	}
	
	public PrincipalPane addMouseControl(MouseListener m) {
		this.addMouseListener(m);
		this.mouseListener = m;
		return this;
	}
	
	public PrincipalPane removeKeyControl() {
		this.removeKeyListener(this.keyControler);
		return this;
	}
	
	public PrincipalPane removeMouseControl() {
		this.removeMouseListener(this.mouseListener);
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
		g.setColor(Color.BLACK);
		g.drawString(lastNbOfRedraw+"", this.getWidth() - 50,50);
		SingletonStatsJoueur.drawPlayerStats(g);
	}
}
