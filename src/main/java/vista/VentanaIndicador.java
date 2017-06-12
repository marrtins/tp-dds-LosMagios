package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Empresa;
import modelo.Indicador;
import modelo.Periodo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;

public class VentanaIndicador extends JFrame {

	private JPanel contentPane;
	private String ruta;
	
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaIndicador frame = new VentanaIndicador();
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
	public VentanaIndicador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCargarIndicador = new JButton("Crear Indicador");
		btnCargarIndicador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaCrearIndicador ventInd = new VentanaCrearIndicador();
				ventInd.setVisible(true);
				dispose();
				
			}
		});
		btnCargarIndicador.setBounds(40, 80, 154, 62);
		contentPane.add(btnCargarIndicador);
		
		JButton btnNewButton = new JButton("Aplicar Indicadores");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaAplicarI ventAplicar = new VentanaAplicarI();
				ventAplicar.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(250, 80, 154, 62);
		contentPane.add(btnNewButton);
		
		JTextPane txtpnIndicador = new JTextPane();
		txtpnIndicador.setFont(new Font("Calibri", Font.BOLD, 14));
		txtpnIndicador.setText("Indicador");
		txtpnIndicador.setBackground(Color.BLUE);
		txtpnIndicador.setForeground(Color.WHITE);
		txtpnIndicador.setBounds(190, 0, 63, 29);
		contentPane.add(txtpnIndicador);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal ventPpal = new VentanaPrincipal();
				ventPpal.setVisible(true);
				dispose();
			}
		});
		btnAtrs.setBounds(345, 239, 89, 23);
		contentPane.add(btnAtrs);
		

	}

}
