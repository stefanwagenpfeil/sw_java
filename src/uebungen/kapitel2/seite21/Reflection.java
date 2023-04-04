package uebungen.kapitel2.seite21;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.swing.JOptionPane;

public class Reflection {
	public static void main(String[] args) throws Exception {
		String className = JOptionPane.showInputDialog("Name der Klasse");
		
		// Klasse laden
		Class c = Class.forName(className);
		Method[] methods = c.getMethods();
		for (Method m : methods) {
			System.out.println("Methode: " + m.getName());
		}
		
		// Instanz der Klasse mit Default-Konstruktor erzeugen
		Object o = c.newInstance();
		
		// Methode auswählen
		String methodName = JOptionPane.showInputDialog("Name der Methode");
		for (Method m : methods) {
			if (m.getName().equals(methodName)) {
				// Methode ohne Parameter aufrufen, hierzu die erzeugte Instanz verwenden
				if (m.getParameterCount() == 0) {
					m.invoke(o, null);
				}
				// wenn Parameter benötigt werden: abfragen, hier am Beispiel String
				else {
					Parameter[] params = m.getParameters();
					Object[] values = new Object[params.length];
					for (int i = 0; i < params.length; i++) {
						Parameter p = params[i];
						String s = JOptionPane.showInputDialog("Wert des Parameters " + p.getName());
						values[i] = s;
					}
					
					// Methode mit String-Parameter aufrufen
					m.invoke(o, values);
				}
			}
		}
	}
}
