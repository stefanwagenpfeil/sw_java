package uebungen.kapitel2.seite68;

public class Person {
	private Zustand currentState = new StudentState();
	
	public void vorstellen() {
		currentState.vorstellen();
	}
	
	public void einstellen() {
		if (currentState instanceof StudentState) {
			currentState = new AngestellterState();
		}
		else throw new RuntimeException("Hier werden nur Studenten eingestellt.");
	}
	
	public void kuendigen() {
		if (currentState instanceof StudentState) throw new RuntimeException("Studenten können nicht entlassen werden.");
		else if (currentState instanceof AngestellterState) {
			currentState = new StudentState();
		}
	}
}
