package de.swa;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.Vector;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Test {
	public static void main2(String[] args) throws Exception {
		Path p = Path.of("/Users/demo/test.txt");
		File f = p.toFile();
		
		Files.copy(p, new FileOutputStream(new File("text.txt")));
		Files.copy(p,  p, StandardCopyOption.REPLACE_EXISTING);
		Files.delete(p);
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer(new StreamSource(new File("myTransform.xsl")));
		t.transform(new StreamSource(new File("myXML.xml")), new StreamResult(new File("myResult.xml")));
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new File("myXML.xml"));
		
		Element root = doc.getDocumentElement();
		NodeList nl = root.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			Node ni = nl.item(i);
			NamedNodeMap attributes = ni.getAttributes();
			NodeList furtherChildren = ni.getChildNodes();
			String name = ni.getNodeName();
			String value = ni.getFirstChild().getNodeValue();
		}
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setValidating(true);
		SAXParser sp = spf.newSAXParser();
//		sp.parse(new File("myXML.xml"), new MyHandler());
	}
	
	class MyHandler extends DefaultHandler {
		private int count = 0;
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if (qName.equals("betrag")) count ++;
		}
		
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			// TODO Auto-generated method stub
			super.characters(ch, start, length);
		}
		
		public int getCount() {
			return count;
		}
	}
	
	class MyThread extends Thread {}

	public static void main(String[] args) throws Exception {
		Date d1 = new Date();
		Thread.sleep(1000);
		long millis = System.currentTimeMillis();
		Date d2 = new Date(millis);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = sdf.format(d1);
		d2 = sdf.parse("2001-02-03 04:05:06");
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(d1);
		cal.setTimeInMillis(millis);
		cal.add(Calendar.YEAR, -1);
		long lastYearMillis = cal.getTimeInMillis();
		Date d3 = cal.getTime();
		
//		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//		scheduler.schedule(new Test().MyThread(), 5, TimeUnit.SECONDS);
//		scheduler.scheduleAtFixedRate(new MyThread(), 3, 3, TimeUnit.SECONDS);		
	}
	
	public static void main3(String[] args) throws Exception {
		Vector<String> v = new Vector<String>();
		v.add("Heinz");
		v.add("Petra");
		v.add("Klaus");
		String s = v.get(2);
		for (String str : v) { }

		Collections.sort(v);
		
		LinkedList<String> l = new LinkedList<String>();
		l.push("Heinz");
		l.push("Petra");
		l.push("Klaus");
		String st = l.peek();
		st = l.pop();
		for (String str : l) { }
		
		Collections.sort(l);
		
		Set<String> set = new HashSet<String>();
		set.add("Heinz");
		set.add("Petra");
		set.add("Klaus");
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			String str = iter.next();
		}
		for (String str : set) { }
		
		Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
		ht.put(1, "Heinz");
		ht.put(2, "Petra");
		ht.put(3, "Klaus");
		String str = ht.get(2);
		
		Set<Integer> keys = ht.keySet();
		for (int key : keys) {
			String val = ht.get(key);
		}
		
		
		Logger logger = Logger.getLogger("defaultLogger");
		logger.setLevel(Level.SEVERE);
		
		logger.addHandler(new ConsoleHandler());
		logger.addHandler(new FileHandler("simpleLog"));
		logger.addHandler(new FileHandler("completeLog", 1000, 10, true));		

		ConsoleHandler ch = new ConsoleHandler();
		ch.setFormatter(new XMLFormatter());
		logger.addHandler(ch);
		
		logger.log(Level.WARNING, "Eine Warnung.");
		logger.warning("Eine weitere Warnung.");
		logger.info("Eine Information.");
		logger.severe("Ein ernstes Problem");
		logger.finest("Ein Ablauf-Detail.");

		
		Person p = new Person();
		JsonObjectBuilder job = Json.createObjectBuilder()
			.add("vorname", p.getVorname())
			.add("nachname", p.getName());
		
		JsonArrayBuilder jab = Json.createArrayBuilder();
		for (String email : p.getEmailAddresses()) {
			jab.add(email);
		}
		job.add("emails", jab);

		JsonObject jo = job.build();
		Json.createWriter(System.out).write(jo);
	}
}
