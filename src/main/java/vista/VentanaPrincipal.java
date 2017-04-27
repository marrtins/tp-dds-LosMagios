package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.JToolBar;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTextArea;
import java.awt.Font;

public class VentanaPrincipal {

	private JFrame frmAsd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmAsd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAsd = new JFrame();
		frmAsd.setTitle("\u00BFDonde invierto?");
		frmAsd.getContentPane().setEnabled(false);
		frmAsd.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		panel.setToolTipText("");
		panel.setForeground(Color.MAGENTA);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.PINK, Color.RED));
		panel.setBounds(194, 110, 194, 149);
		frmAsd.getContentPane().add(panel);
		
		JButton btnCargarCuentasEmpresa = new JButton("Cargar cuentas empresa");
		panel.add(btnCargarCuentasEmpresa);
		btnCargarCuentasEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnGenerarIndicador = new JButton("Generar indicador");
		panel.add(btnGenerarIndicador);
		
		JButton btnCargarMetodologia = new JButton("Cargar metodologia");
		btnCargarMetodologia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnCargarMetodologia);
		
		JButton btnGenerarGraficoComparativo = new JButton("Generar grafico comparativo");
		panel.add(btnGenerarGraficoComparativo);
		
		JButton btnConsultarValoresIndicador = new JButton("Consultar valores indicador");
		panel.add(btnConsultarValoresIndicador);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnCargarCuentasEmpresa, btnGenerarIndicador, btnCargarMetodologia, btnGenerarGraficoComparativo, btnConsultarValoresIndicador}));
		
		JTextArea txtrdondeInvierto = new JTextArea();
		txtrdondeInvierto.setTabSize(10);
		txtrdondeInvierto.setFont(new Font("Monotype Corsiva", Font.PLAIN, 24));
		txtrdondeInvierto.setForeground(Color.MAGENTA);
		txtrdondeInvierto.setText("Bienvenido a \u00BFDonde invierto?");
		txtrdondeInvierto.setBounds(31, 26, 464, 32);
		frmAsd.getContentPane().add(txtrdondeInvierto);
		
		JTextArea txtrElijaUnaOpcion = new JTextArea();
		txtrElijaUnaOpcion.setText("Por favor, elija una opci\u00F3n");
		txtrElijaUnaOpcion.setBounds(181, 77, 220, 22);
		frmAsd.getContentPane().add(txtrElijaUnaOpcion);
		btnCargarMetodologia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmAsd.setBounds(100, 100, 595, 387);
		frmAsd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
