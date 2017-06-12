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
		
		JButton btnNewButton = new JButton("Crear indicador");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaCrearIndicador ventCrearIndicador = new VentanaCrearIndicador();
				ventCrearIndicador.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(73, 97, 127, 65);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Aplicar Indicadores");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAplicarI ventAplicar = new VentanaAplicarI();
				ventAplicar.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(254, 97, 138, 90);
		contentPane.add(btnNewButton_1);
	}

}
