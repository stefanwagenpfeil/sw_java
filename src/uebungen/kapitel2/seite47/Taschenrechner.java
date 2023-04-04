package uebungen.kapitel2.seite47;

public class Taschenrechner {
	private Taschenrechner() {}
	private static Taschenrechner instance = null;
	public synchronized static Taschenrechner getInstance() {
		if (instance == null) instance = new Taschenrechner();
		return instance;
	}
	
	
	public int add(int x, int y) {
		return x + y;
	}
	
	public int sub(int x, int y) {
		return x - y;
	}
	
	public int mult(int x, int y) {
		return x * y;
	}
	
	public int div(int x, int y) {
		return x / y;
	}
}
