package traductions;

import playerPreferences.Preferences;

public class TranslationManager {
	public static Language currentLanguage;
	
	public static void toFrench() {
		if(!(currentLanguage instanceof French)) {
			currentLanguage = new French();
			Preferences.getPreferences().replace("lang", "fr");
		}
	}
	
	public static void toEnglish() {
		if(!(currentLanguage instanceof English)) {
			currentLanguage = new English();
			Preferences.getPreferences().replace("lang", "en");
		}
	}
	
	public static String translate(String str) {
		return currentLanguage.translate(str);
	}
	
	public static String translateInKey(String str) {
		return currentLanguage.translateInKey(str);
	}
	
	public static void loadLanguagePreference() {
		String lang = Preferences.getPreferences().get("lang");
		if (lang.equals("fr")) {
			toFrench();
		} else {
			toEnglish();
		}
	}
}
