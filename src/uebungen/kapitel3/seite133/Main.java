package uebungen.kapitel3.seite133;

import java.io.File;
import java.util.Hashtable;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Main extends DefaultHandler {
	private Hashtable<String, Integer> elementCount = new Hashtable<String, Integer>();
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		int count = 0;
		if (elementCount.containsKey(qName)) {
			count = elementCount.get(qName);
		}
		count ++;
		elementCount.put(qName, count);
	}
	
	public void endDocument() throws SAXException {
		for (String s : elementCount.keySet()) {
			int c = elementCount.get(s);
			System.out.println(s + " -> " + c);
		}
	}
	
	public static void main(String[] args) throws Exception {
		SAXParserFactory spf = SAXParserFactory.newDefaultInstance();
		SAXParser sp = spf.newSAXParser();
		File f = new File("books.xml");
		sp.parse(f, new Main());
	}
}
