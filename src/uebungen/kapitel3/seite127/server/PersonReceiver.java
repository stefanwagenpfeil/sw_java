package uebungen.kapitel3.seite127.server;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import uebungen.kapitel3.seite127.common.Person;

public class PersonReceiver extends Thread {
	public PersonReceiver() throws Exception {
		ServerSocket srv = new ServerSocket(1234);
		Socket s = null;
		
		while (true) {
			s = srv.accept();
			System.out.println("Client connected " + s.getInetAddress());
			PersonReceiver worker = new PersonReceiver(s);
			worker.start();
		}
	}
	
	private Socket s;
	public PersonReceiver(Socket s) {
		this.s = s;
	}
	
	public void run() {
		try {
			ObjectInputStream oin = new ObjectInputStream(s.getInputStream());
			while (true) {
				Object o = oin.readObject();
				Person p = (Person)o;
			
				System.out.println("Received: " + p.toString());
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
