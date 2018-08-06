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
import controleur.KeyControl;
import usine.SingletonPrincipalPane;

public class MenuPane extends JPanel {

	public JButton p;
	public JButton o;
	public JButton q;
	
	public MenuPane() {
		super();
		Dimension size = Constantes.IHM_TAILLE_FENETRE;
		this.setPreferredSize(Constantes.IHM_TAILLE_FENETRE);
		this.requestFocusInWindow();
		this.setBackground(Color.GRAY);
		this.setLayout(null);
		p = new JButton("Play");
		p.setBounds((int)size.getWidth()/2-50, (int)size.getHeight()/2-125, 100, 50);
		p.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SingletonPrincipalPane.getInstance().changePane(null, new KeyControl());
				SingletonPrincipalPane.getInstance().requestFocusInWindow();
			}
		});
		this.add(p);
		o = new JButton("Option");
		o.setBounds((int)size.getWidth()/2-50, (int)size.getHeight()/2, 100, 50);
		this.add(o);
		q = new JButton("Quit");
		q.setBounds((int)size.getWidth()/2-50, (int)size.getHeight()/2+125, 100, 50);
		this.add(q);
	}
}
