package uebungen.kapitel2.seite60;

public class InsertCommand extends Command {
	private String id, text;
	public InsertCommand(String id, String text) {
		this.id = id;
		this.text = text;
	}
	
	public void execute() {
		DBConnection.execute("insert into ... values('" + id + "', '" + text + "');");
	}
	
	public boolean canUndo() {
		return true;
	}
	
	public void undo() {
		DBConnection.execute("delete from ... where id='" + id + "';");
	}
}
