package de.swa.swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleUI {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		JLabel l = new JLabel("Ein Text");
		JButton b = new JButton("Ein Button");
		JTextField t = new JTextField ("Ein Textfeld");

		p.setLayout(new FlowLayout());
		p.add(l);
		p.add(b);
		p.add(t);
		f.add(p);

		f.setSize(200, 100);
		f.setVisible(true);		
	}
}
