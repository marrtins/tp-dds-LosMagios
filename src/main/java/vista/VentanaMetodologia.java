package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;

public class VentanaMetodologia extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMetodologia frame = new VentanaMetodologia();
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
	public VentanaMetodologia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Crear Metodolog\u00EDa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaCrearMetodologia ventCrearMetodologia = new VentanaCrearMetodologia();
				ventCrearMetodologia.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(40, 80, 154, 62);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Aplicar Metodología");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaAplicarMetodologia ventAplicarMetodologia = new VentanaAplicarMetodologia();
				ventAplicarMetodologia.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(250, 80, 154, 62);
		contentPane.add(btnNewButton_1);
		
		JTextPane txtpnMetodologa = new JTextPane();
		txtpnMetodologa.setFont(new Font("Calibri", Font.BOLD, 14));
		txtpnMetodologa.setText("Metodolog\u00EDa");
		txtpnMetodologa.setBackground(Color.BLUE);
		txtpnMetodologa.setForeground(Color.WHITE);
		txtpnMetodologa.setBounds(172, 0, 82, 29);
		contentPane.add(txtpnMetodologa);
		
		JButton btnNewButton_2 = new JButton("Atrás");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal ventPpal = new VentanaPrincipal();
				ventPpal.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(345, 239, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
