package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;

public class VentanaIndicador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		setBounds(100, 100, 450, 300);
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
		
		textField_1 = new JTextField();
		textField_1.setBounds(279, 98, 145, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCuentasVinculadas = new JLabel("Cuentas Vinculadas:");
		lblCuentasVinculadas.setFont(new Font("Calibri", Font.BOLD, 14));
		lblCuentasVinculadas.setBounds(10, 154, 134, 14);
		contentPanel.add(lblCuentasVinculadas);
		
		textField_2 = new JTextField();
		textField_2.setBounds(279, 148, 145, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JTextPane txtpnCargarIndicador = new JTextPane();
		txtpnCargarIndicador.setFont(new Font("Calibri", Font.BOLD, 14));
		txtpnCargarIndicador.setText("Cargar Indicador");
		txtpnCargarIndicador.setForeground(Color.WHITE);
		txtpnCargarIndicador.setBackground(Color.BLUE);
		txtpnCargarIndicador.setBounds(152, 0, 104, 30);
		contentPanel.add(txtpnCargarIndicador);
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
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
