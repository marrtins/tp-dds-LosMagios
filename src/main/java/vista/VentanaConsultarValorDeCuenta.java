package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bddCuentas.CustomListModelCuenta;
import bddCuentas.DAOJsonCuenta;
import bddCuentas.RepositorioDeCuentas;
import bddEmpresa.DAOJsonEmpresa;
import bddEmpresa.RepositorioDeEmpresas;
import bddPeriodos.DAOJsonPeriodo;
import bddPeriodos.RepositorioDePeriodos;
import clases.Cuenta;
import clases.Empresa;
import clases.Periodo;

import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class VentanaConsultarValorDeCuenta extends JFrame {

	private JPanel contentPane;
	private ArrayList<Cuenta> cuentas = new ArrayList<>();
	private RepositorioDeCuentas repoCuentas;	
	private DAOJsonCuenta daoc;
	
	private ArrayList<Empresa> empresas = new ArrayList<>();
	private RepositorioDeEmpresas repoEmpresas;	
	private DAOJsonEmpresa daoe;
	
	private ArrayList<Periodo> periodos = new ArrayList<>();
	private RepositorioDePeriodos repoPeriodos;	
	private DAOJsonPeriodo daop;
	CustomListModelCuenta list_modelCuenta = new CustomListModelCuenta();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConsultarValorDeCuenta frame = new VentanaConsultarValorDeCuenta();
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
	public VentanaConsultarValorDeCuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList lstCuenta = new JList();
		lstCuenta.setBounds(36, 39, 311, 180);
		contentPane.add(lstCuenta);
		DAOJsonCuenta daoc = new DAOJsonCuenta();
		daoc.setFilePath("C:\\Users\\martin\\Git\\3-LosMagios\\bd\\cuentas.json");
		this.repoCuentas = new RepositorioDeCuentas(daoc);
		try {
			cuentas = repoCuentas.getAllCuentas();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list_modelCuenta.setCuentas(cuentas);
		lstCuenta.setModel(list_modelCuenta);
		
		JLabel lblNombre = new JLabel("New label");
		lblNombre.setBounds(357, 130, 220, 14);
		contentPane.add(lblNombre);
		lblNombre.setVisible(false);
		
		JLabel lblPeriodo = new JLabel("New label");
		lblPeriodo.setBounds(357, 155, 237, 14);
		contentPane.add(lblPeriodo);
		lblPeriodo.setVisible(false);
		
		JLabel lblEmpresa = new JLabel("New label");
		lblEmpresa.setBounds(357, 180, 203, 14);
		contentPane.add(lblEmpresa);
		lblEmpresa.setVisible(false);
		
		JLabel lblValor = new JLabel("New label");
		lblValor.setBounds(357, 205, 203, 14);
		contentPane.add(lblValor);
		lblValor.setVisible(false);
		
		
		
		
		JButton btnNewButton = new JButton("Ver resultados");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblEmpresa.setVisible(true);
				lblNombre.setVisible(true);
				lblPeriodo.setVisible(true);
				lblValor.setVisible(true);
				int indice = lstCuenta.getSelectedIndex();
				lblEmpresa.setText("Empresa: "+cuentas.get(indice).getEmpresaAsociada());

				lblNombre.setText("Nombre cuenta: "+cuentas.get(indice).getNombreCuenta());
				String periodo = Integer.toString(cuentas.get(indice).getPeriodoDeCuenta());
				lblPeriodo.setText("Período: "+periodo);
				String valor = Integer.toString(cuentas.get(indice).getValorCuenta());
				lblValor.setText("Valor: "+valor);
				
			}
		});
		btnNewButton.setBounds(478, 39, 116, 23);
		contentPane.add(btnNewButton);
		
		JTextPane txtpnConsultarValorDe = new JTextPane();
		txtpnConsultarValorDe.setFont(new Font("Calibri", Font.BOLD, 14));
		txtpnConsultarValorDe.setText("Consultar Valor de Cuenta");
		txtpnConsultarValorDe.setForeground(Color.WHITE);
		txtpnConsultarValorDe.setBackground(Color.BLUE);
		txtpnConsultarValorDe.setBounds(206, 0, 160, 28);
		contentPane.add(txtpnConsultarValorDe);
		
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCuenta ventCuenta = new VentanaCuenta();
				ventCuenta.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(478, 83, 116, 23);
		contentPane.add(btnAtras);
	}
}
