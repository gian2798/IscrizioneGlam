package glam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ThreadServer implements Runnable {
	Server s;
	ServerSocket server = null;
	Socket client = null;
	static Database dt = new Database();
	public ThreadServer(Server server) {
		// TODO Auto-generated constructor stub
		s = server;
	}
	
	@Override
	public void run() {
		try {
			server = new ServerSocket(9999);
			while (true) {				
				
				Socket clientSocket = server.accept(); // Accetta la connessione
				InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
				BufferedReader in = new BufferedReader(isr);
				String n = in.readLine();
				dt.inserisciIscrizione(n);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
