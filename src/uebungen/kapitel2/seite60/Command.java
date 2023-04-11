package uebungen.kapitel2.seite60;

public abstract class Command {
	public abstract void execute();

	public boolean canUndo() {
		return false;
	}

	public void undo() {
	}
}
