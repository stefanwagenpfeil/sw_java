package uebungen.kapitel2.seite57;

public class HeadlineDecorator implements HTMLDecorator {
	private HTMLDecorator businessObject;
	
	public HeadlineDecorator(HTMLDecorator bo) {
		businessObject = bo;
	}
	
	public String getText(String text) {
		return "<h1>" + businessObject.getText(text) + "</h1>";
	}
}
