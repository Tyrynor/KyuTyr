package usine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import constantes.Constantes;
import outils.Calcules;
import outils.Stats;
import traductions.TranslationManager;

public abstract class SingletonStatsJoueur {
	private static Stats instance = null;
	
	public static Stats getInstance() {
		if (instance == null) {
			instance = new Stats();
			instance.posX = 0;
			instance.posY = 0;
			instance.width = 50;
			instance.height = 50;
			instance.defense = 10;
			instance.dex = 1;
			instance.hp = 5;
			instance.maxHp = 15;
			instance.intel = 2;
			instance.mana = 20;
			instance.maxMana = 20;
			instance.maxStamina = 20;
			instance.stamina = 20;
			instance.panic = 0;
			instance.panic_resist = 1;
			instance.str = 10;
			instance.power = 2;
		}
		return instance;
	}
	
	public static void clearInstance() {
		instance = null;
	}
	
	public static void drawPlayerStats(Graphics g) {
		Stats i = getInstance();
		// Pour la vie
		g.setColor(Color.RED);
		g.drawString(TranslationManager.translate("Hp"), 40, 115);
		Rectangle life = new Rectangle(100, 100, Calcules.percent(i.hp,i.maxHp)*3, 20);
		Rectangle lifeMax = new Rectangle(100, 100, 300, 20);
		((Graphics2D)g).draw(lifeMax);
		((Graphics2D)g).fill(life);
		// Pour le mana
		g.setColor(Color.BLUE);
		g.drawString(TranslationManager.translate("Mana"), 40, 165);
		Rectangle mana = new Rectangle(100, 150, Calcules.percent(i.mana,i.maxMana)*3, 20);
		Rectangle manaMax = new Rectangle(100, 150, 300, 20);
		((Graphics2D)g).draw(manaMax);
		((Graphics2D)g).fill(mana);
		// Pour l'endurance
		g.setColor(Color.GREEN);
		g.drawString(TranslationManager.translate("Stamina"), 40, 215);
		Rectangle stamina = new Rectangle(100, 200, Calcules.percent(i.stamina,i.maxStamina)*3, 20);
		Rectangle staminaMax = new Rectangle(100, 200, 300, 20);
		((Graphics2D)g).draw(staminaMax);
		((Graphics2D)g).fill(stamina);
	}
}
