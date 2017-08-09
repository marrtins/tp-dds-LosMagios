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
import java.util.LinkedList;
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

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
			metodologias=persistence.cargarMetodologias();
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
				
				txtDescripcion.setText(" ");
				
				
			}
		});
		cboMetodologia.setBounds(31, 34, 198, 30);
		contentPane.add(cboMetodologia);
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 285, 347, 120);
		contentPane.add(panel);
		
		JLabel lblEmpresasAAnalizar = new JLabel("Empresas a analizar");
		lblEmpresasAAnalizar.setBounds(31, 260, 267, 14);
		contentPane.add(lblEmpresasAAnalizar);
		
		JTextPane txtResultado = new JTextPane();
		txtResultado.setBounds(462, 191, 119, 134);
		contentPane.add(txtResultado);
		
		
		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Metodologia metodologiaAAplicar = metodologias.get(0);
				
				LinkedList<Empresa> listaOrdenada= metodologiaAAplicar.aplicarMetodologia(empresas);
				
				txtResultado.setText(listaOrdenada.get(0).getNombreEmpresa());
				txtResultado.setText(listaOrdenada.get(1).getNombreEmpresa());
				txtResultado.setText(listaOrdenada.get(2).getNombreEmpresa());
				
			}
		});
		btnAplicar.setBounds(395, 133, 89, 23);
		contentPane.add(btnAplicar);
		
			
		
		for(int i=0;i<empresas.size();i++){
			JCheckBox chk = new JCheckBox(empresas.get(i).getNombreEmpresa());
			chk.setSelected(true);
			panel.add(chk);
			
		}
		
	}
}
