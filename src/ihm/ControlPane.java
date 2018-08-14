package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constantes.Constantes;
import controleur.KeyControlMenu;
import controleur.KeyMapControl;
import controleur.KeyControl;
import playerPreferences.Options;
import traductions.TranslationManager;
import usine.SingletonPrincipalPane;

public class ControlPane extends JPanel {

	public JLabel up;
	public JButton upText;
	public JLabel down;
	public JButton downText;
	public JLabel left;
	public JButton leftText;
	public JLabel right;
	public JButton rightText;
	public JButton back;
	public JButton save;
	public JButton cancel;
	private final ControlPane self = this;
	private final KeyControlMenu control;
	Dimension size = Constantes.IHM_TAILLE_FENETRE;

	public ControlPane() {
		super();
		this.setPreferredSize(size);
		this.requestFocusInWindow();
		this.setBackground(Color.GRAY);
		this.setLayout(null);
		this.control = (KeyControlMenu) SingletonPrincipalPane.getInstance().getKeyListeners()[0];
		up = new JLabel(TranslationManager.translate("UP"));
		up.setBounds((int)size.getWidth()/2-100, (int)size.getHeight()/2-150, 100, 50);
		this.add(up);
		upText = new JButton(TranslationManager.translateInKey(Options.getKeyName("up")));
		upText.setBounds((int)size.getWidth()/2, (int)size.getHeight()/2-150, 100, 50);
		upText.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SingletonPrincipalPane.getInstance().requestFocusInWindow();
				SingletonPrincipalPane.getInstance().removeKeyControl().addKeyControl(new KeyMapControl("up", upText));
				upText.setText(TranslationManager.translate(Constantes.LISTENING_TEXT));
				changingState();
			}
		});
		this.add(upText);
		down = new JLabel(TranslationManager.translate("DOWN"));
		down.setBounds((int)size.getWidth()/2-100, (int)size.getHeight()/2-100, 100, 50);
		this.add(down);
		downText = new JButton(TranslationManager.translateInKey(Options.getKeyName("down")));
		downText.setBounds((int)size.getWidth()/2, (int)size.getHeight()/2-100, 100, 50);
		downText.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SingletonPrincipalPane.getInstance().requestFocusInWindow();
				SingletonPrincipalPane.getInstance().removeKeyControl().addKeyControl(new KeyMapControl("down", downText));
				downText.setText(TranslationManager.translate(Constantes.LISTENING_TEXT));
				changingState();
			}
		});
		this.add(downText);
		left = new JLabel(TranslationManager.translate("LEFT"));
		left.setBounds((int)size.getWidth()/2-100, (int)size.getHeight()/2-50, 100, 50);
		this.add(left);
		leftText = new JButton(TranslationManager.translateInKey(Options.getKeyName("left")));
		leftText.setBounds((int)size.getWidth()/2, (int)size.getHeight()/2-50, 100, 50);
		leftText.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SingletonPrincipalPane.getInstance().requestFocusInWindow();
				SingletonPrincipalPane.getInstance().removeKeyControl().addKeyControl(new KeyMapControl("left", leftText));
				leftText.setText(TranslationManager.translate(Constantes.LISTENING_TEXT));
				changingState();
			}
		});
		this.add(leftText);
		right = new JLabel(TranslationManager.translate("RIGHT"));
		right.setBounds((int)size.getWidth()/2-100, (int)size.getHeight()/2, 100, 50);
		this.add(right);
		rightText = new JButton(TranslationManager.translateInKey(Options.getKeyName("right")));
		rightText.setBounds((int)size.getWidth()/2, (int)size.getHeight()/2, 100, 50);
		rightText.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SingletonPrincipalPane.getInstance().requestFocusInWindow();
				SingletonPrincipalPane.getInstance().removeKeyControl().addKeyControl(new KeyMapControl("right", rightText));
				rightText.setText(TranslationManager.translate(Constantes.LISTENING_TEXT));
				changingState();
			}
		});
		this.add(rightText);
		this.back = new JButton(TranslationManager.translate("Return"));
		back.setBounds((int)size.getWidth()/2 - 50, (int)size.getHeight()/2 + 100, 100, 50);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SingletonPrincipalPane.getInstance().changePane(new OptionPane(), new KeyControlMenu());
				SingletonPrincipalPane.getInstance().requestFocusInWindow();
			}
		});
		this.add(back);
		
	}
	
	public final void changingState() {
		this.remove(back);
		this.save = new JButton(TranslationManager.translate("Cancel"));
		save.setBounds((int)size.getWidth()/2 - 200, (int)size.getHeight()/2 + 100, 120, 50);
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Options.loadFromFile();
				SingletonPrincipalPane.getInstance().changePane(new OptionPane(), new KeyControlMenu());
				SingletonPrincipalPane.getInstance().requestFocusInWindow();
			}
		});
		this.add(save);
		this.cancel = new JButton(TranslationManager.translate("Save"));
		cancel.setBounds((int)size.getWidth()/2, (int)size.getHeight()/2 + 100, 120, 50);
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Options.saveToFile();
				SingletonPrincipalPane.getInstance().changePane(new OptionPane(), new KeyControlMenu());
				SingletonPrincipalPane.getInstance().requestFocusInWindow();
			}
		});
		this.add(cancel);
	}
}
