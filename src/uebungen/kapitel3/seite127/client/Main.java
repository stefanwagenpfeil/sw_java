package uebungen.kapitel3.seite127.client;

import java.io.ObjectOutputStream;
import java.net.Socket;

import uebungen.kapitel3.seite127.common.Person;

public class Main {
	public static void main(String[] args) throws Exception {
		Person p = new Person("Mustermann", "Max", "Hinterm Haus 1", "12345", "Musterstadt");
		Person p2 = new Person("Mustermann", "Melanie", "Hinterm Haus 2", "54321", "Musterstadt");
		
		Socket s = new Socket("localhost", 1234);
		ObjectOutputStream oout = new ObjectOutputStream(s.getOutputStream());
		oout.writeObject(p);;
		oout.flush();
		
		oout.writeObject(p2);
		oout.flush();
		oout.close();
	}
}
