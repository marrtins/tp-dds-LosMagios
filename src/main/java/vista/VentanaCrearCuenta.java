package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bddCuentas.DAOCuenta;
import bddCuentas.DAOJsonCuenta;
import clases.Cuenta;
import clases.Empresa;
import clases.Periodo;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
	private JTextField txtValor;
	private int valorCuenta;
	String nombreCuenta;
	private JTextField textField;
	private JTextField textField_1;
	 
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

		JList lstEmpresas = new JList(cuentas);
		lstEmpresas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstEmpresas.setBounds(34, 24, 129, 150);
		getContentPane().add(lstEmpresas);*/
		
		
		JList lstPeriodo = new JList();
		lstPeriodo.setBounds(187, 63, 66, 157);
		getContentPane().add(lstPeriodo);
		
		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setFont(new Font("Calibri", Font.BOLD, 14));
		lblEmpresa.setBounds(22, 34, 129, 20);
		getContentPane().add(lblEmpresa);
		
		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setFont(new Font("Calibri", Font.BOLD, 14));
		lblPeriodo.setBounds(195, 40, 46, 14);
		getContentPane().add(lblPeriodo);
		
		textField = new JTextField();
		textField.setBounds(91, 154, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNombre.setBounds(22, 157, 59, 14);
		getContentPane().add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setBounds(91, 199, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Calibri", Font.BOLD, 14));
		lblValor.setBounds(22, 202, 46, 14);
		getContentPane().add(lblValor);
		
		JButton btnOtraEmpresa = new JButton("Otra Empresa");
		btnOtraEmpresa.setBounds(288, 60, 138, 23);
		getContentPane().add(btnOtraEmpresa);
		
		JButton btnOtroPeriodo = new JButton("Otro Periodo");
		btnOtroPeriodo.setBounds(288, 110, 138, 23);
		getContentPane().add(btnOtroPeriodo);
		
		JButton btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.setBounds(288, 198, 138, 23);
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
		
		
		
	}
}
