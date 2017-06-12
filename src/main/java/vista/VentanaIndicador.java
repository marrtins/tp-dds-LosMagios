package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cuenta;
import modelo.Empresa;
import modelo.Indicador;
import parser.Parser;
import parser.AnalizadorLexico;
import parser.AnalizadorSintactico;
import persistence.DAOJsonEmpresa;
import persistence.DataCollector;
import persistence.RepositorioDeEmpresas;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaIndicador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreIndicador;
	private ArrayList<Empresa> empresas = new ArrayList<>();
	private ArrayList<Cuenta> cuentas = new ArrayList<>();
	private ArrayList<Indicador> indicadores = new ArrayList<>();
	private RepositorioDeEmpresas repoEmpresas;	
	private DAOJsonEmpresa dao;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaIndicador dialog = new VentanaIndicador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaIndicador() {
		
		
		
		DataCollector persistence = new DataCollector();
		indicadores = persistence.cargarIndicadores();
		
		
		
		
		
		
		setBounds(100, 100, 571, 446);
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
		txtNombreIndicador.setBounds(279, 50, 145, 20);
		contentPanel.add(txtNombreIndicador);
		txtNombreIndicador.setColumns(10);
		
		JTextPane txtpnCargarIndicador = new JTextPane();
		txtpnCargarIndicador.setFont(new Font("Calibri", Font.BOLD, 14));
		txtpnCargarIndicador.setText("Crear Indicador");
		txtpnCargarIndicador.setForeground(Color.WHITE);
		txtpnCargarIndicador.setBackground(Color.BLUE);
		txtpnCargarIndicador.setBounds(152, 0, 104, 30);
		contentPanel.add(txtpnCargarIndicador);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 155, 414, 115);
		contentPanel.add(editorPane);

		JLabel lblEscribaAquEl = new JLabel("Escriba aqu\u00ED el indicador a crear (ingrese cuentas e indicadores entre llaves \"{ }\"):");
		lblEscribaAquEl.setBounds(10, 130, 393, 14);
		contentPanel.add(lblEscribaAquEl);


		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Atr\u00E1s");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						VentanaPrincipal ventPrincipal = new VentanaPrincipal();
						ventPrincipal.setVisible(true);
						dispose();
					}
				});
				
						JButton btnOk = new JButton("OK");
						buttonPane.add(btnOk);
						btnOk.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								AnalizadorSintactico sintax = new AnalizadorSintactico();
								String formula = editorPane.getText();
								String nombreIndicador = txtNombreIndicador.getText();
								if(sintax.indicadorValido(formula)){
									Indicador indicador = new Indicador();
									indicador.setNombreIndicador(nombreIndicador);
									indicador.setCalculoIndicador(formula);
									persistence.agregarIndicador(indicador);
								}
								else{
									JOptionPane.showMessageDialog(null, "Ingres� una f�rmula invalida");
								}
								
							}
						});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
