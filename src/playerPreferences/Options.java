package playerPreferences;

import java.awt.event.KeyEvent;

public class Options {
	public static int up = KeyEvent.VK_UP; 
	public static int down = KeyEvent.VK_DOWN;
	public static int left = KeyEvent.VK_LEFT;
	public static int right = KeyEvent.VK_RIGHT;
	
	public static String getKeyName (String name) {
		int key = 0;
		if (name.equals("up")) {
			key = up;
		} else if (name.equals("down")) {
			key = down;
		} else if (name.equals("left")) {
			key = left;
		} else if (name.equals("right")) {
			key = right;
		}
		return KeyEvent.getKeyText(key);
	}
}
