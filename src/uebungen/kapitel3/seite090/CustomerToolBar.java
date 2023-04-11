package uebungen.kapitel3.seite090;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import uebungen.kapitel3.seite090.model.Customer;

public class CustomerToolBar extends JToolBar implements ActionListener {
	public CustomerToolBar() {
		JButton open = new JButton(Labels.get("menu.new"));
		JButton del = new JButton(Labels.get("menu.delete"));
		JButton save = new JButton(Labels.get("menu.save"));
		
		// Bei Internationalisierung müssen ActionCommands explizit gesetzt werden
		open.setActionCommand("New");
		del.setActionCommand("Delete");
		save.setActionCommand("Save");
		
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
