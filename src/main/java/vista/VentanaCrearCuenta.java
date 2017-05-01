package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bddCuentas.DAOCuenta;
import bddCuentas.DAOJsonCuenta;
import bddCuentas.RepositorioDeCuentas;
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
import java.awt.Font;
import java.awt.Color;

public class VentanaCrearCuenta extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreCuenta;
	private int valorCuenta;
	String nombreCuenta;
	private JTextField txtNombre;
	private JTextField txtValor;
	private JTextField txtPeriodo;
	private ArrayList<Cuenta> cuentas;
	private RepositorioDeCuentas repoCuentas;
	private JTextField txtEmpresa;
	 
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
	 */
	public VentanaCrearCuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/*agrego cuentas
		Cuenta cuenta = new Cuenta();
		cuentas = cuenta.leerCuentasDeJson();

		
		JList lstEmpresas = new JList();
		lstEmpresas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstEmpresas.setBounds(32, 63, 129, 134);
		getContentPane().add(lstEmpresas);
		*/
		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setFont(new Font("Calibri", Font.BOLD, 14));
		lblEmpresa.setBounds(138, 90, 66, 20);
		getContentPane().add(lblEmpresa);
		
		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setFont(new Font("Calibri", Font.BOLD, 14));
		lblPeriodo.setBounds(138, 40, 46, 14);
		getContentPane().add(lblPeriodo);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(42, 60, 86, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNombre.setBounds(42, 40, 59, 14);
		getContentPane().add(lblNombre);
		
		txtValor = new JTextField();
		txtValor.setBounds(42, 118, 86, 20);
		getContentPane().add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Calibri", Font.BOLD, 14));
		lblValor.setBounds(42, 93, 46, 14);
		getContentPane().add(lblValor);
		
		/*JButton btnOtraEmpresa = new JButton("Otra Empresa");
		btnOtraEmpresa.setBounds(42, 208, 110, 23);
		getContentPane().add(btnOtraEmpresa);
		*/
		JButton btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.addActionListener(new ActionListener() {
			private RepositorioDeCuentas repoCuentas;

			public void actionPerformed(ActionEvent arg0) {
				DAOJsonCuenta dao = new DAOJsonCuenta();
				dao.setFilePath("C:\\Users\\martin\\Git\\3-LosMagios\\bd\\cuentas.json");
				this.repoCuentas = new RepositorioDeCuentas(dao);
				try {
					cuentas = repoCuentas.getAllCuentas();
					String nombre = txtNombre.getText();
					int id = cuentas.size();
					int valor = Integer.getInteger(txtValor.getText());
					int periodo = Integer.getInteger(txtPeriodo.getText());
					String empresa =txtEmpresa.getText();
					Cuenta nuevaCuenta = new Cuenta(id, nombre, valor,periodo, empresa);
					repoCuentas.add(nuevaCuenta);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			

			
		});
		btnCrearCuenta.setBounds(311, 90, 138, 39);
		getContentPane().add(btnCrearCuenta);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCuenta ventCuenta = new VentanaCuenta();
				ventCuenta.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(395, 238, 89, 23);
		contentPane.add(btnAtras);
		
		JTextPane txtpnCrearCuenta = new JTextPane();
		txtpnCrearCuenta.setFont(new Font("Calibri", Font.BOLD, 14));
		txtpnCrearCuenta.setText("Crear Cuenta");
		txtpnCrearCuenta.setForeground(Color.WHITE);
		txtpnCrearCuenta.setBackground(Color.BLUE);
		txtpnCrearCuenta.setBounds(209, 0, 82, 28);
		contentPane.add(txtpnCrearCuenta);
		
		txtPeriodo = new JTextField();
		txtPeriodo.setBounds(138, 60, 86, 20);
		contentPane.add(txtPeriodo);
		txtPeriodo.setColumns(10);
		
		txtEmpresa = new JTextField();
		txtEmpresa.setBounds(138, 118, 86, 20);
		contentPane.add(txtEmpresa);
		txtEmpresa.setColumns(10);
		
		
		
	}
	public ArrayList<Cuenta> cargarCuentas() throws IOException{
		this.cargarRepositorioDeCuentas();
		cuentas = repoCuentas.getAllCuentas();
		return cuentas;
	}
	public void cargarRepositorioDeCuentas(){
		DAOJsonCuenta dao = new DAOJsonCuenta();
		dao.setFilePath("C:\\Users\\martin\\Git\\3-LosMagios\\bd\\cuentas.json");
		this.repoCuentas = new RepositorioDeCuentas(dao);
	}
	
}
