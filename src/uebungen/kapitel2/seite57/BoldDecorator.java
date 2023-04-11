package uebungen.kapitel2.seite57;

public class BoldDecorator implements HTMLDecorator {
	private HTMLDecorator businessObject;
	
	public BoldDecorator(HTMLDecorator bo) {
		businessObject = bo;
	}
	
	public String getText(String text) {
		return "<b>" + businessObject.getText(text) + "</b>";
	}
}
