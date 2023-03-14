package de.swa.swing;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.swa.swing.model.Customer;

public class CustomerDetail extends JPanel {
	private JTextField vorname = new JTextField(20);
	private JTextField name = new JTextField(20);
	private JTextField strasse = new JTextField(20);
	private JTextField plz = new JTextField(20);
	private JTextField ort = new JTextField(20);
	
	public CustomerDetail() {
		super(new GridLayout(5, 2));
		
		add(new JLabel("Vorname"));
		add(vorname);
		add(new JLabel("Name"));
		add(name);
		add(new JLabel("Strasse"));
		add(strasse);
		add(new JLabel("PLZ"));
		add(plz);
		add(new JLabel("Ort"));
		add(ort);
	}
	
	public void setCustomer(Customer c) {
		vorname.setText(c.getVorname());
		name.setText(c.getName());
		strasse.setText(c.getStrasse());
		plz.setText(c.getPlz());
		ort.setText(c.getOrt());
	}
}
