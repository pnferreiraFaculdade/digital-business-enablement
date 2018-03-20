package br.com.fiap.view;

import org.apache.axis2.AxisFault;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.repository.FiapRepository;

public class Tela{

	protected Shell shell;
	private Text txtNac;
	private Text txtAm;
	private Text txtPs;
	private Text txtResultado;

	/**
	 * Launch the application.
	 * @param args
	 * @throws AxisFault 
	 */
	public static void main(String[] args) {

		
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * @throws Exception 
	 */
	public void open() throws Exception {
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
	 * @throws AxisFault 
	 */
	protected void createContents() throws Exception {
		
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblNac = new Label(shell, SWT.NONE);
		lblNac.setBounds(36, 41, 39, 15);
		lblNac.setText("NAC");
		
		Label lblAm = new Label(shell, SWT.NONE);
		lblAm.setBounds(36, 84, 30, 15);
		lblAm.setText("AM");
		
		Label lblPs = new Label(shell, SWT.NONE);
		lblPs.setBounds(36, 126, 39, 15);
		lblPs.setText("PS");
		
		txtNac = new Text(shell, SWT.BORDER);
		txtNac.setBounds(84, 38, 76, 21);
		
		txtAm = new Text(shell, SWT.BORDER);
		txtAm.setBounds(84, 81, 76, 21);
		
		txtPs = new Text(shell, SWT.BORDER);
		txtPs.setText("");
		txtPs.setBounds(84, 123, 76, 21);
		
		Button btnCalcular = new Button(shell, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Clique do botão
				float nac = Float.parseFloat(txtNac.getText());
				float am = Float.parseFloat(txtAm.getText());
				float ps = Float.parseFloat(txtPs.getText());
				//float media = nac*0.2f + am*0.3f + ps*0.5f; 
				try {
					FiapRepository rep = new FiapRepository();
					float media = rep.calcularMedia(am, nac, ps);
					txtResultado.setText(String.valueOf(media));
				} catch (Exception ex) {
					txtResultado.setText("Erro");
				}
			}
		});
		btnCalcular.setBounds(84, 166, 75, 25);
		btnCalcular.setText("Calcular");
		
		txtResultado = new Text(shell, SWT.BORDER);
		txtResultado.setEditable(false);
		txtResultado.setBounds(84, 197, 76, 21);

	}
}
