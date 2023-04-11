package uebungen.kapitel2.seite60;

public class UpdateCommand extends Command {
	private String id, text, oldText;
	public UpdateCommand(String id, String text) {
		this.id = id;
		this.text = text;
	}
	
	public void execute() {
		oldText = DBConnection.executeQuery("select text from ... where id='" + id + "';");
		DBConnection.execute("update ... set text='" + text + "' where id='" + id + "';");
	}
	
	public boolean canUndo() {
		return true;
	}
	
	public void undo() {
		DBConnection.execute("update ... set text='" + oldText + "' where id='" + id + "';");
	}
}
