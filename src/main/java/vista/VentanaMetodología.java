package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaMetodología extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaMetodología dialog = new VentanaMetodología();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaMetodología() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane txtpnCargarMetodologa = new JTextPane();
			txtpnCargarMetodologa.setFont(new Font("Calibri", Font.BOLD, 14));
			txtpnCargarMetodologa.setText("Cargar Metodolog\u00EDa");
			txtpnCargarMetodologa.setForeground(Color.WHITE);
			txtpnCargarMetodologa.setBackground(Color.BLUE);
			txtpnCargarMetodologa.setBounds(152, 0, 123, 30);
			contentPanel.add(txtpnCargarMetodologa);
		}
		{
			JLabel lblNombreDeLa = new JLabel("Nombre de la Metodolog\u00EDa:");
			lblNombreDeLa.setFont(new Font("Calibri", Font.BOLD, 14));
			lblNombreDeLa.setBounds(10, 63, 172, 14);
			contentPanel.add(lblNombreDeLa);
		}
		{
			textField = new JTextField();
			textField.setBounds(278, 60, 146, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblIndicadoresAsociados = new JLabel("Indicadores Asociados:");
			lblIndicadoresAsociados.setFont(new Font("Calibri", Font.BOLD, 14));
			lblIndicadoresAsociados.setBounds(10, 107, 159, 14);
			contentPanel.add(lblIndicadoresAsociados);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(278, 104, 146, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			JLabel lblCondiciones = new JLabel("Condiciones:");
			lblCondiciones.setFont(new Font("Calibri", Font.BOLD, 14));
			lblCondiciones.setBounds(10, 151, 90, 14);
			contentPanel.add(lblCondiciones);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(278, 148, 146, 20);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
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
