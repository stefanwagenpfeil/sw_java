package de.swa.swing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import de.swa.swing.model.Customer;

public class CustomerFrame extends JFrame {
	private CustomerDetail cd = new CustomerDetail();
	private CustomerListAdapter cl = new CustomerListAdapter();
	private CustomerToolBar ct = new CustomerToolBar();
	
	private CustomerFrame() {
		setJMenuBar(getMenu());
		
		JPanel content = new JPanel(new BorderLayout());
		content.add(ct, "North");
		content.add(cl, "West");
		content.add(cd, "Center");
		
		add(content); 

		setSize(500, 200);
		setVisible(true);
	}
	
	private static CustomerFrame instance = null;
	public static CustomerFrame getInstance() {
		if (instance == null) instance = new CustomerFrame();
		return instance;
	}
	
	public void select(Customer c) {
		cd.setCustomer(c);
	}
	
	private JMenuBar getMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu helpMenu = new JMenu("Help");
		
		JMenuItem fileOpen = new JMenuItem("New");
		JMenuItem fileDelete = new JMenuItem("Delete");
		JMenuItem fileClose = new JMenuItem("Close");
		JMenuItem fileExit = new JMenuItem("Exit");
		JMenuItem helpAbout = new JMenuItem("About");
		
		fileMenu.add(fileOpen);
		fileMenu.add(fileDelete);
		fileMenu.add(fileClose); 
		fileMenu.addSeparator();
		fileMenu.add(fileExit);
		helpMenu.add(helpAbout);
		
		mb.add(fileMenu);
		mb.add(helpMenu);
		return mb;
	}
}
