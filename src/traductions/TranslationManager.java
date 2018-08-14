package traductions;

public class TranslationManager {
	public static Language currentLanguage;
	
	public static void toFrensh() {
		if(!(currentLanguage instanceof Frensh)) {
			currentLanguage = new Frensh();
		}
	}
	
	public static String translate(String str) {
		return currentLanguage.translate(str);
	}
	
	public static String translateInKey(String str) {
		return currentLanguage.translateInKey(str);
	}
}
