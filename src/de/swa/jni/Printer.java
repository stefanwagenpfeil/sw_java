package de.swa.jni;

public class Printer {
	public void print() {
		format();
	}
	
	public native void format();
}
