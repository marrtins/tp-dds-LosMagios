package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cuenta;
import modelo.Empresa;
import modelo.Periodo;
import persistence.DAOJsonEmpresa;
import persistence.RepositorioDeEmpresas;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
	private ArrayList<Empresa> empresas = new ArrayList<>();
	private RepositorioDeEmpresas repoEmpresas;	
	private DAOJsonEmpresa dao;
	
	 
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

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JComboBox cboEmpresa = new JComboBox();
		cboEmpresa.setBounds(138, 118, 153, 20);
		contentPane.add(cboEmpresa);
		cboEmpresa.addItem("Empresa...");
		
		//agrego todas las empresas:
		for(int i=0;i<empresas.size();i++){
			String nombreEmpresa = empresas.get(i).getNombreEmpresa();
			cboEmpresa.addItem(nombreEmpresa);
		}
		
		
		
		
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
		
		JLabel label = new JLabel("");
		label.setBounds(239, 216, 46, 14);
		contentPane.add(label);

		JButton btnCrear = new JButton("CREAR");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(cboEmpresa.getSelectedItem() == ("Empresa...")){
					JOptionPane.showMessageDialog(null, "Seleccione una empresa");
				}
				else {

					int indiceSeleccionado = cboEmpresa.getSelectedIndex();
					
					try {
						empresas =repoEmpresas.getAllEmpresas();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					Empresa empresaSeleccionada = empresas.get(indiceSeleccionado - 1);
					Cuenta nuevaCuenta = new Cuenta();

					//TODO:Cambiar
					int tamanioCuentas = 0;
					for(int i=0;i<empresas.size();i++){
						tamanioCuentas = empresas.get(i).getCuentas().size() + tamanioCuentas;
					}

					int nuevoId= tamanioCuentas+1;
					String nuevoNombre = txtNombre.getText();
					int nuevoValor = Integer.parseInt(txtValor.getText());
					int nuevoPeriodo = Integer.parseInt(txtPeriodo.getText());
					nuevaCuenta.setear(nuevoId, nuevoNombre, nuevoValor, nuevoPeriodo);
					//nuevaCuenta.setEmpresaAsociada(empresaSeleccionada);
					//nuevaCuenta.setear(100, "!cuetna", 200, 1);
					empresaSeleccionada.agregarCuenta(nuevaCuenta);

					try {

						repoEmpresas.update(empresaSeleccionada);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				
				/*
				if(cboEmpresa.getSelectedItem() == ("Otra Empresa...")){
					String nombreEmpresa = JOptionPane.showInputDialog("Escribe nombre de la empresa");
					cboEmpresa.addItem(nombreEmpresa);
					int nuevoId = empresas.size() + 1;
					int ultimoItem = cboEmpresa.getItemCount() - 1;
					//cboEmpresa.remove(ultimoItem);
					Empresa nuevaEmpresa = new Empresa(nuevoId, nombreEmpresa);
					cboEmpresa.addItem(nombreEmpresa);
					//TODO:CAMBIAR
					cboEmpresa.addItem("Otra Empresa...");
					JOptionPane.showMessageDialog(null, "Empresa agregada correctamente");
					
				}
				else {
					Cuenta nuevaCuenta = new Cuenta();
					Empresa empresaAsociada = empresas.get(cboEmpresa.getSelectedIndex()); 
					nuevaCuenta.setEmpresaAsociada(empresaAsociada);
					//Cant de cuentas de cada empresa (cant total de cuentas)
					//TODO REEMPLAZAR FOR
					int tam=0;
					for(int i = 0;i<empresas.size();i++){
						Empresa empresa =empresas.get(i);
						tam = tam +  empresa.getCuentas().size();
					}
					
					int nuevoId = tam + 1;
					nuevaCuenta.setIdCuenta(nuevoId);
					nuevaCuenta.setNombreCuenta(txtNombre.getText());
					nuevaCuenta.setPeriodoDeCuenta(Integer.parseInt(txtPeriodo.getText()));
					nuevaCuenta.setValorCuenta(Integer.parseInt(txtValor.getText()));
					empresaAsociada.agregarCuenta(nuevaCuenta);
					try {
						repoEmpresas.update(empresaAsociada);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 
				}
*/
							
				/*nuevaCuenta.setEmpresaAsociada(empresaAsociada);
				nuevaCuenta.setIdCuenta(10);
				nuevaCuenta.setNombreCuenta(txtNombreCuenta.getText());
				nuevaCuenta.setPeriodoDeCuenta(2010);
				int nuevoValor = txtValor.getText().toString();
				nuevaCuenta.setValorCuenta();
				*/
				
			}
		});
		btnCrear.setBounds(310, 117, 89, 23);
		contentPane.add(btnCrear);
		
		JButton btnOtraEmpresa = new JButton("Otra Empresa");
		btnOtraEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreEmpresa = JOptionPane.showInputDialog("Escribe nombre de la empresa");
				cboEmpresa.addItem(nombreEmpresa);
				int nuevoId = empresas.size() + 1;
				Empresa nuevaEmpresa = new Empresa(nuevoId, nombreEmpresa);
				JOptionPane.showMessageDialog(null, "Empresa agregada correctamente");
				try {
					repoEmpresas.add(nuevaEmpresa);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		btnOtraEmpresa.setBounds(165, 159, 108, 23);
		contentPane.add(btnOtraEmpresa);

		
		
		
		
		
		
	}
}
