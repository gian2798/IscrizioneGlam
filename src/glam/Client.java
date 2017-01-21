package glam;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Client {

	protected Shell shell;
	private Text text;
	static Socket s;
	
	static PrintWriter out;
	static InputStreamReader ISR = new InputStreamReader(System.in);
	static BufferedReader BR = new BufferedReader(ISR);

	/**
	 * Launch the application.
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		
		try {
			Client window = new Client();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(268, 203);
		shell.setText("Client");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(10, 56, 76, 21);
		
		Label lblNome = new Label(shell, SWT.NONE);
		lblNome.setAlignment(SWT.CENTER);
		lblNome.setBounds(10, 35, 76, 15);
		lblNome.setText("Nome");
		
		Label lblRisultato = new Label(shell, SWT.NONE);
		lblRisultato.setAlignment(SWT.CENTER);
		lblRisultato.setBounds(109, 52, 133, 75);
		lblRisultato.setText(" ");
		
		Button btnIscriviti = new Button(shell, SWT.NONE);
		btnIscriviti.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					s = new Socket("localhost", 9999);
					out = new PrintWriter(s.getOutputStream(), true);

					
					int c=0;
					if(text.getText()!=" " && text.getText()!=""){
						String nome = text.getText();
						out.println(nome);
						text.setText("");
					}else{
						c=1;
						JOptionPane.showMessageDialog(null, "errore, inserisci qualcosa", "errore", JOptionPane.ERROR_MESSAGE);;
					}
					if(c != 1){
						String risultato = BR.readLine();
						lblRisultato.setText(risultato);
					}
					s.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			}
		});
		btnIscriviti.setBounds(10, 102, 75, 25);
		btnIscriviti.setText("Iscriviti");
		
		
		
	}
	
	private static String getInput(){
		try {
			return BR.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
