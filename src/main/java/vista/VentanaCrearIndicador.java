package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import modelo.Indicador;

import persistence.DataCollector;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;


public class VentanaCrearIndicador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreIndicador;
	private ArrayList<Indicador> indicadores = new ArrayList<>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaCrearIndicador dialog = new VentanaCrearIndicador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaCrearIndicador() {
		
		
		
		DataCollector persistence = new DataCollector();
		try {
			indicadores = persistence.cargarIndicadores();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		
		setBounds(100, 100, 571, 362);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre del Indicador:");
			lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 14));
			lblNewLabel.setBounds(10, 53, 223, 14);
			contentPanel.add(lblNewLabel);
		}
		
		txtNombreIndicador = new JTextField();
		txtNombreIndicador.setBounds(243, 50, 234, 20);
		contentPanel.add(txtNombreIndicador);
		txtNombreIndicador.setColumns(10);
		
		JTextPane txtpnCargarIndicador = new JTextPane();
		txtpnCargarIndicador.setFont(new Font("Calibri", Font.BOLD, 14));
		txtpnCargarIndicador.setText("Crear Indicador");
		txtpnCargarIndicador.setForeground(Color.WHITE);
		txtpnCargarIndicador.setBackground(Color.BLUE);
		txtpnCargarIndicador.setBounds(222, 0, 97, 30);
		contentPanel.add(txtpnCargarIndicador);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 155, 535, 115);
		contentPanel.add(editorPane);

		JLabel lblEscribaAquEl = new JLabel("Escriba aqu\u00ED el indicador a crear (ingrese cuentas e indicadores entre llaves \"{ }\" y en may\u00FAsculas):");
		lblEscribaAquEl.setBounds(10, 130, 535, 14);
		contentPanel.add(lblEscribaAquEl);


		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Atr\u00E1s");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						VentanaIndicador ventanaIndicador = new VentanaIndicador();
						ventanaIndicador.setVisible(true);
						dispose();
					}
				});
				
						JButton btnOk = new JButton("OK");
						buttonPane.add(btnOk);
						btnOk.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								String formula = editorPane.getText();
								String nombreIndicador = txtNombreIndicador.getText();
							if(txtNombreIndicador.getText().isEmpty() || editorPane.getText().isEmpty()){
								JOptionPane.showMessageDialog(null, "Rellene todos los campos");
							}
							else 
								if(!persistence.crearIndicador(nombreIndicador, formula)){
									JOptionPane.showMessageDialog(null, "Ingresó una fórmula invalida");
								}
								else{
									JOptionPane.showMessageDialog(null, "Indicador creado");
								}
								
							}
						});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
