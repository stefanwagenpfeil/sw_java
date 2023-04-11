package uebungen.kapitel3.seite109;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JDBCFrame extends JFrame {
	JTable table = new JTable();
	JTextField query = new JTextField(20);

	public JDBCFrame() {
		setLayout(new BorderLayout());
		add(query, BorderLayout.NORTH);
		add(new JScrollPane(table), BorderLayout.CENTER);
		
		setSize(500, 500);
		setVisible(true);
	
		query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String q = query.getText();
				table.setModel(new JDBCTable("org.h2.Driver", "jdbc:h2:./data", q));
			}
		});
	}
}
