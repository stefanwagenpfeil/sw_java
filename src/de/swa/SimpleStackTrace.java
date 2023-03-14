package de.swa;

public class SimpleStackTrace {
	public static int div(int x, int y) {
		return x / y;
	}
	
	public static int calculate(int x, int y) {
		return x / 0;
	}
	
	public static void main(String[] args) {
		calculate(3, 4);
	}
}
