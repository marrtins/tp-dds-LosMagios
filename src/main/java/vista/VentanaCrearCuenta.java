package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cuenta;
import clases.Empresa;
import clases.Periodo;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class VentanaCrearCuenta extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreCuenta;
	private JTextField txtValor;
	private int valorCuenta;
	String nombreCuenta;
	Periodo periodoPrueba = new Periodo(2013);
	Empresa empresaPrueba = new Empresa("empresa prueba", periodoPrueba);
	/**
	 * Launch the application.
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
	public void crearPeriodo(Periodo unPeriodo){
		String anioNuevoPeriodo = String.valueOf(unPeriodo.getAnio());
		JRadioButton rdbtnNewRadioButton = new JRadioButton(anioNuevoPeriodo);
	}

	/**
	 * Create the frame.
	 */
	public VentanaCrearCuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cboEmpresas = new JComboBox();
		cboEmpresas.setBounds(217, 373, 202, 20);
		cboEmpresas.setModel(new DefaultComboBoxModel(new String[] {"Empresa"}));
		cboEmpresas.addItem(empresaPrueba.getNombreEmpresa());
		cboEmpresas.setToolTipText("");
		contentPane.add(cboEmpresas);
		
		txtNombreCuenta = new JTextField();
		txtNombreCuenta.setBounds(46, 316, 101, 20);
		txtNombreCuenta.setText("Nombre Cuenta");
		contentPane.add(txtNombreCuenta);
		txtNombreCuenta.setColumns(10);
		
		JComboBox cboPeriodo = new JComboBox();
		cboPeriodo.setBounds(217, 326, 202, 20);
		cboPeriodo.setModel(new DefaultComboBoxModel(new String[] {"Periodo"}));
		cboPeriodo.addItem(periodoPrueba.getAnio());
		contentPane.add(cboPeriodo);
		
		txtValor = new JTextField();
		txtValor.setBounds(46, 373, 101, 20);
		txtValor.setText("Valor");
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnCrearCuenta = new JButton("Crear Cuenta");
		btnCrearCuenta.setBounds(450, 372, 129, 23);
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombreCuenta = txtNombreCuenta.getText();
                int v1=Integer.parseInt(txtValor.getText());
                valorCuenta = v1;
               // empresaAsociada = 
                
                //Cuenta nuevaCuenta = new Cuenta(cboEmpresas, txtValor, cboPeriodo, txtNombreCuenta);
			}
		});
		contentPane.add(btnCrearCuenta);
		
		JPanel panel = new JPanel();
		panel.setBounds(46, 41, 170, 214);
		contentPane.add(panel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio buttonaaa");
		panel.add(rdbtnNewRadioButton);
		
		JButton btnCrearNuevoPeriodo = new JButton("Crear nuevo Periodo");
		btnCrearNuevoPeriodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(btnCrearNuevoPeriodo);
	}
}
