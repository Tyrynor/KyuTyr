package playerPreferences;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Preferences {
	private static Map<String, String> preferences;
	public static File preferenceFile = new File("src/annexFiles/playerSaveFile/preferences.jsf");
	
	public static Map<String, String> getPreferences() {
		if (preferences == null) {
			preferences = new HashMap<String, String>();
			loadPreferencesFiles();
		}
		return preferences;
	}
	
	private static void loadPreferencesFiles() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(preferenceFile));
			String str;
			while ((str = reader.readLine())!=null) {
				if (!str.equals("")) {
					String[] split = str.split("->");
					preferences.put(split[0], split[1]);
				}
			}
			reader.close();
		} catch( IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void savePreferences() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(preferenceFile));
			getPreferences().forEach((key, value) -> {
				try {
					writer.write(key+"->"+value+"\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
