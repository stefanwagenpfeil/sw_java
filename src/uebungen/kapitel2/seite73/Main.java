package uebungen.kapitel2.seite73;

import java.io.File;

import javax.swing.JFileChooser;

public class Main {
	public static void main(String[] args) throws Exception {
		// Dateiauswahldialog anzeigen
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(null);
		File f = fc.getSelectedFile();
		
		LineCounter lc = new LineCounter();
		CharacterCounter cc = new CharacterCounter();
		lc.processFile(f);
		cc.processFile(f);
		
		System.out.println("Lines: " + lc.getCount());
		System.out.println("Chars: " + cc.getCharacterCount());
	}
}
