package uebungen.kapitel2.seite25;

public class CalculationException extends Exception {
	private String msg;
	
	public CalculationException(String msg) {
		this.msg = msg;
	}
	
	public String getMessage() {
		return msg;
	}
}
