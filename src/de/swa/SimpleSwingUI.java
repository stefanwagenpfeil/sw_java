package de.swa;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SimpleSwingUI extends JFrame {
	public SimpleSwingUI() {
		String text = JOptionPane.showInputDialog("Bitte geben Sie einen Text ein");
		int i = JOptionPane.showConfirmDialog(this, "Wollen Sie den Text " + text + " wirklich speichern?");
		if (i == JOptionPane.YES_OPTION) { 
			JOptionPane.showMessageDialog(this, "Der Text wurde gespeichert");
		}
		
	}
	
	public static void main(String[] args) {
		new SimpleSwingUI();
		
		
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		
		f.setSize(300, 100);
		f.setVisible(true);
	}
}
