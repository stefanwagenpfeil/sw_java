package uebungen.kapitel3.seite085;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class SimpleUI extends JFrame {
	public SimpleUI() {
		setSize(300, 300);
		setLayout(new FlowLayout());
		JTextField tf = new JTextField(20);
		tf.addKeyListener(new LoggingKeyListener());
		add(tf);
		setVisible(true);
	}
}
