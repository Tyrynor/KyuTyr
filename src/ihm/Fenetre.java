package ihm;

import javax.swing.JFrame;

import constantes.Constantes;
import controleur.KeyControl;
import usine.SingletonJoueur;

/**
 * 
 * @author Tyrynor, 22/07/2018
 *
 */
public class Fenetre extends JFrame {
	

	public Fenetre() {
		super(Constantes.IHM_NOM_FENTRE);
		this.setSize(Constantes.IHM_TAILLE_FENETRE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PrincipalPane p = new PrincipalPane();
		this.setContentPane(p);
		this.setUndecorated(true);
		this.addKeyListener(new KeyControl());
		SingletonJoueur.getInstance().addObserver(p);
		this.setVisible(true);
	}
	
}
