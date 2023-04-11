package uebungen.kapitel2.seite60;

public class DBConnection {
	public static void execute(String sql) {
		System.out.println("Dummy SQL wird ausgeführt: " + sql);
	}
	
	public static String executeQuery(String sql) {
		System.out.println("Dummy SQL wird ausgeführt: " + sql);
		System.out.println("Dummy Wert wird zurück gegeben");
		return "Test";
	}
}
