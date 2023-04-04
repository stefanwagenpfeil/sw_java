package uebungen.kapitel2.seite47;

public class TaschenrechnerMain {
	public static void main(String[] args) {
		Taschenrechner t = Taschenrechner.getInstance();
		System.out.println(t.add(3, 4));
	}
}
