package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bddCuentas.CustomListModelCuenta;
import bddCuentas.DAOCuenta;
import bddCuentas.DAOJsonCuenta;
import bddCuentas.RepositorioDeCuentas;
import bddEmpresa.CustomListModelEmpresa;
import bddEmpresa.DAOJsonEmpresa;
import bddEmpresa.RepositorioDeEmpresas;
import bddPeriodos.CustomListModelPeriodo;
import bddPeriodos.DAOJsonPeriodo;
import bddPeriodos.RepositorioDePeriodos;
import clases.Cuenta;
import clases.Empresa;
import clases.Periodo;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

public class VentanaCrearCuenta extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtValor;

	private ArrayList<Cuenta> cuentas = new ArrayList<>();
	private RepositorioDeCuentas repoCuentas;	
	private DAOJsonCuenta daoc;
	
	private ArrayList<Empresa> empresas = new ArrayList<>();
	private RepositorioDeEmpresas repoEmpresas;	
	private DAOJsonEmpresa daoe;
	
	private ArrayList<Periodo> periodos = new ArrayList<>();
	private RepositorioDePeriodos repoPeriodos;	
	private DAOJsonPeriodo daop;
	
	
	
	CustomListModelCuenta list_model = new CustomListModelCuenta();
	CustomListModelEmpresa list_model2 = new CustomListModelEmpresa();
	CustomListModelPeriodo list_model3 = new CustomListModelPeriodo();
	
	/* Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearCuenta frame = new VentanaCrearCuenta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public void init() throws IOException{
		
	}
	public VentanaCrearCuenta() throws IOException  {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList lstEmpresas = new JList();
		lstEmpresas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstEmpresas.setBounds(34, 24, 129, 150);
		getContentPane().add(lstEmpresas);
		
		DAOJsonEmpresa daoe = new DAOJsonEmpresa();
		daoe.setFilePath("C:\\Users\\martin\\Git\\3-LosMagios\\bd\\empresas.json");
		this.repoEmpresas = new RepositorioDeEmpresas(daoe);
		empresas = repoEmpresas.getAllEmpresas();
		list_model2.setEmpresas(empresas);
		lstEmpresas.setModel(list_model2);

		
		
		
		JList lstPeriodo = new JList();
		lstPeriodo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstPeriodo.setBounds(173, 24, 66, 150);
		getContentPane().add(lstPeriodo);
		
		
		DAOJsonPeriodo daop = new DAOJsonPeriodo();
		daop.setFilePath("C:\\Users\\martin\\Git\\3-LosMagios\\bd\\periodos.json");
		this.repoPeriodos = new RepositorioDePeriodos(daop);
		periodos = repoPeriodos.getAllPeriodos();
		list_model3.setPeriodos(periodos);
		lstPeriodo.setModel(list_model3);

		
		
		
		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setBounds(34, 11, 129, 14);
		getContentPane().add(lblEmpresa);
		
		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setBounds(173, 11, 46, 14);
		getContentPane().add(lblPeriodo);
		
		
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(34, 188, 46, 14);
		getContentPane().add(lblNombre);
		
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(34, 219, 46, 14);
		getContentPane().add(lblValor);
		
		JButton btnOtraEmpresa = new JButton("Otra Empresa");
		btnOtraEmpresa.setBounds(288, 60, 138, 23);
		getContentPane().add(btnOtraEmpresa);
		
		JButton btnOtroPeriodo = new JButton("Otro Periodo");
		btnOtroPeriodo.setBounds(288, 110, 138, 23);
		getContentPane().add(btnOtroPeriodo);
		
		JButton btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			int id = cuentas.size() + 1;
			int valor = Integer.parseInt(txtValor.getText());
			String nombre = txtNombre.getText();
			Object empresaAsociada = lstEmpresas.getSelectedValue();
			Object periodoAsociado = lstPeriodo.getSelectedValue();
			Cuenta nuevaCuenta = new Cuenta(id,nombre,valor);
			cuentas.add(nuevaCuenta);
			Cuenta otra = new Cuenta(10,"asd",100);
			cuentas.add(otra);
			}
		});
		btnCrearCuenta.setBounds(288, 198, 138, 23);
		getContentPane().add(btnCrearCuenta);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(90, 185, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		
		
		txtValor = new JTextField();
		txtValor.setBounds(90, 216, 86, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		
		
	}
}
