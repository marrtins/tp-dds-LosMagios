package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import modelo.Empresa;
import modelo.Indicador;
import modelo.Periodo;
import parser.AnalizadorLexico;
import parser.Parser;
import persistence.CustomListModelEmpresa;
import persistence.DataCollector;

public class VentanaAplicarI extends JFrame {

	private JPanel contentPane;
	CustomListModelEmpresa list_modelEmpresa = new CustomListModelEmpresa();
	Empresa empresaSeleccionada ;
	Periodo periodoSeleccionado;
	Indicador indicadorSeleccionado;
	private ArrayList<Indicador> indicadores;
	private ArrayList<Empresa> empresas;
	private ArrayList<Periodo> periodos;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAplicarI frame = new VentanaAplicarI();
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
	public VentanaAplicarI() {
		
		
DataCollector persistence = new DataCollector();
		
		empresas = persistence.cargarEmpresas();
		indicadores = persistence.cargarIndicadores();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JComboBox cboPeriodo = new JComboBox();
		cboPeriodo.setBounds(199, 26, 158, 20);
		contentPane.add(cboPeriodo);
				
		JComboBox cboIndicador = new JComboBox();
		cboIndicador.setBounds(199, 69, 158, 20);
		contentPane.add(cboIndicador);
	
		JLabel lblValor = new JLabel("New label");
		lblValor.setBounds(240, 148, 46, 14);
		contentPane.add(lblValor);
		
		indicadores.forEach(ind -> cboIndicador.addItem(ind.getNombreIndicador()));
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				indicadorSeleccionado = indicadores.get(cboIndicador.getSelectedIndex());
				periodoSeleccionado = periodos.get(cboPeriodo.getSelectedIndex());
				Parser parser = new Parser();
				AnalizadorLexico analizadorLexico = new AnalizadorLexico();
				String formulaString = analizadorLexico.analizar(indicadorSeleccionado.getCalculoIndicador(),empresaSeleccionada,periodoSeleccionado);
				Double resultadoCalculo = parser.eval(formulaString);
				lblValor.setText(String.valueOf(resultadoCalculo));
			}
		});
		btnCalcular.setBounds(240, 100, 89, 23);
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
		lstEmpresas.setBounds(36, 11, 151, 198);
		contentPane.add(lstEmpresas);
		list_modelEmpresa.setEmpresas(empresas);;
		lstEmpresas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstEmpresas.setModel(list_modelEmpresa);
		
		
		
		
	}

}
