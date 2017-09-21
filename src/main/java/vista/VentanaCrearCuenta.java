package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Cuenta;
import entities.Empresa;
import entities.Periodo;
import model.RepositorioDeEmpresas;
import persistence.DAOJsonEmpresa;
import persistence.DataCollector;

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
	private String ruta;
	
	 
	public String getRuta() {
		return ruta;
	}


	public void setRuta(String ruta) {
		this.ruta = ruta;
	}


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
		
		DataCollector persistence = new DataCollector();
		try {
			empresas=persistence.cargarEmpresas();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		empresas.forEach(unaEmpresa->cboEmpresa.addItem(unaEmpresa.getNombreEmpresa()));
		
		
		
		
		
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
				if(txtPeriodo.getText().isEmpty() || txtNombre.getText().isEmpty() || txtValor.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Rellene todos los campos.");
				}
				else
				{
					int indiceSeleccionado = cboEmpresa.getSelectedIndex();			
					Empresa empresaSeleccionada = empresas.get(indiceSeleccionado - 1);
					Cuenta nuevaCuenta = new Cuenta();
					String nuevoNombre = txtNombre.getText();
					int unAnio = Integer.parseInt(txtPeriodo.getText());
					Periodo unPeriodo = empresaSeleccionada.getPeriodoOrCreate(unAnio);
					int nuevoValor = Integer.parseInt(txtValor.getText());
					nuevaCuenta.setear(nuevoNombre.toUpperCase(), nuevoValor);
					empresaSeleccionada.agregarCuentaEnPeriodo(nuevaCuenta, unPeriodo);
					try {
						persistence.updateEmpresa(empresaSeleccionada);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}
					
			}
		});
		btnCrear.setBounds(310, 117, 89, 23);
		contentPane.add(btnCrear);
		
		JButton btnOtraEmpresa = new JButton("Otra Empresa");
		btnOtraEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreEmpresa = JOptionPane.showInputDialog("Escribe nombre de la empresa");
				cboEmpresa.addItem(nombreEmpresa.toUpperCase());
				Empresa nuevaEmpresa = new Empresa(nombreEmpresa.toUpperCase());
				try {
					persistence.agregarEmpresa(nuevaEmpresa);
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
