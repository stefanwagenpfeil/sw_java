package uebungen.kapitel3.seite139;

import java.util.Vector;

public class Person {
	private String vorname, nachname;
	private Vector<String> emailAddress = new Vector<String>();
	
	
	public Person() {}
	
	public Person(String v, String n) {
		vorname = v;
		nachname = n;
	}
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public Vector<String> getEmailAddresses() {
		return emailAddress;
	}
	public void setEmailAddresses(Vector<String> emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public void addEmailAddress(String s) {
		emailAddress.add(s);
	}
	
	public String toString() {
		String s = "Person (" + vorname + " " + nachname + ")";
		for (String email : emailAddress) s += "\n - " + email;
		
		return s;
	}
}
