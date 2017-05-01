package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class VentanaCuenta extends JFrame {

	private JPanel contentPane;
	private JTextField txtPorFavorSeleccione;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCuenta frame = new VentanaCuenta();
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
	public VentanaCuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnCrearCuenta = new JButton("Crear Cuenta");
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrearCuenta ventCrearCuenta = new VentanaCrearCuenta();
				ventCrearCuenta.setVisible(true);
				dispose();
			}
		});
		btnCrearCuenta.setBounds(46, 74, 149, 46);
		contentPane.add(btnCrearCuenta);
		
		JButton btnConsultarCuenta = new JButton("Consultar valor de Cuentas");
		btnConsultarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaConsultarValorDeCuenta ventConsultValorCuenta = new VentanaConsultarValorDeCuenta();
				ventConsultValorCuenta.setVisible(true);
				dispose();
			}
		});
		btnConsultarCuenta.setBounds(205, 74, 166, 46);
		contentPane.add(btnConsultarCuenta);
		
		txtPorFavorSeleccione = new JTextField();
		txtPorFavorSeleccione.setForeground(Color.WHITE);
		txtPorFavorSeleccione.setBackground(Color.DARK_GRAY);
		txtPorFavorSeleccione.setText("Por favor seleccione una opci\u00F3n:");
		txtPorFavorSeleccione.setBounds(10, 21, 166, 29);
		contentPane.add(txtPorFavorSeleccione);
		txtPorFavorSeleccione.setColumns(10);
		
		JButton btnFiltrar = new JButton("Filtrar valores de Cuentas");
		btnFiltrar.setBounds(118, 144, 183, 46);
		contentPane.add(btnFiltrar);
		
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal ventPrincipal = new VentanaPrincipal();
				ventPrincipal.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(335, 227, 89, 23);
		contentPane.add(btnAtras);
	}
}
