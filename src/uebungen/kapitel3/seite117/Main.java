package uebungen.kapitel3.seite117;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
	public static void byteBasedCopy(File a, File b, int byteSize) {
		long startTime = System.currentTimeMillis();
		try {
			FileInputStream fin = new FileInputStream(a);
			FileOutputStream fout = new FileOutputStream(b);
			
			byte[] bytes = new byte[byteSize];
			while ((fin.read(bytes)) != -1) fout.write(bytes);
			
			fin.close();
			fout.close();
		}
		catch (FileNotFoundException fe) {
			System.out.println("File not Found " + fe);
		} catch (IOException e) {
			System.out.println("IO Exception: " + e);
		}
		long endTime = System.currentTimeMillis();
		long runTime = endTime - startTime;
		System.out.println("Duration: " + runTime + " Milliseconds");
	}
	
	public static void lineBasedCopy(File a, File b) {
		long startTime = System.currentTimeMillis();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(a)));
			PrintWriter out = new PrintWriter(new FileOutputStream(b));
			
			String line = "";
			while ((line = in.readLine()) != null) {
				out.println(line);
			}
			
			in.close();
			out.close();
		}
		catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
		long endTime = System.currentTimeMillis();
		long runTime = endTime - startTime;
		System.out.println("Duration: " + runTime + " Milliseconds");
	}
	
	public static void main(String[] args) {
		File a = new File("eineGroßeDatei.pdf");
		File b = new File("tempfile_" + System.currentTimeMillis() + ".pdf");
		
		byteBasedCopy(a, b, 128);
		byteBasedCopy(a, b, 512);
		byteBasedCopy(a, b, 1024);
		byteBasedCopy(a, b, 10000);
		
		lineBasedCopy(a, b);
	}
}
