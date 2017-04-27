package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;

public class VentanaCuentas extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaCuentas dialog = new VentanaCuentas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaCuentas() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnSeleccioneLaOpcin = new JTextPane();
		txtpnSeleccioneLaOpcin.setForeground(Color.WHITE);
		txtpnSeleccioneLaOpcin.setBackground(Color.BLUE);
		txtpnSeleccioneLaOpcin.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtpnSeleccioneLaOpcin.setBounds(138, 11, 170, 29);
		txtpnSeleccioneLaOpcin.setText("Seleccione la opci\u00F3n deseada");
		contentPanel.add(txtpnSeleccioneLaOpcin);
		
		JButton btnCargarCuentaEmpresa = new JButton("Cargar Cuenta Empresa");
		btnCargarCuentaEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCargarCuentaEmpresa.setBounds(138, 82, 170, 20);
		contentPanel.add(btnCargarCuentaEmpresa);
		
		JButton btnFiltrarValoresCuenta = new JButton("Filtrar Valores Cuenta");
		btnFiltrarValoresCuenta.setBounds(138, 138, 170, 20);
		contentPanel.add(btnFiltrarValoresCuenta);
	}

}

