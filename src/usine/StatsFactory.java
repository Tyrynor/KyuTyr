package usine;

import outils.Stats;

public abstract class StatsFactory {
	public static Stats createNewStats(int initPosX, int initPosY) {
		Stats s = new Stats();
		s.posX = initPosX;
		s.posY = initPosY;
		s.width = 20;
		s.height = 20;
		return s;
	}
}
