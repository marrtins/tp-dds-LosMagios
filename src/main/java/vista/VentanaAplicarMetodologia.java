package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Scrollbar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Function;

import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;

import modelo.Empresa;
import modelo.Indicador;
import modelo.Metodologia;
import modelo.Periodo;
import persistence.DataCollector;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaAplicarMetodologia extends JFrame {

	private JPanel contentPane;
	
	private ArrayList<Indicador> indicadores;
	private ArrayList<Empresa> empresas;
	private ArrayList<Periodo> periodos;
	private ArrayList<Metodologia> metodologias;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAplicarMetodologia frame = new VentanaAplicarMetodologia();
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
	public VentanaAplicarMetodologia() {
		

		DataCollector persistence = new DataCollector();
		

		try {
			empresas = persistence.cargarEmpresas();
			indicadores = persistence.cargarIndicadores();
			metodologias = persistence.cargarMetodologias();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		

		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JTextPane txtDescripcion = new JTextPane();
		txtDescripcion.setText("Seleccione una metodolog\u00EDa");
		txtDescripcion.setBounds(28, 75, 201, 167);
		contentPane.add(txtDescripcion);
		txtDescripcion.setEditable(false);
		
		
		JComboBox cboMetodologia = new JComboBox();
		cboMetodologia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int indice = cboMetodologia.getSelectedIndex();
				Metodologia metSelec = metodologias.get(indice);
				String descripcionMetodologia = metSelec.getDescripcion();
				txtDescripcion.setText(" ");
				txtDescripcion.setText(descripcionMetodologia);
				
				
			}
		});
		cboMetodologia.setBounds(31, 34, 198, 30);
		contentPane.add(cboMetodologia);
		
		metodologias.forEach(met -> cboMetodologia.addItem(met.getNombreMetodologia()));
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 285, 347, 120);
		contentPane.add(panel);
		
		JLabel lblEmpresasAAnalizar = new JLabel("Empresas a analizar");
		lblEmpresasAAnalizar.setBounds(31, 260, 267, 14);
		contentPane.add(lblEmpresasAAnalizar);
			
		
		for(int i=0;i<empresas.size();i++){
			JCheckBox chk = new JCheckBox(empresas.get(i).getNombreEmpresa());
			chk.setSelected(true);
			panel.add(chk);
			
		}
		
	}
}
