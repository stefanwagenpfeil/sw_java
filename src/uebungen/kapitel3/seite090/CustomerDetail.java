package uebungen.kapitel3.seite090;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uebungen.kapitel3.seite090.model.Customer;

public class CustomerDetail extends JPanel {
	private JTextField vorname = new JTextField(20);
	private JTextField name = new JTextField(20);
	private JTextField strasse = new JTextField(20);
	private JTextField plz = new JTextField(20);
	private JTextField ort = new JTextField(20);
	
	public CustomerDetail() {
		super(new GridLayout(5, 2));
		
		add(new JLabel(Labels.get("ui.firstName")));
		add(vorname);
		add(new JLabel(Labels.get("ui.lastName")));
		add(name);
		add(new JLabel(Labels.get("ui.street")));
		add(strasse);
		add(new JLabel(Labels.get("ui.zip")));
		add(plz);
		add(new JLabel(Labels.get("ui.city")));
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
