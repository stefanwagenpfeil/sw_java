package uebungen.kapitel2.seite73;

import java.io.File;
import java.io.RandomAccessFile;

public abstract class FileProcessor {
	public final void processFile(File f) throws Exception {
		RandomAccessFile rf = new RandomAccessFile(f, "rw");
		startProcessing();
		String line = "";
		while ((line = rf.readLine()) != null) {
			processLine(line);
		}
		endProcessing();
	}
	
	public abstract void processLine(String line);
	public void startProcessing() {}
	public void endProcessing() {}
}
