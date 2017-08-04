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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaMetodologia extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
	public VentanaMetodologia() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre de la Metodologia:");
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
		
		JTextPane txtpnCargarMetodologia = new JTextPane();
		txtpnCargarMetodologia.setFont(new Font("Calibri", Font.BOLD, 14));
		txtpnCargarMetodologia.setText("Cargar Metodolog\u00EDa");
		txtpnCargarMetodologia.setForeground(Color.WHITE);
		txtpnCargarMetodologia.setBackground(Color.BLUE);
		txtpnCargarMetodologia.setBounds(152, 0, 123, 30);
		contentPanel.add(txtpnCargarMetodologia);
		
		JButton btnAplicar = new JButton("Aplicar Metodolog\u00EDa");
		btnAplicar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VentanaAplicarMetodologia ventanaAplicar = new VentanaAplicarMetodologia();
				ventanaAplicar.setVisible(true);
				dispose();
			}
		});
		btnAplicar.setBounds(104, 181, 228, 23);
		contentPanel.add(btnAplicar);
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
