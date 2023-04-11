package uebungen.kapitel3.seite107;

public class Main {
	public static void main(String[] args) throws Exception {
		AddressManager am = new AddressManager();
		
		am.writeAddress("1", "Müller", "Sebastian", "Hinterm Haus", "12345", "Irgendwo");
		am.writeAddress("2", "Meier", "Susanne", "Vor dem Berg", "54321", "Irgendwo anders");
		
		String[] str = am.readAddress("1");
		for (String s : str) System.out.println("Datenbankfeld: " + s);
		
		am.deleteAddress("2");
	}
}
