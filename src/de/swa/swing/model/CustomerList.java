package de.swa.swing.model;

import java.util.Vector;

public class CustomerList {
	private Vector<Customer> customers = new Vector<Customer>();
	private CustomerList() {
		fillCustomers();
	}
	
	// Singleton
	private static CustomerList instance = null;
	public static synchronized CustomerList getInstance() {
		if (instance == null) instance = new CustomerList();
		return instance;
	}
	
	public int getCustomerCount() {
		return customers.size();
	}
	
	public Customer getCustomer(int i) {
		return customers.get(i);
	}
	
	public void addCustomer(Customer c) {
		customers.add(c);
		for (CustomerListener cl : listeners) cl.customerListChanged(); 
	}
	
	public void deleteCustomer(int i) {
		customers.remove(i);
		for (CustomerListener cl : listeners) cl.customerListChanged(); 
	}
	
	private Vector<CustomerListener> listeners = new Vector<CustomerListener>();
	public void addCusstomerListener(CustomerListener cl) {
		listeners.add(cl);
	}

	private void fillCustomers() {
		customers.add(new Customer("Eichel", "Jessica", "Gotthardstrasse 89", "09116", "Chemnitz"));
		customers.add(new Customer("Krause", "Phillipp", "Hermannstrasse 88", "67549", "Worms Hochheim"));
		customers.add(new Customer("Dietrich", "Ute", "Luebecker Strasse 46", "97453", "Schonungen"));
		customers.add(new Customer("Roth", "Eric", "Marseiller Strasse 48", "82482", "Oberammergau"));
		customers.add(new Customer("Schmitz", "Peter", "Boxhagener Str. 22", "20149", "Hamburg Harvestehude"));
		customers.add(new Customer("Wagner", "Marko", "Anhalter Strasse 36", "67808", "Weitersweiler"));
		customers.add(new Customer("Nadel", "Dirk", "Holstenwall 59", "06469", "Nachterstedt"));
		customers.add(new Customer("Sanger", "Sandra", "Güntzelstrasse 77", "54518", "Rivenich"));
		customers.add(new Customer("Werner", "Benjamin", "Straße der Pariser Kommune 39", "53177", "Bonn"));
		customers.add(new Customer("Ebersbacher", "Angelika", "Güntzelstrasse 11", "54518", "Minheim"));
		customers.add(new Customer("Fuchs", "Manuela", "Landhausstraße 49", "15505", "Fürstenwalde"));
	}
}
