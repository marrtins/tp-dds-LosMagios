package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import analizadorIndicadores.AnalizadorLexico;
import analizadorIndicadores.Parser;
import modelo.Empresa;
import modelo.Indicador;
import modelo.Metodologia;
import modelo.Periodo;
import persistence.CustomListModelEmpresa;
import persistence.DataCollector;

public class VentanaAplicarIndicador extends JFrame {

	private JPanel contentPane;
	CustomListModelEmpresa list_modelEmpresa = new CustomListModelEmpresa();
	Empresa empresaSeleccionada ;
	Periodo periodoSeleccionado;
	Indicador indicadorSeleccionado;
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
					VentanaAplicarIndicador frame = new VentanaAplicarIndicador();
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
	public VentanaAplicarIndicador() {
		
		
		DataCollector persistence = new DataCollector();
		
		try {
			empresas = persistence.cargarEmpresas();
			metodologias=persistence.cargarMetodologias();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			indicadores = persistence.cargarIndicadores();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JComboBox cboPeriodo = new JComboBox();
		cboPeriodo.setBounds(199, 45, 211, 20);
		contentPane.add(cboPeriodo);
				
		JComboBox cboIndicador = new JComboBox();
		cboIndicador.setBounds(199, 94, 211, 20);
		contentPane.add(cboIndicador);
	
		JLabel lblValor = new JLabel("Resultado: ");
		lblValor.setBounds(199, 204, 164, 14);
		contentPane.add(lblValor);
		
		indicadores.forEach(ind -> cboIndicador.addItem(ind.getNombreIndicador()));
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblValor.setText("Resultado: ");
				indicadorSeleccionado = indicadores.get(cboIndicador.getSelectedIndex());
				periodoSeleccionado = periodos.get(cboPeriodo.getSelectedIndex());
				String resultado = String.valueOf(indicadorSeleccionado.aplicarIndicadorA(empresaSeleccionada, periodoSeleccionado));
				lblValor.setText(("Resultado: " +resultado ));
				
				
			}
		});
		btnCalcular.setBounds(253, 125, 97, 38);
		contentPane.add(btnCalcular);
		
		JList lstEmpresas = new JList();
		lstEmpresas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			empresaSeleccionada = empresas.get(lstEmpresas.getSelectedIndex());
			cboPeriodo.removeAllItems();
			periodos = empresaSeleccionada.getPeriodos();
			periodos.forEach(per->cboPeriodo.addItem(per.getAnio()));
			}
		});
		
		lstEmpresas.setBounds(10, 45, 177, 209);
		contentPane.add(lstEmpresas);
		list_modelEmpresa.setEmpresas(empresas);;
		lstEmpresas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstEmpresas.setModel(list_modelEmpresa);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaIndicador ventIndicador = new VentanaIndicador();
				ventIndicador.setVisible(true);
				dispose();
			}
		});
		btnAtrs.setBounds(331, 242, 89, 23);
		contentPane.add(btnAtrs);
		
		JTextPane txtpnAplicarIndicadores = new JTextPane();
		txtpnAplicarIndicadores.setFont(new Font("Calibri", Font.BOLD, 14));
		txtpnAplicarIndicadores.setText("Aplicar Indicadores");
		txtpnAplicarIndicadores.setBackground(Color.BLUE);
		txtpnAplicarIndicadores.setForeground(new Color(255, 255, 255));
		txtpnAplicarIndicadores.setBounds(149, 0, 119, 30);
		contentPane.add(txtpnAplicarIndicadores);
	
	}
}
