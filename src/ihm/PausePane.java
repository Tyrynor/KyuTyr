package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;

import constantes.Constantes;
import controleur.KeyControlMenu;
import controleur.MouseControl;
import controleur.KeyControl;
import music.MusicListener;
import music.MusicManager;
import outils.Variables;
import traductions.TranslationManager;
import usine.SingletonPrincipalPane;

public class PausePane extends JPanel {

	public JButton p;
	public JButton o;
	public JButton q;
	
	public PausePane() {
		super();
		Dimension size = Constantes.IHM_TAILLE_FENETRE;
		this.setPreferredSize(Constantes.IHM_TAILLE_FENETRE);
		this.requestFocusInWindow();
		this.setBackground(Color.GRAY);
		this.setLayout(null);
		p = new JButton(TranslationManager.translate("Continue"));
		p.setBounds((int)size.getWidth()/2-50, (int)size.getHeight()/2-125, 100, 50);
		p.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SingletonPrincipalPane.getInstance().changePane(null, new KeyControl(), new MouseControl());
				SingletonPrincipalPane.getInstance().requestFocusInWindow();
				MusicManager.music.pause();
				Variables.gamePaused = false;
			}
		});
		this.add(p);
		o = new JButton(TranslationManager.translate("Option"));
		o.setBounds((int)size.getWidth()/2-50, (int)size.getHeight()/2, 100, 50);
		o.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SingletonPrincipalPane.getInstance().changePane(new OptionPane(), new KeyControlMenu());
				SingletonPrincipalPane.getInstance().requestFocusInWindow();
			}
		});
		this.add(o);
		q = new JButton(TranslationManager.translate("Quit"));
		q.setBounds((int)size.getWidth()/2-50, (int)size.getHeight()/2+125, 100, 50);
		q.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.add(q);
	}
}
