package uebungen.kapitel3.seite123;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.google.de");
		URLConnection uc = url.openConnection();
		InputStream in = uc.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String line = "";
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}
}
