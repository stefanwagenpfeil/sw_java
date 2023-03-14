package de.swa.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import de.swa.swing.model.Customer;

public class CustomerToolBar extends JToolBar implements ActionListener {
	public CustomerToolBar() {
		JButton open = new JButton("New");
		JButton del = new JButton("Delete");
		JButton save = new JButton("Save");
		add(open);
		add(del);
		add(save);
		
		open.addActionListener(this);
		del.addActionListener(this);
		save.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("New")) {
			Customer c = new Customer();
			CustomerFrame.getInstance().select(c);
		}
		else if (e.getActionCommand().equals("Delete")) {
			
		}
		else if (e.getActionCommand().equals("Save")) {
			
		}
	}
}
