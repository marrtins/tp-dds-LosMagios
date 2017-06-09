package vista;
import javax.swing.JList;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import modelo.Cuenta;
import modelo.Empresa;
import modelo.Periodo;
import persistence.CustomListModelEmpresa;
import persistence.DAOJsonEmpresa;
import persistence.DataCollector;
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
import javax.swing.JTree;
import javax.swing.border.BevelBorder;

public class VentanaConsultarValorDeCuenta extends JFrame {

	private JPanel contentPane;
	private ArrayList<Cuenta> cuentas = new ArrayList<>();
	private ArrayList<Empresa> empresas = new ArrayList<>();
	private ArrayList< Periodo>periodos = new ArrayList<>();
	private RepositorioDeEmpresas repoEmpresas;	
	private Empresa empresaSeleccionada;
	private Periodo periodoSeleccionado;
	DefaultMutableTreeNode abuelo;
	DefaultTreeModel modelo;
	int contadorGlobal = 0;
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
				
			
		
		DataCollector persistence = new DataCollector();
		empresas = persistence.cargarEmpresas();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		DefaultMutableTreeNode abuelo = new DefaultMutableTreeNode("Períodos");
		DefaultTreeModel modelo = new DefaultTreeModel(abuelo);
	
		
	

		JLabel lblEmpresas = new JLabel("Empresas");
		lblEmpresas.setBounds(36, 24, 116, 14);
		contentPane.add(lblEmpresas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setToolTipText("");
		scrollPane.setBounds(188, 39, 384, 180);
		contentPane.add(scrollPane);
		
		
		JTree tree = new JTree(modelo);
		scrollPane.setViewportView(tree);
		
		
		JLabel lblPeriodo = new JLabel("");
		lblPeriodo.setBounds(392, 199, 180, 14);
		contentPane.add(lblPeriodo);
			
		scrollPane.getVerticalScrollBar();
		list_modelEmpresa.setEmpresas(empresas);;
		
		JLabel lblValor = new JLabel("");
		lblValor.setBounds(393, 169, 180, 14);
		contentPane.add(lblValor);
		
		JLabel lblNombre = new JLabel("");
		lblNombre.setBounds(393, 130, 46, 14);
		contentPane.add(lblNombre);
		
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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(36, 39, 116, 180);
		contentPane.add(scrollPane_1);
		
		
		
		JList lstEmpresas = new JList();
		scrollPane_1.setViewportView(lstEmpresas);
		lstEmpresas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int indice = lstEmpresas.getSelectedIndex();
				Empresa empresaSeleccionada = empresas.get(indice);
				limpiarArbol();
				periodos = empresaSeleccionada.getPeriodos();
				periodos.forEach(unPeriodo->this.agregarDataAlArbol(unPeriodo));
				
							
				
				
			}

			private void limpiarArbol() {
				DefaultMutableTreeNode root = (DefaultMutableTreeNode) modelo.getRoot();
		        root.removeAllChildren();
		        modelo.reload();
		       
				
			}

			private void agregarDataAlArbol(Periodo unPeriodo) {
				
				DefaultMutableTreeNode padre2 = new DefaultMutableTreeNode(Integer.toString(unPeriodo.getAnio()));
				modelo.insertNodeInto(padre2,abuelo,0);
				cuentas = unPeriodo.getCuentas();
				cuentas.forEach(unaCuenta->modelo.insertNodeInto(new DefaultMutableTreeNode(unaCuenta.getNombreCuenta() + " Valor: "+unaCuenta.getValorCuenta()),padre2,padre2.getChildCount()));
				
				
			}

			private void agregarAlArbol(String string, String nombreCuenta) {
			
			
			}
		});
		
		lstEmpresas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstEmpresas.setModel(list_modelEmpresa);
		
		
		
		
		
		 
		
		
	
		
		
	}
	public void agregarPeriodoAlArbol(Periodo unPeriodo){
		
		DefaultMutableTreeNode padre2 = new DefaultMutableTreeNode(Integer.toString(unPeriodo.getAnio()));
		modelo.insertNodeInto(padre2,abuelo,0);
		
		
	
		
	}
}