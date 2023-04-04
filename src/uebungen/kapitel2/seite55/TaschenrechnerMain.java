package uebungen.kapitel2.seite55;

public class TaschenrechnerMain {
	public static void main(String[] args) {
		ITaschenrechner t = TaschenrechnerFactory.getITaschenrechner();
		t.add(3, 4);
	}
}
