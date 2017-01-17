package glam;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Client {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
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
		shell.setText("SWT Application");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(10, 56, 76, 21);
		
		Label lblNome = new Label(shell, SWT.NONE);
		lblNome.setAlignment(SWT.CENTER);
		lblNome.setBounds(10, 20, 76, 15);
		lblNome.setText("Nome");
		
		Button btnIscriviti = new Button(shell, SWT.NONE);
		btnIscriviti.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(text.getText()!=" "){
					
				}
			}
		});
		btnIscriviti.setBounds(10, 102, 75, 25);
		btnIscriviti.setText("Iscriviti");
		
		Label lblRisultato = new Label(shell, SWT.NONE);
		lblRisultato.setAlignment(SWT.CENTER);
		lblRisultato.setBounds(134, 20, 108, 107);
		lblRisultato.setText(" ");
		
	}
}
