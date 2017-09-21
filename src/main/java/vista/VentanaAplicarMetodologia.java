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
import java.util.Vector;
import java.util.function.Function;

import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListDataEvent;

import entities.Empresa;
import entities.Indicador;
import entities.Metodologia;
import entities.Periodo;
import entities.TiposCondicion.CondicionNoTaxativa;
import entities.TiposCondicion.CondicionTaxativa;
import persistence.CustomListModelEmpresa;
import persistence.DataCollector;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JToggleButton;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JTextArea;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTable;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Font;

public class VentanaAplicarMetodologia extends JFrame {

	private JPanel contentPane;
	DefaultListModel lstResModel = new DefaultListModel();
	ArrayList<Empresa> empresasAAnalizar =null;
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
			empresasAAnalizar=empresas;
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
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 84, 147, 165);
		contentPane.add(scrollPane);
		
		JTextPane txtNT = new JTextPane();
		txtNT.setEditable(false);
		scrollPane.setViewportView(txtNT);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(211, 84, 147, 165);
		contentPane.add(scrollPane_1);
		
		JTextPane txtT = new JTextPane();
		txtT.setEditable(false);
		scrollPane_1.setViewportView(txtT);
		
		
		

		JComboBox cboMetodologia = new JComboBox();
		cboMetodologia.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Metodologia metodologiaSeleccionada = metodologias.get(cboMetodologia.getSelectedIndex());
				

				txtT.setText("Condiciones Taxativas:\n\n" + metodologiaSeleccionada.getDescripcionCondicionTaxativas());
				txtNT.setText("Condiciones No Taxativas:\n\n" + metodologiaSeleccionada.getDescripcionCondicionNoTaxativas());
			}
		});


		
		
		cboMetodologia.setBounds(31, 34, 198, 30);
		contentPane.add(cboMetodologia);
		
		metodologias.forEach(met -> cboMetodologia.addItem(met.getNombreMetodologia()));
		
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(420, 84, 189, 165);
		contentPane.add(scrollPane_2);
		
		
		
		JList lstRes = new JList<>(lstResModel);
		scrollPane_2.setViewportView(lstRes);
		lstRes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		lstRes.setLayoutOrientation(JList.VERTICAL);
		lstRes.setVisibleRowCount(-1);
		scrollPane_2.setViewportView(lstRes);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 285, 347, 120);
		contentPane.add(panel);
		
		JLabel lblEmpresasAAnalizar = new JLabel("Empresas a analizar");
		lblEmpresasAAnalizar.setBounds(31, 260, 267, 14);
		contentPane.add(lblEmpresasAAnalizar);
		
		

		
		
		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				int i=0;

				lstResModel.removeAllElements();
				
				Metodologia metodologiaAAplicar = metodologias.get(cboMetodologia.getSelectedIndex());
				
				
				
				
				
				LinkedList<Empresa> listaOrdenada= metodologiaAAplicar.aplicarMetodologia(empresasAAnalizar);
							
				listaOrdenada.forEach(unaEmpresa->{
					lstResModel.addElement(unaEmpresa.getNombreEmpresa());	
				});
				if(listaOrdenada.size()==0){
					lstResModel.addElement("Ninguna empresa cumple con las condiciones estipuladas");
				}
				listaOrdenada.clear();
								
			}

			
		});
		btnAplicar.setBounds(483, 38, 89, 23);
		contentPane.add(btnAplicar);
		
		JTextPane txtpnAplicarMetodologa = new JTextPane();
		txtpnAplicarMetodologa.setText("Aplicar Metodolog\u00EDa");
		txtpnAplicarMetodologa.setForeground(Color.WHITE);
		txtpnAplicarMetodologa.setFont(new Font("Calibri", Font.BOLD, 14));
		txtpnAplicarMetodologa.setBackground(Color.BLUE);
		txtpnAplicarMetodologa.setBounds(248, 0, 125, 30);
		contentPane.add(txtpnAplicarMetodologa);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMetodologia ventMetod = new VentanaMetodologia();
				ventMetod.setVisible(true);
				dispose();
			}
		});
		btnAtrs.setBounds(530, 393, 89, 23);
		contentPane.add(btnAtrs);
		
		
		
		empresas.forEach(unaEmpresa->{
			JCheckBox chk = new JCheckBox(unaEmpresa.getNombreEmpresa());
			chk.setSelected(true);
			panel.add(chk);	
			chk.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(!chk.isSelected()){
						empresasAAnalizar.add(unaEmpresa);
						
					}
					else{
						empresasAAnalizar.remove(unaEmpresa);
					}
				}
			});
		});
			
		
		
	}
}
