package uebungen.kapitel2.seite60;

public class DeleteCommand extends Command {
	private String id, text, oldText;
	public DeleteCommand(String id) {
		this.id = id;
	}
	
	public void execute() {
		oldText = DBConnection.executeQuery("select text from ... where id='" + id + "';");
		DBConnection.execute("delete from ... where id='" + id + "';");
	}
	
	public boolean canUndo() {
		return true;
	}
	
	public void undo() {
		DBConnection.execute("insert into ... values('" + id + "', '" + text + "');");
	}
}
