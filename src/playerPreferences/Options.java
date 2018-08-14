package playerPreferences;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Options {
	public static int up = KeyEvent.VK_UP; 
	public static int down = KeyEvent.VK_DOWN;
	public static int left = KeyEvent.VK_LEFT;
	public static int right = KeyEvent.VK_RIGHT;
	public static File keyFile = new File("src/annexFiles/keyControlFile/KeyMap.jsf");

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
	
	public static boolean affectByName(String name,int key) {
		if (name.equals("up")) {
			up = key;
		} else if (name.equals("down")) {
			down = key;
		} else if (name.equals("left")) {
			left = key;
		} else if (name.equals("right")) {
			right = key;
		} else return false;
		return true;
	}
	
	public static boolean loadFromFile() {
		if (!keyFile.exists()) {
			try {
				File f = new File ("src/annexFiles/keyControlFile");
				if (!f.isDirectory()) {
					f.mkdirs();
				}
				keyFile.createNewFile();
				saveToFile();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		else {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(keyFile));
				up = Integer.parseInt(reader.readLine().split(":")[1]);
				down = Integer.parseInt(reader.readLine().split(":")[1]);
				left = Integer.parseInt(reader.readLine().split(":")[1]);
				right = Integer.parseInt(reader.readLine().split(":")[1]);
				reader.close();
			} catch( IOException e) {
				e.printStackTrace();
				return false;
			}
		}
			
		return true;
	}
	
	public static boolean saveToFile() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(keyFile));
			writer.write("up:"+up+'\n');
			writer.write("down:"+down+'\n');
			writer.write("left:"+left+'\n');
			writer.write("right:"+right+'\n');
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} 
		
		return true;
	}
}
