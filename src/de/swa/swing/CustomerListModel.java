package de.swa.swing;

import java.util.Vector;

import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import de.swa.swing.model.Customer;
import de.swa.swing.model.CustomerList;
import de.swa.swing.model.CustomerListener;

public class CustomerListModel implements ListModel<Customer>, CustomerListener {
	private CustomerList model = CustomerList.getInstance();
	
	public Customer getElementAt(int index) {
		return model.getCustomer(index);
	}

	public int getSize() {
		return model.getCustomerCount();
	}
	
	public void customerListChanged() {
		for (ListDataListener ldl : listeners) {
			ldl.contentsChanged(new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, getSize()));
		}
	}

	private Vector<ListDataListener> listeners = new Vector<ListDataListener>();
	public void addListDataListener(ListDataListener l) {
		listeners.add(l);
	}
	public void removeListDataListener(ListDataListener l) {
		listeners.remove(l);
	}
}
