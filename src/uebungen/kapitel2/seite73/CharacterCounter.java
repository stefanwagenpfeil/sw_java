package uebungen.kapitel2.seite73;

public class CharacterCounter extends FileProcessor {
	private int chars = 0;
	
	public void processLine(String line) {
		chars += line.length();
	}
	
	public int getCharacterCount() {
		return chars;
	}
}
