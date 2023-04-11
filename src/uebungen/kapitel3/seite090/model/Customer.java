package uebungen.kapitel3.seite090.model;

public class Customer {
	private String name, vorname, strasse, plz, ort;
	
	public Customer(String n, String v, String s, String p, String o) {
		name = n;
		vorname = v;
		strasse = s;
		plz = p;
		ort = o;
	}

	public Customer() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	public String toString() {
		return vorname + " " + name;
	}
	
}
