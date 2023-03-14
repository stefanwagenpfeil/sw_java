package de.swa.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

public class Sockets {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.stefan-wagenpfeil.de");
		URLConnection uc = url.openConnection();
		
//		ServerSocket ss = new ServerSocket(1234);
//		Socket s = ss.accept();
		
		
		Socket s = new Socket("www.stefan-wagenpfeil.de", 80);
		
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		PrintWriter pw = new PrintWriter(out);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		pw.println("GET /index.html HTTP/1.1");
		pw.println();
		pw.flush();
		
		String line = "";
		
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}
}
