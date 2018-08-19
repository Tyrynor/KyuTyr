package traductions;

public class TranslationManager {
	public static Language currentLanguage;
	
	public static void toFrench() {
		if(!(currentLanguage instanceof French)) {
			currentLanguage = new French();
		}
	}
	
	public static void toEnglish() {
		if(!(currentLanguage instanceof English)) {
			currentLanguage = new English();
		}
	}
	
	public static String translate(String str) {
		return currentLanguage.translate(str);
	}
	
	public static String translateInKey(String str) {
		return currentLanguage.translateInKey(str);
	}
}
