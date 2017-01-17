package glam;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServer implements Runnable {
	Server s;
	ServerSocket server = null;
	Socket client = null;
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
				System.out.println("Server: Ho ricevuto il nome " + clientSocket.getInputStream().read());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
