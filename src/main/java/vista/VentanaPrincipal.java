package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 321);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnSssss = new JTextPane();
		txtpnSssss.setFont(new Font("SimSun", Font.BOLD, 20));
		txtpnSssss.setToolTipText("");
		txtpnSssss.setForeground(Color.WHITE);
		txtpnSssss.setBackground(Color.BLUE);
		txtpnSssss.setText("Bienvenido a \u00BFD\u00F3nde Invierto?");
		txtpnSssss.setBounds(52, 0, 335, 37);
		contentPane.add(txtpnSssss);
		
		JButton btnCargarCuentaEmpresa = new JButton("Cuenta");
		btnCargarCuentaEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCuenta ventCuenta = new VentanaCuenta();
				ventCuenta.setVisible(true);
				dispose();
			}
		});
		btnCargarCuentaEmpresa.setBounds(23, 82, 180, 40);
		contentPane.add(btnCargarCuentaEmpresa);
		
		VentanaIndicador ventIndicador = new VentanaIndicador();
		
		JButton btnIndicador = new JButton("Indicador");
		btnIndicador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventIndicador.setVisible(true);
				dispose();
			}
		});
		btnIndicador.setBounds(213, 82, 180, 40);
		contentPane.add(btnIndicador);
		
		
		JButton btnMetodologa = new JButton("Metodolog\u00EDa");
		btnMetodologa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMetodologia ventMetodologia = new VentanaMetodologia();
				ventMetodologia.setVisible(true);
				dispose();
			}
		});
		btnMetodologa.setBounds(23, 143, 180, 40);
		contentPane.add(btnMetodologa);
		
		JButton btnVisualizargrficoComparativo = new JButton("Visualizar Gr\u00E1fico Comparativo");
		btnVisualizargrficoComparativo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVisualizargrficoComparativo.setBounds(213, 143, 180, 40);
		contentPane.add(btnVisualizargrficoComparativo);
		
		JButton btnVerDatosDe = new JButton("Ver Datos de Empresas");
		btnVerDatosDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVerDatosDe.setBounds(125, 194, 180, 37);
		contentPane.add(btnVerDatosDe);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(335, 258, 89, 23);
		contentPane.add(btnSalir);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
