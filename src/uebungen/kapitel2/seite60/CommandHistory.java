package uebungen.kapitel2.seite60;

import java.util.Vector;

public class CommandHistory {
	private Vector<Command> commandHistory = new Vector<Command>();
	private int idx = 0;
	
	private CommandHistory() {}
	private static CommandHistory instance;
	public static synchronized CommandHistory getInstance() {
		if (instance == null) instance = new CommandHistory();
		return instance;
	}

	public void executeCommand(Command c) {
		if (c.canUndo())
			commandHistory.add(c);
		c.execute();
		idx = commandHistory.size() - 1;
	}

	public void undo() {
		Command c = commandHistory.get(idx);
		c.undo();
		idx--;
	}

	public void redo() {
		Command c = commandHistory.get(idx);
		c.execute();
		idx++;
	}
}
