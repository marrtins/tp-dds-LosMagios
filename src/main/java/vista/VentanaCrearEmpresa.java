package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import javax.swing.JTextPane;

import modelo.Empresa;
import persistence.DAOJsonEmpresa;
import persistence.RepositorioDeEmpresas;

import javax.swing.JList;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Button;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Choice;
public class VentanaCrearEmpresa {

	private JFrame frame;
	private JTextField txtNombre;
	private JButton button;
	private JButton btnAtras;
	private ArrayList<Empresa> empresas = new ArrayList<>();
	private RepositorioDeEmpresas repoEmpresas;	
	private DAOJsonEmpresa dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearEmpresa window = new VentanaCrearEmpresa();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaCrearEmpresa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Agrego todas las empresas de la base de datos:
				dao = new DAOJsonEmpresa();
				//TODO: Cambiar esto
				dao.setFilePath("C:\\Users\\martin\\Git\\3-LosMagios\\bd\\empresas.json");
				this.repoEmpresas = new RepositorioDeEmpresas(dao);
				try {
					empresas = repoEmpresas.getAllEmpresas();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();;
				}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 316, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(94, 63, 160, 26);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(38, 69, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nuevoId = empresas.size() + 1;
				String nuevoNombre = txtNombre.getText();
				Empresa nuevaEmpresa = new Empresa(nuevoId,nuevoNombre);
				try {
					repoEmpresas.add(nuevaEmpresa);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnCrear.setBounds(119, 115, 89, 23);
		frame.getContentPane().add(btnCrear);
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCuenta ventCuenta = new VentanaCuenta();
				ventCuenta.setVisible(true);
				//TODO: Arreglar dispose
				//dispose();
			}
		});
		btnAtras.setBounds(211, 159, 89, 23);
		frame.getContentPane().add(btnAtras);
		
		
		
	}

	

}
