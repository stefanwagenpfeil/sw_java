package uebungen.kapitel3.seite107;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressManager {
	private Statement stmt;
	
	public AddressManager() throws Exception {
		Class.forName("org.h2.Driver");
		Connection c = DriverManager.getConnection("jdbc:h2:./data");
		stmt = c.createStatement();
		
		stmt.executeUpdate("create table if not exists adressen(id varchar(20) not null primary key, name varchar(200), vorname varchar(100), strasse varchar(100), plz varchar(100), ort varchar(100));");
	}
	
	public void writeAddress(String id, String name, String vorname, String strasse, String plz, String ort) throws Exception {
		stmt.execute("insert into adressen values('" + id + "', '" + name + "', '" + vorname + "', '" + strasse + "', '" + plz + "', '" + ort + "');");
	}
	
	public void deleteAddress(String id) throws Exception {
		stmt.execute("delete from adressen where id='" + id + "';");
	}
	
	public String[] readAddress(String id) throws Exception {
		ResultSet rs = stmt.executeQuery("select * from adressen where id='" + id + "';");
		rs.next();
		
		String[] str = new String[6];
		for (int i = 0; i < 6; i++) {
			// Result-Set Index beginnt mit 1 anstatt mit 0
			str[i] = rs.getString(i + 1);
		}
		return str;
	}
}
