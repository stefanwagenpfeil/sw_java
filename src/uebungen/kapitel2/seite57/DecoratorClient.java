package uebungen.kapitel2.seite57;

public class DecoratorClient {
	public static void main(String[] args) {
		String text = "Guten Morgen";
		HTMLDecorator tp = new TextProducer();
		HTMLDecorator bold = new BoldDecorator(tp);
		HTMLDecorator italic = new ItalicDecorator(bold);
		HTMLDecorator headline = new HeadlineDecorator(italic);
		String result = headline.getText(text);
		System.out.println(result);
	}
}
