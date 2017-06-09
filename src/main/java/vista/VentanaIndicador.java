package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.CustomListModelCuentas;
import modelo.Cuenta;
import modelo.Empresa;
import modelo.Indicador;
import parser.Parser;
import parser.AnalizadorLexico;
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

public class VentanaIndicador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
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
		
		
		
		
		
		
		setBounds(100, 100, 767, 561);
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
		
		textField = new JTextField();
		textField.setBounds(279, 50, 145, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblIngreseCuentasA = new JLabel("Nombre Empresa Asociada:");
		lblIngreseCuentasA.setFont(new Font("Calibri", Font.BOLD, 14));
		lblIngreseCuentasA.setBounds(10, 101, 183, 14);
		contentPanel.add(lblIngreseCuentasA);
		
		JLabel lblCuentasVinculadas = new JLabel("Cuentas");
		lblCuentasVinculadas.setFont(new Font("Calibri", Font.BOLD, 14));
		lblCuentasVinculadas.setBounds(61, 126, 104, 14);
		contentPanel.add(lblCuentasVinculadas);
		
		JTextPane txtpnCargarIndicador = new JTextPane();
		txtpnCargarIndicador.setFont(new Font("Calibri", Font.BOLD, 14));
		txtpnCargarIndicador.setText("Cargar Indicador");
		txtpnCargarIndicador.setForeground(Color.WHITE);
		txtpnCargarIndicador.setBackground(Color.BLUE);
		txtpnCargarIndicador.setBounds(152, 0, 104, 30);
		contentPanel.add(txtpnCargarIndicador);
		
		JComboBox cboEmpresas = new JComboBox();
		cboEmpresas.setBounds(279, 98, 145, 17);
		contentPanel.add(cboEmpresas);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(205, 155, 145, 149);
		contentPanel.add(textArea);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 348, 414, 115);
		contentPanel.add(editorPane);

		JList list = new JList();
		list.setBounds(10, 155, 145, 149);
		contentPanel.add(list);

		JLabel lblIndicadores = new JLabel("Indicadores");
		lblIndicadores.setFont(new Font("Calibri", Font.BOLD, 14));
		lblIndicadores.setBounds(243, 126, 159, 14);
		contentPanel.add(lblIndicadores);

		JLabel lblEscribaAquEl = new JLabel("Escriba aqu\u00ED el indicador a crear:");
		lblEscribaAquEl.setBounds(10, 323, 246, 14);
		contentPanel.add(lblEscribaAquEl);

		JLabel label = new JLabel("1");
		label.setBounds(423, 226, 46, 14);
		contentPanel.add(label);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*Parser parser  = new Parser();
				String formula_s = editorPane.getText();
				AnalizadorLexico analizadorLexico = new AnalizadorLexico();
				formula_s = analizadorLexico.analizar(formula_s);
				Double formula_d = parser.eval(formula_s);
				label.setText(String.valueOf(formula_d));
				*/
			}
		});
		btnOk.setBounds(463, 387, 89, 23);
		contentPanel.add(btnOk);


		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Atr\u00E1s");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						VentanaPrincipal ventPrincipal = new VentanaPrincipal();
						ventPrincipal.setVisible(true);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
