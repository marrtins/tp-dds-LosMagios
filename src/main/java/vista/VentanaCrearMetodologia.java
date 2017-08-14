package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import erroresVista.NuevaCNTCheck;
import erroresVista.NuevaCTCheck;
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
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;

public class VentanaCrearMetodologia extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	public String[]nombreOperadoresT={"Creciente","Consistente","Antiguedad mayor que","Mayor que","Menor que"};
	public String[]operadorT={"crescent","consistent","antique","higherThan","lowerThan"};
	public String[]nombreOperadoresNT={"Mas Alto","Mas Bajo","Antiguedad mas alta posible"};
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
		txtNombre.setBounds(240, 42, 127, 28);
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
		scrollPane.setBounds(30, 80, 135, 190);
		contentPane.add(scrollPane);

		JList lstT = new JList(lstTModel);
		scrollPane.setViewportView(lstT);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(240, 81, 127, 188);
		contentPane.add(scrollPane_1);

		JList lstNT = new JList(lstNTModel);
		scrollPane_1.setViewportView(lstNT);

		JButton btnTaxativas = new JButton("Agregar Condici\u00F3n Taxativa");
		btnTaxativas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JTextField xField = new JTextField(5);
				JTextField yField = new JTextField(10);
				JComboBox comboOpciones = new JComboBox<>();

				for(String unOperador:nombreOperadoresT){
					comboOpciones.addItem(unOperador);
				}

				JComboBox comboIndicadores = new JComboBox<>();
				indicadores.forEach(unIndicador->comboIndicadores.addItem(unIndicador.getNombreIndicador()));
				comboIndicadores.addItem("No aplica");
				JPanel myPanel = new JPanel();

				myPanel.add(comboOpciones);
				comboOpciones.setEditable(true);
				comboIndicadores.setEditable(true);
				myPanel.add(comboIndicadores);
				myPanel.add(new JLabel("\nAños:"));
				myPanel.add(xField);
				myPanel.add(Box.createHorizontalStrut(15)); // a spacer
				myPanel.add(new JLabel("\nValor a comparar:"));
				myPanel.add(yField);
				yField.setText("0.0");
				yField.setEditable(false);
				indicadorString = indicadores.get(0).getNombreIndicador();
				comboOpciones.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						if(comboOpciones.getSelectedIndex() == 3 ||comboOpciones.getSelectedIndex() == 4){
							yField.setEditable(true);
							yField.setText("");

						}
						else{
							yField.setEditable(false);
							yField.setText("0.0");
						}
						if(comboOpciones.getSelectedIndex()==2){
							
							comboIndicadores.setEnabled(false);
							
							comboIndicadores.setSelectedIndex(indicadores.size());
						}else{
							comboIndicadores.setEnabled(true);
							comboIndicadores.setSelectedIndex(0);
						}
					
					}
					});

				int result = JOptionPane.showConfirmDialog(null, myPanel,"Nueva Condicion Taxativa", JOptionPane.OK_CANCEL_OPTION);
				Double valorComparar;
				if (result == JOptionPane.OK_OPTION) {
					
					NuevaCTCheck check = new NuevaCTCheck();
					
					String operadorTax = operadorT[comboOpciones.getSelectedIndex()];
					String nombreOperadorTax = nombreOperadoresT[comboOpciones.getSelectedIndex()];
					String indicadorString;
					
					if(comboIndicadores.getSelectedIndex()==indicadores.size()){
						indicadorString="No aplica";
					}else{
						indicadorString=indicadores.get(comboIndicadores.getSelectedIndex()).getNombreIndicador();
					}
					
					if(check.condicionValida(operadorTax,indicadorString, xField.getText(),yField.getText())){
						
					
					int anios = Integer.parseInt(xField.getText());
					valorComparar =	Double.parseDouble(yField.getText());
					
					String nombreCondicion=check.getNombreCondicion(indicadorString,nombreOperadorTax,anios,valorComparar);
					
					
					CondicionTaxativa nuevaCondicion = new CondicionTaxativa(nombreCondicion,operadorTax ,anios, indicadorString,valorComparar);
					taxativasACrear.add(nuevaCondicion);
					lstTModel.addElement(nuevaCondicion.getNombreCondicion());
							
					}else{
						JOptionPane.showMessageDialog(null, "No se pudo crear la condición. Revise los datos");
					}
					
				}

			}		

				//FFF
			});
		btnTaxativas.setBounds(31, 280, 134, 49);
		contentPane.add(btnTaxativas);

		JButton btnNoTaxativa = new JButton("Agrega Condici\u00F3n No Taxativa");
		btnNoTaxativa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField xField = new JTextField(5);
				JTextField pField = new JTextField(10);
				JComboBox comboOpciones = new JComboBox<>();

				for(String unOperador:nombreOperadoresNT){
					comboOpciones.addItem(unOperador);
				}

				JComboBox comboIndicadores = new JComboBox<>();
				indicadores.forEach(unIndicador->comboIndicadores.addItem(unIndicador.getNombreIndicador()));
				comboIndicadores.addItem("No aplica");


				JPanel myPanel = new JPanel();

				myPanel.add(comboOpciones);
				myPanel.add(comboIndicadores);
				myPanel.add(new JLabel("\nAños:"));
				myPanel.add(xField);
				myPanel.add(Box.createHorizontalStrut(15)); // a spacer
				myPanel.add(new JLabel("\nPeso:"));
				myPanel.add(pField);
				
				comboOpciones.setEditable(true);
				comboIndicadores.setEditable(true);
				
				String indicadorSeleccionado;
				
				comboOpciones.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						if(comboOpciones.getSelectedIndex()==2){
							comboIndicadores.setEnabled(false);

							comboIndicadores.setSelectedIndex(indicadores.size());
							xField.setText("0");
							xField.setEnabled(false);
						}else{
							comboIndicadores.setEnabled(true);
							comboIndicadores.setSelectedIndex(0);
							xField.setText("");
							xField.setEnabled(true);
						}
					
					}
					});

				int result = JOptionPane.showConfirmDialog(null, myPanel,"Nueva Condicion NO Taxativa", JOptionPane.OK_CANCEL_OPTION);
				Double valorComparar=-1.0;
				if (result == JOptionPane.OK_OPTION) {
					NuevaCNTCheck check=new NuevaCNTCheck();
					
					String operadorNTax = operadorNT[comboOpciones.getSelectedIndex()];
					String nombreOperadorNT=nombreOperadoresNT[comboOpciones.getSelectedIndex()];
					
					if(comboIndicadores.getSelectedIndex()==indicadores.size()){
						indicadorSeleccionado="No aplica";
					}else{
						indicadorSeleccionado=indicadores.get(comboIndicadores.getSelectedIndex()).getNombreIndicador();
					}
					if(check.condicionValida(operadorNTax, indicadorSeleccionado, xField.getText(),pField.getText())){

						int anios = Integer.parseInt(xField.getText());
						int peso = Integer.parseInt(pField.getText());

						String nombreCondicion=check.getNombreCondicion(indicadorSeleccionado,nombreOperadorNT,anios,peso);


						CondicionNoTaxativa nuevaCondicion = new CondicionNoTaxativa(nombreCondicion,operadorNTax ,anios, peso,indicadorSeleccionado);
						noTaxativasACrear.add(nuevaCondicion);
						lstNTModel.addElement(nuevaCondicion.getNombreCondicion());

					}else{
						JOptionPane.showMessageDialog(null, "No se pudo crear la condición. Revise los datos");
					}
				}

			}		

				
			});
				
		
		btnNoTaxativa.setBounds(240, 280, 127, 49);
		contentPane.add(btnNoTaxativa);

		JButton btnC = new JButton("Crear Metodología");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreMet = txtNombre.getText();
				if(persistence.sePuedeCrearMetodologia(nombreMet,taxativasACrear,noTaxativasACrear)){
					persistence.crearMetodologia(nombreMet,taxativasACrear,noTaxativasACrear);
				}else{
					JOptionPane.showMessageDialog(null, "Revise los datos");
				}
				
				
			}
			
		});
		btnC.setBounds(421, 152, 141, 59);
		contentPane.add(btnC);

		

		JLabel lblNewLabel = new JLabel("Nombre Metodolog\u00EDa:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(30, 49, 135, 14);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Borrar Condici\u00F3n Seleccionada");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(lstT.getSelectedIndex()>0){
					taxativasACrear.remove(lstT.getSelectedIndex());
					lstTModel.remove(lstT.getSelectedIndex());
				}
				}
		});
		btnNewButton.setBounds(31, 341, 134, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Borrar Condici\u00F3n Seleccionada");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lstNT.getSelectedIndex()>0){
					noTaxativasACrear.remove(lstNT.getSelectedIndex());
					lstNTModel.remove(lstNT.getSelectedIndex());
				}
			}
		});
		btnNewButton_1.setBounds(240, 340, 127, 23);
		contentPane.add(btnNewButton_1);
		
		JTextPane txtpnCrearMetodologa = new JTextPane();
		txtpnCrearMetodologa.setFont(new Font("Calibri", Font.BOLD, 14));
		txtpnCrearMetodologa.setText("Crear Metodolog\u00EDa");
		txtpnCrearMetodologa.setBackground(Color.BLUE);
		txtpnCrearMetodologa.setForeground(Color.WHITE);
		txtpnCrearMetodologa.setBounds(248, 0, 119, 30);
		contentPane.add(txtpnCrearMetodologa);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaMetodologia ventMetodologia = new VentanaMetodologia();
					ventMetodologia.setVisible(true);
					dispose();
			}
		});
		btnAtrs.setBounds(516, 355, 89, 23);
		contentPane.add(btnAtrs);
		}
	}



