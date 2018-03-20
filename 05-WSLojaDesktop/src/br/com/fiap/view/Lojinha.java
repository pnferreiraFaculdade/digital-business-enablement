package br.com.fiap.view;

import java.rmi.RemoteException;
import java.util.List;

import org.apache.axis2.AxisFault;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.loja.EstoqueBOStub.Produto;
import br.com.fiap.repository.EstoqueRepository;
import org.eclipse.wb.swt.SWTResourceManager;

public class Lojinha {

	protected Shell shell;
	private Text txtNome;
	private Text txtMarca;
	private Text txtPreco;
	private Text txtQt;
	private Text txtCod;
	private Table table;
	private Text txtResultado;
	private TableItem tableItem;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Lojinha window = new Lojinha();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 * @throws AxisFault 
	 */
	public void open() throws AxisFault {
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
	protected void createContents() throws AxisFault {
		EstoqueRepository rep = new EstoqueRepository();
		
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND)	);
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblNome = new Label(shell, SWT.NONE);
		lblNome.setBounds(10, 43, 36, 15);
		lblNome.setText("Nome:");
		
		Label lblMarca = new Label(shell, SWT.NONE);
		lblMarca.setBounds(10, 64, 36, 15);
		lblMarca.setText("Marca:");
		
		Label lblPreo = new Label(shell, SWT.NONE);
		lblPreo.setBounds(10, 85, 36, 15);
		lblPreo.setText("Pre\u00E7o:");
		
		Label lblQuantidade = new Label(shell, SWT.NONE);
		lblQuantidade.setBounds(10, 106, 36, 15);
		lblQuantidade.setText("Quant:");
		
		txtNome = new Text(shell, SWT.BORDER);
		txtNome.setBounds(51, 40, 76, 21);
		
		txtMarca = new Text(shell, SWT.BORDER);
		txtMarca.setBounds(51, 61, 76, 21);
		
		txtPreco = new Text(shell, SWT.BORDER);
		txtPreco.setBounds(51, 82, 76, 21);
		
		txtQt = new Text(shell, SWT.BORDER);
		txtQt.setBounds(51, 103, 76, 21);
		
		Button btnCadastrar = new Button(shell, SWT.NONE);
		btnCadastrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Clique do botão
				Produto p = new Produto();
				try {
					p.setCodigo(rep.nextCod());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				p.setNome(txtNome.getText());
				p.setMarca(txtMarca.getText());
				p.setPreco(Double.parseDouble(txtPreco.getText()));
				p.setQtd(Integer.parseInt(txtQt.getText()));
				//float media = nac*0.2f + am*0.3f + ps*0.5f; 
				try {
					rep.cadastrarProd(p); 
					txtResultado.setText("Show");
				} catch (Exception ex) {
					txtResultado.setText("Erro");
				}
			}
		});
		btnCadastrar.setBounds(52, 127, 75, 25);
		btnCadastrar.setText("Cadastrar");
		
		Label lblCodigo = new Label(shell, SWT.NONE);
		lblCodigo.setBounds(184, 43, 42, 15);
		lblCodigo.setText("Codigo:");
		
		txtCod = new Text(shell, SWT.BORDER);
		txtCod.setBounds(230, 40, 76, 21);
		
		
		
		Button btnConsultar = new Button(shell, SWT.NONE);
		btnConsultar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Clique do botão
				table.clearAll();
				table.removeAll();
				int codigo = Integer.parseInt(txtCod.getText());
				//float media = nac*0.2f + am*0.3f + ps*0.5f; 
				tableItem = new TableItem(table, SWT.NONE);
				try {
					Produto p = rep.consultarProd(codigo); 
					String[] resultado = {String.valueOf(p.getCodigo()), p.getNome(), String.valueOf(p.getQtd()), String.valueOf(p.getPreco())}; 
					tableItem.setText(resultado);
				} catch (Exception ex) {
					table.clearAll();
					table.removeAll();
					tableItem = new TableItem(table, SWT.NONE);
					tableItem.setText("Erro");
				}
			}
		});
		btnConsultar.setBounds(230, 64, 75, 25);
		btnConsultar.setText("Consultar");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(184, 106, 240, 88);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnCodigo = new TableColumn(table, SWT.NONE);
		tblclmnCodigo.setWidth(55);
		tblclmnCodigo.setText("Codigo");
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(81);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setText("Qtd");
		tblclmnNewColumn.setWidth(46);
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(54);
		tblclmnNewColumn_1.setText("Pre\u00E7o");
		
		txtResultado = new Text(shell, SWT.BORDER);
		txtResultado.setEditable(false);
		txtResultado.setBounds(51, 158, 76, 21);
		
		Button btnConsultarTudo = new Button(shell, SWT.NONE);
		btnConsultarTudo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				table.clearAll();
				table.removeAll();
				try {
					List<Produto> produto = rep.listarProd(); 
					for (Produto p : produto) {
						tableItem = new TableItem(table, SWT.NONE);
						String[] resultado = {String.valueOf(p.getCodigo()), p.getNome(), String.valueOf(p.getQtd()), String.valueOf(p.getPreco())}; 
						tableItem.setText(resultado);
					}
					
				} catch (Exception ex) {
					table.clearAll();
					table.removeAll();
					tableItem = new TableItem(table, SWT.NONE);
					tableItem.setText("Erro");
				}
				
			}
		});
		btnConsultarTudo.setBounds(311, 64, 94, 25);
		btnConsultarTudo.setText("Consultar Tudo");
		
		Button btnLimparTabela = new Button(shell, SWT.NONE);
		btnLimparTabela.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				table.clearAll();
				table.removeAll();
			}
		});
		
		btnLimparTabela.setBounds(184, 200, 86, 25);
		btnLimparTabela.setText("Limpar Tabela");
		
		
		

	}
}
