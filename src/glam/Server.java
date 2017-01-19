package glam;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Server {
	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Server window = new Server();
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
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		List list = new List(shell, SWT.BORDER);
		list.setBounds(10, 33, 189, 219);
		
		Label lblLista = new Label(shell, SWT.NONE);
		lblLista.setAlignment(SWT.CENTER);
		lblLista.setBounds(10, 12, 189, 15);
		lblLista.setText("Lista");
		
		Label lblFiltra = new Label(shell, SWT.NONE);
		lblFiltra.setAlignment(SWT.CENTER);
		lblFiltra.setBounds(295, 12, 55, 15);
		lblFiltra.setText("Filtra:");
		
		ThreadServer ts = new ThreadServer(this);
		Thread server = new Thread(ts);
		server.start();
		
		Button btnFiltra = new Button(shell, SWT.NONE);
		btnFiltra.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		btnFiltra.setBounds(285, 115, 75, 25);
		btnFiltra.setText("Filtra");
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(280, 54, 80, 24);

	}
}
