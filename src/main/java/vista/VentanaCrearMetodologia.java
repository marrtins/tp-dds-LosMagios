package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCrearMetodologia extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearMetodologia frame = new VentanaCrearMetodologia();
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
	public VentanaCrearMetodologia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(157, 11, 135, 28);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnTaxativas = new JButton("Agregar Condicion Taxativa");
		btnTaxativas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaCrearCTaxativa ventCrearTaxativa = new VentanaCrearCTaxativa();
				ventCrearTaxativa.setVisible(true);
				dispose();
			}
		});
		btnTaxativas.setBounds(31, 280, 166, 49);
		contentPane.add(btnTaxativas);
		
		JButton btnNoTaxativa = new JButton("Agrega Condicion no taxativa");
		btnNoTaxativa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCrearCNoTaxativa ventCrearNoTaxativa = new VentanaCrearCNoTaxativa();
				ventCrearNoTaxativa.setVisible(true);
				dispose();
			}
		});
		btnNoTaxativa.setBounds(240, 280, 166, 49);
		contentPane.add(btnNoTaxativa);
		
		JButton btnC = new JButton("Crear Metodologia");
		btnC.setBounds(445, 149, 141, 59);
		contentPane.add(btnC);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 50, 166, 219);
		contentPane.add(scrollPane);
		
		JList lstT = new JList();
		scrollPane.setViewportView(lstT);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(240, 50, 166, 219);
		contentPane.add(scrollPane_1);
		
		JList lstNT = new JList();
		scrollPane_1.setViewportView(lstNT);
		
		JLabel lblNewLabel = new JLabel("Nombre Metodologia");
		lblNewLabel.setBounds(41, 18, 106, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Borrar Condicion Seleccionada");
		btnNewButton.setBounds(31, 341, 166, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Borrar Condicion Seleccionada");
		btnNewButton_1.setBounds(240, 340, 166, 23);
		contentPane.add(btnNewButton_1);
	}
}
