
package controleur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

import playerPreferences.Options;
import traductions.TranslationManager;
import usine.SingletonPrincipalPane;

public class KeyMapControl implements KeyListener {

	private String name;
	private JButton bouton;
	
	
	public KeyMapControl(String name, JButton bouton) {
		this.name = name;
		this.bouton = bouton;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() != KeyEvent.VK_ESCAPE) {
			Options.affectByName(this.name,e.getKeyCode());
		}
		bouton.setText(TranslationManager.translateInKey(Options.getKeyName(this.name)));
		SingletonPrincipalPane.getInstance().removeKeyControl().addKeyControl(null);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
