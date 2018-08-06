package ihm;

import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import constantes.Constantes;
import controleur.KeyControl;
import usine.EntityStock;
import usine.SingletonJoueur;
import usine.SingletonPrincipalPane;

/**
 * 
 * @author Tyrynor, 22/07/2018
 *
 */
public class Fenetre extends JFrame {
	
	private KeyListener keyControler = null;

	public Fenetre() {
		super(Constantes.IHM_NOM_FENTRE);
		this.setSize(Constantes.IHM_TAILLE_FENETRE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(SingletonPrincipalPane.getInstance());
		this.setUndecorated(true);
		this.addKeyControl(new KeyControl());
		this.setVisible(true);
	}
	
	public void addKeyControl(KeyListener k) {
		this.addKeyListener(k);
		this.keyControler = k;
	}
	
	public Fenetre removeKeyControl() {
		this.removeKeyListener(this.keyControler);
		return this;
	}
	
	public void loop() {
		while (true) {
			try {
				SingletonJoueur.getInstance().move(0, 0);
				SingletonPrincipalPane.getInstance().repaint();
				Thread.sleep(1000/Constantes.TARGETTEDFPS);
			}
			catch (Exception e) {
				
			}
		
		}
	}
	
	
}
