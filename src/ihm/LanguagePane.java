package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import constantes.Constantes;
import controleur.KeyControlMenu;
import playerPreferences.Preferences;
import traductions.TranslationManager;
import controleur.KeyControl;
import usine.SingletonPrincipalPane;

public class LanguagePane extends JPanel {

	public JButton f;
	public JButton e;
	public JButton r;
	
	public LanguagePane() {
		super();
		Dimension size = Constantes.IHM_TAILLE_FENETRE;
		this.setPreferredSize(Constantes.IHM_TAILLE_FENETRE);
		this.requestFocusInWindow();
		this.setBackground(Color.GRAY);
		this.setLayout(null);
		f = new JButton(TranslationManager.translate("Français"));
		f.setBounds((int)size.getWidth()/2-150, (int)size.getHeight()/2-100, 100, 50);
		f.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TranslationManager.toFrench();
				translateTextButtons();
			}
		});
		this.add(f);
		e = new JButton(TranslationManager.translate("English"));
		e.setBounds((int)size.getWidth()/2+50, (int)size.getHeight()/2-100, 100, 50);
		e.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TranslationManager.toEnglish();
				translateTextButtons();
			}
		});
		this.add(e);
		r = new JButton(TranslationManager.translate("Return"));
		r.setBounds((int)size.getWidth()/2-50, (int)size.getHeight()/2+200, 100, 50);
		r.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Preferences.savePreferences();
				SingletonPrincipalPane.getInstance().changePane(new OptionPane(),new KeyControlMenu());
				SingletonPrincipalPane.getInstance().requestFocusInWindow();
			}
		});
		this.add(r);
	}
	
	public void translateTextButtons() {
		f.setText(TranslationManager.translate("Français"));
		e.setText(TranslationManager.translate("English"));
		r.setText(TranslationManager.translate("Return"));
	}
}

