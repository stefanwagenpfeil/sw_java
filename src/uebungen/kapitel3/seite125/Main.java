package uebungen.kapitel3.seite125;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Main {
	public static void main(String[] args) throws Exception {
		URL url = new URL("https://docs.oracle.com/javase/tutorial/");
		URLConnection uc = url.openConnection();
		InputStream in = uc.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String line = "";
		String content = "";
		while ((line = br.readLine()) != null) {
			content += line;
		}

		JFrame f = new JFrame("Simple HTML Viewer");
		JEditorPane ep = new JEditorPane();
		ep.setContentType("text/html");
		ep.setText(content);
		f.getContentPane().add(new JScrollPane(ep));
		f.setSize(400, 400);
		f.setVisible(true);
		
		// P.S.: es geht auch einfacher:
		JEditorPane ep2 = new JEditorPane(url);
	}
}
