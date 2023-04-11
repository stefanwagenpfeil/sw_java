package uebungen.kapitel3.seite090;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uebungen.kapitel3.seite090.model.Customer;
import uebungen.kapitel3.seite090.model.CustomerList;

public class CustomerListAdapter extends JPanel implements ListSelectionListener {
	CustomerListModel clm = new CustomerListModel();
	
	public CustomerListAdapter() {
		JList<Customer> list = new JList<Customer>();
		list.setModel(new CustomerListModel());
//		list.setCellRenderer(new CustomerListRenderer());
		JScrollPane sp = new JScrollPane(list);
		add(sp);
		
		list.addListSelectionListener(this);
	}
	
	public void valueChanged(ListSelectionEvent e) {
		int idx = e.getFirstIndex();
		Customer c = CustomerList.getInstance().getCustomer(idx);
		CustomerFrame.getInstance().select(c);
	}
}
