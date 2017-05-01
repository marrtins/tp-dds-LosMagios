package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Periodo;

import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;

public class VentanaCrearPeriodo extends JFrame {

	private JPanel contentPane;
	private JTextField txtAnio;
	private JButton btnAtras;
	private JTextPane txtpnCrearPerodo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearPeriodo frame = new VentanaCrearPeriodo();
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
	public VentanaCrearPeriodo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAnio = new JTextField();
		txtAnio.setText("A\u00F1o");
		txtAnio.setBounds(96, 122, 86, 20);
		contentPane.add(txtAnio);
		txtAnio.setColumns(10);
		
		JButton btnCrearPeriodo = new JButton("Crear ");
		btnCrearPeriodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int anio = Integer.parseInt(txtAnio.getText());
				Periodo nuevoPeriodo = new Periodo(anio);
				VentanaCrearCuenta ventanaCrearCuenta = new VentanaCrearCuenta();
				ventanaCrearCuenta.setVisible(true);
				//ventanaCrearCuenta.agregarPeriodo(nuevoPeriodo);
				//this.cerrarVentana();
			}
		});
		btnCrearPeriodo.setBounds(220, 122, 86, 20);
		contentPane.add(btnCrearPeriodo);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAtras.setBounds(335, 227, 89, 23);
		contentPane.add(btnAtras);
		
		txtpnCrearPerodo = new JTextPane();
		txtpnCrearPerodo.setFont(new Font("Calibri", Font.BOLD, 14));
		txtpnCrearPerodo.setText("Crear Per\u00EDodo");
		txtpnCrearPerodo.setBackground(Color.BLUE);
		txtpnCrearPerodo.setForeground(Color.WHITE);
		txtpnCrearPerodo.setBounds(164, 0, 89, 28);
		contentPane.add(txtpnCrearPerodo);
	}
}