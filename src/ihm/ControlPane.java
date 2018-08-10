package ihm;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constantes.Constantes;
import playerPreferences.Options;

public class ControlPane extends JPanel {

	public JLabel up;
	public JButton upText;
	public JLabel down;
	public JButton downText;
	public JLabel left;
	public JButton leftText;
	public JLabel right;
	public JButton rightText;
	
	public ControlPane() {
		super();
		Dimension size = Constantes.IHM_TAILLE_FENETRE;
		this.setPreferredSize(Constantes.IHM_TAILLE_FENETRE);
		this.requestFocusInWindow();
		this.setBackground(Color.GRAY);
		this.setLayout(null);
		up = new JLabel("UP");
		up.setBounds((int)size.getWidth()/2-100, (int)size.getHeight()/2-150, 100, 50);
		this.add(up);
		upText = new JButton(Options.getKeyName("up"));
		upText.setBounds((int)size.getWidth()/2, (int)size.getHeight()/2-150, 100, 50);
		this.add(upText);
		down = new JLabel("DOWN");
		down.setBounds((int)size.getWidth()/2-100, (int)size.getHeight()/2-100, 100, 50);
		this.add(down);
		downText = new JButton(Options.getKeyName("down"));
		downText.setBounds((int)size.getWidth()/2, (int)size.getHeight()/2-100, 100, 50);
		this.add(downText);
		left = new JLabel("LEFT");
		left.setBounds((int)size.getWidth()/2-100, (int)size.getHeight()/2-50, 100, 50);
		this.add(left);
		leftText = new JButton(Options.getKeyName("left"));
		leftText.setBounds((int)size.getWidth()/2, (int)size.getHeight()/2-50, 100, 50);
		this.add(leftText);
		right = new JLabel("RIGHT");
		right.setBounds((int)size.getWidth()/2-100, (int)size.getHeight()/2, 100, 50);
		this.add(right);
		rightText = new JButton(Options.getKeyName("right"));
		rightText.setBounds((int)size.getWidth()/2, (int)size.getHeight()/2, 100, 50);
		this.add(rightText);
		
	}
}
