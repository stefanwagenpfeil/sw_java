package uebungen.kapitel2.seite60;

public class Main {
	public static void main(String[] args) {
		CommandHistory ch = CommandHistory.getInstance();
		ch.executeCommand(new InsertCommand("27", "Stefan"));
		ch.executeCommand(new InsertCommand("28", "Heinz"));
		ch.executeCommand(new DeleteCommand("14"));
		ch.executeCommand(new UpdateCommand("28", "Klaus"));
		ch.undo();
		ch.undo();
		ch.redo();
	}
}
