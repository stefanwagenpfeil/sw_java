package uebungen.kapitel3.seite085;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoggingKeyListener implements KeyListener {
	public void keyPressed(KeyEvent e) {
		System.out.println("Press: " + e.getKeyChar());
		System.out.println("Modifiers: " + e.getModifiersEx());
		System.out.println("Shift: " + (e.getModifiersEx() == KeyEvent.SHIFT_DOWN_MASK));
		System.out.println("Alt: " + (e.getModifiersEx() == KeyEvent.ALT_DOWN_MASK));
	}
	
	public void keyReleased(KeyEvent e) {
		System.out.println("Release: " + e.getKeyChar());
	}
	
	public void keyTyped(KeyEvent e) {
		System.out.println("Type: " + e.getKeyChar());
	}
}
