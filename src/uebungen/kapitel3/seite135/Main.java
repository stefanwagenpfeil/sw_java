package uebungen.kapitel3.seite135;

import java.io.File;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new File("books.xml"));
		
		Element root = doc.getDocumentElement();
		Hashtable<String, Integer> elementCount = new Hashtable<String, Integer>();
		process(root, elementCount);
		
		for (String s : elementCount.keySet()) {
			int c = elementCount.get(s);
			System.out.println(s + " -> " + c);
		}
	}

	// Rekursiver Aufruf der Kind-Knoten im Dokument
	private static void process(Node n, Hashtable<String, Integer> elementCount) {
		String nodeName = n.getNodeName();
		int count = 0;
		if (elementCount.containsKey(nodeName)) {
			count = elementCount.get(nodeName);
		}
		count ++;
		elementCount.put(nodeName, count);
		
		NodeList nl = n.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			Node ni = nl.item(i);
			process(ni, elementCount);
		}
	}
}
