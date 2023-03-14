package de.swa;

import java.util.Vector;

public class Person {
	private String vorname = "Max";
	private String name = "Mustermann";

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Vector<String> getEmailAddresses() {
		Vector<String> v = new Vector<String>();
		v.add("info@some-company.com");
		v.add("me@gmx.de");
		return v;
	}	
}
