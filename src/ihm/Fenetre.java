package ihm;

import javax.swing.JFrame;
import javax.swing.JPanel;

import constantes.Constantes;
import controleur.KeyControl;
import usine.EntityStock;
import usine.SingletonJoueur;

/**
 * 
 * @author Tyrynor, 22/07/2018
 *
 */
public class Fenetre extends JFrame {
	PrincipalPane jp = new PrincipalPane();

	public Fenetre() {
		super(Constantes.IHM_NOM_FENTRE);
		this.setSize(Constantes.IHM_TAILLE_FENETRE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(jp);
		this.setUndecorated(true);
		this.addKeyListener(new KeyControl());
		this.setVisible(true);
	}
	
	public void loop() {
		while (true) {
			try {
				SingletonJoueur.getInstance().move(0, 0);
				EntityStock.instanceList.forEach(e -> {
					e.move((int)(Math.random()*20)-10, (int)(Math.random()*20)-10);
				});
				jp.repaint();
				Thread.sleep(1000/Constantes.TARGETTEDFPS);
			}
			catch (Exception e) {
				
			}
		
		}
	}
	
	
}
