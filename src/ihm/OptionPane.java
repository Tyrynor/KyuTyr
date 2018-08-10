package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import constantes.Constantes;
import controleur.KeyContolMenu;
import controleur.KeyControl;
import usine.SingletonPrincipalPane;

public class OptionPane extends JPanel {

	public JButton p;
	public JButton o;
	public JButton q;
	
	public OptionPane() {
		super();
		Dimension size = Constantes.IHM_TAILLE_FENETRE;
		this.setPreferredSize(Constantes.IHM_TAILLE_FENETRE);
		this.requestFocusInWindow();
		this.setBackground(Color.GRAY);
		this.setLayout(null);
		p = new JButton("Affichage");
		p.setBounds((int)size.getWidth()/2-50, (int)size.getHeight()/2-125, 100, 50);
		p.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SingletonPrincipalPane.getInstance().changePane(null,new KeyContolMenu());
				SingletonPrincipalPane.getInstance().requestFocusInWindow();
			}
		});
		this.add(p);
		o = new JButton("Control");
		o.setBounds((int)size.getWidth()/2-50, (int)size.getHeight()/2, 100, 50);
		o.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SingletonPrincipalPane.getInstance().changePane(new ControlPane(), new KeyContolMenu());
				SingletonPrincipalPane.getInstance().requestFocusInWindow();
			}
		});
		this.add(o);
		q = new JButton("Retour");
		q.setBounds((int)size.getWidth()/2-50, (int)size.getHeight()/2+125, 100, 50);
		q.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SingletonPrincipalPane.getInstance().changePane(new MenuPane(),new KeyContolMenu());
				SingletonPrincipalPane.getInstance().requestFocusInWindow();
			}
		});
		this.add(q);
	}
}

