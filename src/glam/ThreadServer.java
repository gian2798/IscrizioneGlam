package glam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ThreadServer implements Runnable {
	
	String nome;
	Server s;
	ServerSocket server = null;
	Socket client = null;
	static Database dt = new Database();
	static ArrayList<Iscritto> iscrittoServer = new ArrayList();
	
	public ThreadServer(Server server) {
		// TODO Auto-generated constructor stub
		s = server;
		
		try {
			dt.Database();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		iscrittoServer = dt.getIscritto();
		s.aggiornaLista(iscrittoServer);
		
	}
	
	@Override
	public void run() {
		
		try {
			int controllo = 1;
			server = new ServerSocket(9999);
			while (true) {				
				
				Socket clientSocket = server.accept(); // Accetta la connessione
				InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
				BufferedReader in = new BufferedReader(isr);
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
				
				//connessione col database
				
				
				nome = in.readLine();
				
				//controllo se il è nome già inserito
				
				System.out.println(iscrittoServer.size());
				if(iscrittoServer.size()!=0){
					
				for(int i = 0; i< iscrittoServer.size(); i++){
					if(nome == iscrittoServer.get(i).getNome()){
						out.println("c'è già");
						controllo=1;
						break;
					}else{
						controllo = 0;
					}
					
				}
				if(controllo == 0){
					dt.inserisciIscrizione(nome);
					s.aggiornaLista(iscrittoServer);
					out.println("Inserito correttamente");
				}
				}else{
					dt.inserisciIscrizione(nome);
					out.println("Inserito correttamente");
					s.aggiornaLista(iscrittoServer);
				}
				//fine controllo

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
