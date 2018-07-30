package usine;

import outils.Stats;

public class StatsFactory {
	public static Stats createNewStats(int initPosX, int initPosY) {
		Stats s = new Stats();
		s.posX = initPosX;
		s.posY = initPosY;
		return s;
	}
}
