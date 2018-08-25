package controleur;

/**
 * @author Tyrynor
 * Classe qui gère les entrées clavier dans le menu du jeu
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import constantes.Constantes;
import ihm.MenuPane;
import music.MusicManager;
import outils.Variables;
import playerPreferences.Options;
import usine.SingletonJoueur;
import usine.SingletonPrincipalPane;

public class KeyControlMenu implements KeyListener {
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			if (Variables.isAlreadyStarted) {
				SingletonPrincipalPane.getInstance().changePane(null,new KeyControl());
				SingletonPrincipalPane.getInstance().requestFocusInWindow();
				MusicManager.music.pause();
				Variables.gamePaused = false;
			}
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}
