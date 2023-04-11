package uebungen.kapitel3.seite100;

import java.util.Date;

import javax.swing.JLabel;

public class TimeLabel extends JLabel implements Runnable {
	public TimeLabel() {
		Thread t = new Thread(this);
		t.start();
	}
	
	public void run() {
		while (true) {
			try {
				Date d = new Date();
				setText(d.toString());
				Thread.sleep(1000);
			}
			catch (Exception ex) {}
		}
	}
}
