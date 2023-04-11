package uebungen.kapitel3.seite090;

import java.util.Locale;
import java.util.ResourceBundle;

public class Labels {
	public static Locale language = Locale.GERMAN;
	
	public static String get(String rbText) {
		ResourceBundle rb  = ResourceBundle.getBundle("resources/appTexts", language);
		String text = rb.getString(rbText);
		return text;
	}
}
