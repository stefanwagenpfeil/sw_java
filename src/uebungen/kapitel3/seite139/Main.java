package uebungen.kapitel3.seite139;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	private static void writeJson(Person p, File f) throws Exception {
		FileOutputStream fout = new FileOutputStream(f);
		PrintWriter out = new PrintWriter(fout);
		
		out.println("{");
		out.println("	\"vorname\":\"" + p.getVorname() + "\",");
		out.println("	\"nachname\":\"" + p.getNachname() + "\",");
		out.println("	\"emails\":\"[");
		for (String s : p.getEmailAddresses()) {
			out.println("  		\"" + s + "\",");
		}
		out.println("	]");
		out.println("}");
		
		out.close();
	}
	
	private static Person readJson(File f) throws Exception {
		Person p = new Person();
		FileInputStream fin = new FileInputStream(f);
		BufferedReader br = new BufferedReader(new InputStreamReader(fin));
		String content = "";
		String line = "";
		
		// Zeilenumbrüche entfernen
		while ((line = br.readLine()) != null) content += line;
		
		// Steuerzeichen entfernen
		content = content.replace("{", "");
		content = content.replace("}", "");
		
		// E-Mail-Block Inhalt auslesen
		String emailBlock = content.substring(content.indexOf("[") + 1, content.indexOf("]"));

		// an Kommas trennen
		StringTokenizer st = new StringTokenizer(content, ",");
		while (st.hasMoreTokens()) {
			String element = st.nextToken();
			// Anführungszeichen entfernen
			element = element.replace("\"", "");
			
			// jedes Element enthält nun den Namen der Variable und den Inhalt durch Doppelpunkt getrennt
			String[] str = element.split(":");
			String name = str[0].trim();
			
			if (name.equals("vorname")) {
				String value = str[1].trim();
				p.setVorname(value);
			}
			else if (name.equals("nachname")) {
				String value = str[1].trim();
				p.setNachname(value);
			}
			else if (name.equals("emails")) {
				emailBlock = emailBlock.replace("\"", "");
				String[] str2 = emailBlock.split(",");
				for (String s : str2) {
					p.addEmailAddress(s);
				}
			}
		}
		
		return p;
	}
	
	public static void main(String[] args) throws Exception {
		File f = new File("sample.json");
		
		Person p = new Person("Max", "Mustermann");
		p.addEmailAddress("info@some-company.com");
		p.addEmailAddress("me@gmx.de");
		writeJson(p, f);
		
		File f2 = new File("simple.json");
		Person p2 = readJson(f);
		System.out.println(p2);
		
		// und ja, das ist defintiv nicht schön, so etwas "zu Fuß" zu bauen...
	}
}
