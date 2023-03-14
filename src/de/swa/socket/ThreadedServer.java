package de.swa.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jws.WebService;

@EJB
@WebService
@Stateless
@MessageDriven
public class ThreadedServer extends Thread implements MessageListener {
	@Override
	public void onMessage(Message arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public ThreadedServer() throws Exception {
		ServerSocket srv = new ServerSocket(1234);
		while (true) {
			Socket s = srv.accept();
			ThreadedServer ts = new ThreadedServer(s);
			ts.start();
		}
	}
	
	private Socket mySocket;
	private ThreadedServer(Socket s) {
		mySocket = s;
	}
	
	public void run() {
		try {
			InputStream in = mySocket.getInputStream();
			OutputStream out = mySocket.getOutputStream();
			PrintWriter pw = new PrintWriter(out);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
		}
		catch (Exception ex) {}
	}
}
