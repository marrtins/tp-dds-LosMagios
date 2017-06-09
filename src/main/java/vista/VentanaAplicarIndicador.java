package vista;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;

import modelo.Cuenta;
import modelo.Empresa;
import modelo.Indicador;
import modelo.Periodo;
import parser.AnalizadorLexico;
import parser.Parser;
import persistence.CustomListModelEmpresa;
import persistence.DataCollector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAplicarIndicador {
	private ArrayList<Indicador> indicadores;
	private ArrayList<Empresa> empresas;
	private ArrayList<Periodo> periodos;
	private ArrayList<Cuenta> cuentas;
	private JFrame frame;
	CustomListModelEmpresa list_modelEmpresa = new CustomListModelEmpresa();
	Empresa empresaSeleccionada ;
	Periodo periodoSeleccionado;
	Indicador indicadorSeleccionado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAplicarIndicador window = new VentanaAplicarIndicador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaAplicarIndicador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DataCollector persistence = new DataCollector();
		
		empresas = persistence.cargarEmpresas();
		indicadores = persistence.cargarIndicadores();
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox cboPeriodo = new JComboBox();
		cboPeriodo.setBounds(199, 49, 151, 20);
		frame.getContentPane().add(cboPeriodo);
				
		JComboBox cboIndicador = new JComboBox();
		cboIndicador.setBounds(199, 113, 130, 20);
		frame.getContentPane().add(cboIndicador);
	
		JLabel lblValor = new JLabel("New label");
		lblValor.setBounds(283, 164, 46, 14);
		frame.getContentPane().add(lblValor);
		
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
		btnCalcular.setBounds(224, 80, 89, 23);
		frame.getContentPane().add(btnCalcular);
		
	
		
		
		
		
		
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
		lstEmpresas.setBounds(45, 51, 108, 138);
		frame.getContentPane().add(lstEmpresas);
		list_modelEmpresa.setEmpresas(empresas);;
		lstEmpresas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstEmpresas.setModel(list_modelEmpresa);
		
		
		
		
		
		
	}
}
