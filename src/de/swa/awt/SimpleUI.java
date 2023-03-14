package de.swa.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class SimpleUI {
	public static void main(String[] args) {
		Frame f = new Frame();
		Panel p = new Panel();
		Label l = new Label("Ein Text");
		Button b = new Button("Ein Button");
		TextField t = new TextField ("Ein Textfeld");

		p.setLayout(new FlowLayout());
		p.add(l);
		p.add(b);
		p.add(t);
		f.add(p);

		f.setSize(200, 100);
		f.setVisible(true);
	}
}
