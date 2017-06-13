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
import java.awt.Font;
import javax.swing.JLabel;

public class VentanaCuenta extends JFrame {

	private JPanel contentPane;
	private JTextField txtPorFavorSeleccione;
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	private String ruta;
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
		btnCrearCuenta.setBounds(51, 94, 149, 46);
		contentPane.add(btnCrearCuenta);
		
		JButton btnConsultarCuenta = new JButton("Consultar Valor de Cuenta");
		btnConsultarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaConsultarValorDeCuenta ventConsultValorCuenta = new VentanaConsultarValorDeCuenta();
				ventConsultValorCuenta.setVisible(true);
				
				dispose();
			}
		});
		btnConsultarCuenta.setBounds(210, 94, 166, 46);
		contentPane.add(btnConsultarCuenta);
		
		txtPorFavorSeleccione = new JTextField();
		txtPorFavorSeleccione.setFont(new Font("Calibri", Font.BOLD, 14));
		txtPorFavorSeleccione.setForeground(Color.WHITE);
		txtPorFavorSeleccione.setBackground(Color.BLUE);
		txtPorFavorSeleccione.setText("Por favor seleccione una opci\u00F3n:");
		txtPorFavorSeleccione.setBounds(0, 0, 200, 29);
		contentPane.add(txtPorFavorSeleccione);
		txtPorFavorSeleccione.setColumns(10);
		
		
		JButton btnAtras = new JButton("Atr\u00E1s");
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
