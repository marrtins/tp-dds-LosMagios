package vista;
import javax.swing.JList;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cuenta;
import modelo.Empresa;
import persistence.CustomListModelEmpresa;
import persistence.DAOJsonEmpresa;
import persistence.RepositorioDeEmpresas;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaConsultarValorDeCuenta extends JFrame {

	private JPanel contentPane;
	private ArrayList<Cuenta> cuentas = new ArrayList<>();
	private ArrayList<Empresa> empresas = new ArrayList<>();
	private RepositorioDeEmpresas repoEmpresas;	
	CustomListModelEmpresa list_modelEmpresa = new CustomListModelEmpresa();
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
		
		
		DAOJsonEmpresa dao = new DAOJsonEmpresa();
		dao.setFilePath("C:\\Users\\martin\\Git\\3-LosMagios\\bd\\empresas.json");
		this.repoEmpresas = new RepositorioDeEmpresas(dao);
		try {
			empresas = repoEmpresas.getAllEmpresas();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cboCuentas = new JComboBox();
		cboCuentas.setBounds(177, 37, 160, 20);
		contentPane.add(cboCuentas);
		
		JList lstEmpresas = new JList();
		lstEmpresas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cboCuentas.removeAllItems();
				int indice = lstEmpresas.getSelectedIndex();
				Empresa empresaSeleccionada = empresas.get(indice);
				cuentas = empresaSeleccionada.getCuentas();
				for(int i =0;i<cuentas.size();i++){
					cboCuentas.addItem(cuentas.get(i).getNombreCuenta() + cuentas.get(i).getPeriodoDeCuenta());
				}
				
				
			}
		});
		lstEmpresas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstEmpresas.setBounds(36, 39, 116, 180);
		contentPane.add(lstEmpresas);
		list_modelEmpresa.setEmpresas(empresas);
		lstEmpresas.setModel(list_modelEmpresa);;
		
		
		JLabel lblNombre = new JLabel("");
		lblNombre.setBounds(291, 174, 242, 14);
		contentPane.add(lblNombre);
		
		JLabel lblPeriodo = new JLabel("");
		lblPeriodo.setBounds(291, 199, 281, 14);
		contentPane.add(lblPeriodo);
		
		JLabel lblValor = new JLabel("");
		lblValor.setBounds(291, 224, 303, 14);
		contentPane.add(lblValor);
		
		JButton btnNewButton = new JButton("Ver resultados");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indice  = cboCuentas.getSelectedIndex();
				Cuenta cuentaSeleccionada = cuentas.get(indice);
				
				lblNombre.setText("Nombre: " +cuentaSeleccionada.getNombreCuenta());
				
				lblPeriodo.setText("Periodo: "+Integer.toString(cuentaSeleccionada.getPeriodoDeCuenta()));
				lblValor.setText("Valor: "+Integer.toString(cuentaSeleccionada.getValorCuenta()));
			}
		});
		btnNewButton.setBounds(416, 79, 116, 23);
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
		btnAtras.setBounds(488, 241, 116, 23);
		contentPane.add(btnAtras);
		
	
		
		
	}
}