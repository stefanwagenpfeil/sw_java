package de.swa.international;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessagePrinter {
	public static void main(String[] args) {
		ResourceBundle rb  = ResourceBundle.getBundle("resources/appTexts", Locale.GERMAN);
		String text = rb.getString("dialogTitle");
		System.out.println(text);
		
		rb = ResourceBundle.getBundle("resources/appTexts", Locale.ENGLISH);
		text = rb.getString("dialogTitle");
		System.out.println(text);
	}
}
