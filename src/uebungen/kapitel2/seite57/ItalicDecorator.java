package uebungen.kapitel2.seite57;

public class ItalicDecorator implements HTMLDecorator {
	private HTMLDecorator businessObject;
	
	public ItalicDecorator(HTMLDecorator bo) {
		businessObject = bo;
	}
	
	public String getText(String text) {
		return "<i>" + businessObject.getText(text) + "</i>";
	}
}
