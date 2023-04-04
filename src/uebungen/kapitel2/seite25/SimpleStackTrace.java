package uebungen.kapitel2.seite25;

public class SimpleStackTrace {
	public static int div(int x, int y) {
		return x / y;
	}
	
	public static int calculate(int x, int y) throws CalculationException {
		try {
			return x / 0;
		}
		catch (ArithmeticException ae) {
			throw new CalculationException("Fehlerhafte Eingabe: " + ae.getMessage());
		}
	}
	
	public static void main(String[] args) {
		try {
			calculate(3, 4);
		}
		catch (Exception ex) {
			System.out.println("Es ist ein Fehler aufgetreten: " + ex.getMessage());
		}
	}
}
