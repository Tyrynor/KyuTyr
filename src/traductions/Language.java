package traductions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

public abstract class Language {
	private File translateFile;
	private LinkedHashMap<String, String> translations;
	
	public Language(String fileName) {
		this.translateFile = new File ("src/annexFiles/languages/"+ fileName);
		try {
			this.translations = loadFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private LinkedHashMap<String, String> loadFile() throws IOException {
		LinkedHashMap <String, String> translations = new LinkedHashMap <String, String>();
		BufferedReader reader = new BufferedReader(new FileReader(translateFile));
		String row;
		while((row = reader.readLine())!= null && !row.equals("")) {
			String[] split = row.split("->");
			try{
				translations.put(split[0], split[1]);
			} catch(ArrayIndexOutOfBoundsException e) {
				translations.put(split[0], "#");
			}
		}
		reader.close();
		return translations;
	}
	
	public String translate(String str) {
		return translations.getOrDefault(str, "#");
	}
	
	public String translateInKey(String str) {
		return translations.getOrDefault(str, str);
	}
}
