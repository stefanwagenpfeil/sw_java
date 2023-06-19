package uebungen.kapitel3.seite148;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main extends Thread {
	public void run() {
		Date d = new Date();
		System.out.println("Uhrzeit: " + d.toString());
	}
	
	public static void main(String[] args) throws Exception {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(new Main(), 1, 1, TimeUnit.SECONDS);
	}
}
