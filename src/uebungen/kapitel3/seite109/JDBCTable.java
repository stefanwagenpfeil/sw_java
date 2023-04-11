package uebungen.kapitel3.seite109;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class JDBCTable implements TableModel {
	private Statement stmt;
	private Vector<Vector<String>> result = new Vector<Vector<String>>();
	private Vector<String> columnNames = new Vector<String>();
	
	public JDBCTable(String driver, String url, String sql) {
		try {
			Class.forName("org.h2.Driver");
			Connection c = DriverManager.getConnection("jdbc:h2:./data");
			stmt = c.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			int columns = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				Vector<String> row = new Vector<String>();
				for (int i = 1; i <= columns; i++) {
					row.add(rs.getString(i));
				}
			}
			
			for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
				columnNames.add(rs.getMetaData().getColumnName(i));
			}
		}
		catch (Exception ex) {}
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public int getColumnCount() {
		return columnNames.size();
	}

	public String getColumnName(int columnIndex) {
		return columnNames.get(columnIndex);
	}

	public int getRowCount() {
		return result.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Vector<String> row = result.get(rowIndex);
		return row.get(columnIndex);
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {}	
	public void addTableModelListener(TableModelListener l) {}
	public void removeTableModelListener(TableModelListener l) {}
}
