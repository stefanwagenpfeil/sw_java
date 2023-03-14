package de.swa.swing;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import de.swa.swing.model.Customer;

public class CustomerListRenderer extends DefaultListCellRenderer {
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		
		Customer c = (Customer)value;
		JLabel name = new JLabel(c.getVorname() + " " + c.getName());
		return name;
	}
}
