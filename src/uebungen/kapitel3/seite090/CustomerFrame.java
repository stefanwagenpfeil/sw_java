package uebungen.kapitel3.seite090;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import uebungen.kapitel3.seite090.model.Customer;

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
		JMenu fileMenu = new JMenu(Labels.get("menu.file"));
		JMenu helpMenu = new JMenu(Labels.get("menu.help"));
		
		JMenuItem fileOpen = new JMenuItem(Labels.get("menu.new"));
		JMenuItem fileDelete = new JMenuItem(Labels.get("menu.delete"));
		JMenuItem fileClose = new JMenuItem(Labels.get("menu.close"));
		JMenuItem fileExit = new JMenuItem(Labels.get("menu.exit"));
		JMenuItem helpAbout = new JMenuItem(Labels.get("menu.about"));
		
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
