package uebungen.kapitel2.seite73;

public class LineCounter extends FileProcessor {
	private int count;
	
	public void startProcessing() {
		count = 0;
	}
	
	public void processLine(String line) {
		count ++;
	}
	
	public int getCount() {
		return count;
	}
}
