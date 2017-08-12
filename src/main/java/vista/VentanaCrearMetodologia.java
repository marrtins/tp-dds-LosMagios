package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Indicador;
import modelo.Metodologia;
import modelo.TiposCondicion.CondicionNoTaxativa;
import modelo.TiposCondicion.CondicionTaxativa;
import persistence.DataCollector;

import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.nio.channels.NetworkChannel;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaCrearMetodologia extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	public String[]nombreOperadoresT={"Creciente","Consistente","Antiguedad mayor que","Indicador mayor que","Indicador menor que"};
	public String[]operadorT={"crescent","consistent","antique","higherThan","lowerThan"};
	public String[]nombreOperadoresNT={"Mas Alto","Mas Bajo","Antiguedad mas alta"};
	public String[]operadorNT={"highest","lowest","antique"};
	public int[] necesitaComparar={3,4};
	public 	ArrayList<Indicador> indicadores;
	public ArrayList<CondicionTaxativa> taxativasACrear=new ArrayList<>();
	public ArrayList<CondicionNoTaxativa> noTaxativasACrear=new ArrayList<>();
	String indicadorString=null;
	
	DefaultListModel lstTModel = new DefaultListModel();
	DefaultListModel lstNTModel = new DefaultListModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearMetodologia frame = new VentanaCrearMetodologia();
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
	public VentanaCrearMetodologia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNombre = new JTextField();
		txtNombre.setBounds(157, 11, 135, 28);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		DataCollector persistence= new DataCollector();

		try {
			indicadores = persistence.cargarIndicadores();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 50, 166, 219);
		contentPane.add(scrollPane);

		JList lstT = new JList(lstTModel);
		scrollPane.setViewportView(lstT);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(240, 50, 166, 219);
		contentPane.add(scrollPane_1);

		JList lstNT = new JList(lstNTModel);
		scrollPane_1.setViewportView(lstNT);

		JButton btnTaxativas = new JButton("Agregar Condicion Taxativa");
		btnTaxativas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//VentanaCrearCTaxativa ventCrearTaxativa = new VentanaCrearCTaxativa(this);
				//ventCrearTaxativa.setVisible(true);
				//dispose();
				//PPPP

				JTextField xField = new JTextField(5);
				JTextField yField = new JTextField(10);
				JComboBox comboOpciones = new JComboBox<>();

				for(String unOperador:nombreOperadoresT){
					comboOpciones.addItem(unOperador);
				}

				JComboBox comboIndicadores = new JComboBox<>();
				indicadores.forEach(unIndicador->comboIndicadores.addItem(unIndicador.getNombreIndicador()));



				JPanel myPanel = new JPanel();

				myPanel.add(comboOpciones);
				myPanel.add(comboIndicadores);
				myPanel.add(new JLabel("\nAños:"));
				myPanel.add(xField);
				myPanel.add(Box.createHorizontalStrut(15)); // a spacer
				myPanel.add(new JLabel("\nValor a comparar:"));
				myPanel.add(yField);
				yField.setEditable(false);
				indicadorString = indicadores.get(0).getNombreIndicador();
				comboOpciones.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						if(comboOpciones.getSelectedIndex() == 3 ||comboOpciones.getSelectedIndex() == 4){
							yField.setEditable(true);}
						else{ yField.setEditable(false);

						}
						if(comboOpciones.getSelectedIndex()==2){
							indicadorString = "";
						}else{
							indicadorString = (String) comboIndicadores.getSelectedItem();
						}

					}
					});

				int result = JOptionPane.showConfirmDialog(null, myPanel,"Nueva Condicion Taxativa", JOptionPane.OK_CANCEL_OPTION);
				Double valorComparar=-1.0;
				if (result == JOptionPane.OK_OPTION) {
					
					
					String operadorTax = nombreOperadoresT[comboOpciones.getSelectedIndex()];
					int anios = Integer.parseInt(xField.getText());
					if(yField.isEditable())valorComparar =  Double.parseDouble(yField.getText());
					String nombreCondicion = indicadorString +" "+ operadorTax + " en " +String.valueOf(anios)+" Años";
					if(valorComparar!=-1)nombreCondicion+="Valor a comparar:"+String.valueOf(valorComparar);
					CondicionTaxativa nuevaCondicion = new CondicionTaxativa(nombreCondicion,operadorTax ,anios, indicadorString,valorComparar);
					taxativasACrear.add(nuevaCondicion);
					lstTModel.addElement(nuevaCondicion.getNombreCondicion());
				}

			}		

				//FFF
			});
		btnTaxativas.setBounds(31, 280, 166, 49);
		contentPane.add(btnTaxativas);

		JButton btnNoTaxativa = new JButton("Agrega Condicion no taxativa");
		btnNoTaxativa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//VentanaCrearCNoTaxativa ventCrearNoTaxativa = new VentanaCrearCNoTaxativa();
				//ventCrearNoTaxativa.setVisible(true);
				//dispose();
				JTextField xField = new JTextField(5);
				JTextField pField = new JTextField(5);
				JComboBox comboOpciones = new JComboBox<>();

				for(String unOperador:nombreOperadoresNT){
					comboOpciones.addItem(unOperador);
				}

				JComboBox comboIndicadores = new JComboBox<>();
				indicadores.forEach(unIndicador->comboIndicadores.addItem(unIndicador.getNombreIndicador()));



				JPanel myPanel = new JPanel();

				myPanel.add(comboOpciones);
				myPanel.add(comboIndicadores);
				myPanel.add(new JLabel("\nAños:"));
				myPanel.add(xField);
				myPanel.add(Box.createHorizontalStrut(15)); // a spacer
				myPanel.add(new JLabel("\nPeso:"));
				myPanel.add(pField);
				
				
				indicadorString = indicadores.get(0).getNombreIndicador();
				comboOpciones.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						if(comboOpciones.getSelectedIndex()==2){
							indicadorString = "";
						}else{
							indicadorString = (String) comboIndicadores.getSelectedItem();
						}

					}
					});

				int result = JOptionPane.showConfirmDialog(null, myPanel,"Nueva Condicion NO Taxativa", JOptionPane.OK_CANCEL_OPTION);
				Double valorComparar=-1.0;
				if (result == JOptionPane.OK_OPTION) {
					
					
					String operadorTax = operadorNT[comboOpciones.getSelectedIndex()];
					int anios = Integer.parseInt(xField.getText());
					int peso = Integer.parseInt(pField.getText());
					
					String nombreCondicion = indicadorString +" "+ operadorTax + " en " +String.valueOf(anios)+" Años";
					CondicionNoTaxativa nuevaCondicion = new CondicionNoTaxativa(nombreCondicion,operadorTax ,anios,peso, indicadorString);
					noTaxativasACrear.add(nuevaCondicion);
					lstNTModel.addElement(nuevaCondicion.getNombreCondicion());
				}

			}		

				
			});
				
		
		btnNoTaxativa.setBounds(240, 280, 166, 49);
		contentPane.add(btnNoTaxativa);

		JButton btnC = new JButton("Crear Metodologia");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Metodologia nuevaMet = new Metodologia();
				nuevaMet.setNombreMetodologia(txtNombre.getSelectedText());
				nuevaMet.setcNoTaxativas(noTaxativasACrear);
				nuevaMet.setcTaxativas(taxativasACrear);
				
			}
		});
		btnC.setBounds(445, 149, 141, 59);
		contentPane.add(btnC);

		

		JLabel lblNewLabel = new JLabel("Nombre Metodologia");
		lblNewLabel.setBounds(41, 18, 106, 14);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Borrar Condicion Seleccionada");
		btnNewButton.setBounds(31, 341, 166, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Borrar Condicion Seleccionada");
		btnNewButton_1.setBounds(240, 340, 166, 23);
		contentPane.add(btnNewButton_1);
		}

	}



