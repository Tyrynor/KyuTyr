package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import constantes.Constantes;
import controleur.KeyControlMenu;
import traductions.TranslationManager;
import controleur.KeyControl;
import usine.SingletonPrincipalPane;

public class OptionPane extends JPanel {

	public JButton p;
	public JButton o;
	public JButton q;
	public JButton l;
	
	public OptionPane() {
		super();
		Dimension size = Constantes.IHM_TAILLE_FENETRE;
		this.setPreferredSize(Constantes.IHM_TAILLE_FENETRE);
		this.requestFocusInWindow();
		this.setBackground(Color.GRAY);
		this.setLayout(null);
		p = new JButton(TranslationManager.translate("Display"));
		p.setBounds((int)size.getWidth()/2-50, (int)size.getHeight()/2-200, 100, 50);
		p.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SingletonPrincipalPane.getInstance().changePane(null,new KeyControlMenu());
				SingletonPrincipalPane.getInstance().requestFocusInWindow();
			}
		});
		this.add(p);
		o = new JButton(TranslationManager.translate("Controls"));
		o.setBounds((int)size.getWidth()/2-50, (int)size.getHeight()/2-100, 100, 50);
		o.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SingletonPrincipalPane.getInstance().changePane(new ControlPane(), new KeyControlMenu());
				SingletonPrincipalPane.getInstance().requestFocusInWindow();
			}
		});
		this.add(o);
		q = new JButton(TranslationManager.translate("Return"));
		q.setBounds((int)size.getWidth()/2-50, (int)size.getHeight()/2+200, 100, 50);
		q.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SingletonPrincipalPane.getInstance().changePane(new MenuPane(),new KeyControlMenu());
				SingletonPrincipalPane.getInstance().requestFocusInWindow();
			}
		});
		this.add(q);
		l = new JButton(TranslationManager.translate("Language"));
		l.setBounds((int)size.getWidth()/2-50, (int)size.getHeight()/2, 100, 50);
		l.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SingletonPrincipalPane.getInstance().changePane(new LanguagePane(),new KeyControlMenu());
				SingletonPrincipalPane.getInstance().requestFocusInWindow();
			}
		});
		this.add(l);
	}
}

