package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import persistence.DataCollector;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import modelo.Indicador;

import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

public class VentanaCrearCTaxativa extends JFrame {

	private JPanel contentPane;
	public String[]nombreOperadores={"Creciente","Consistente","Antiguedad mayor que","Indicador mayor que","Indicador menor que"};
	public String[]operador={"crescent","consistent","antique","higherThan","lowerThan"};
	private JTextField txtVC;
	public ArrayList<Indicador>indicadores;
	String operadorSeleccionado="";
	int i=0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearCTaxativa frame = new VentanaCrearCTaxativa();
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
	public VentanaCrearCTaxativa() {
		
		
		
DataCollector persistence = new DataCollector();
		

		try {
			
			indicadores = persistence.cargarIndicadores();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo Operador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 57, 185, 180);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		
		JComboBox cboIndicador = new JComboBox();
		cboIndicador.setBounds(218, 70, 195, 20);
		contentPane.add(cboIndicador);
		
		indicadores.forEach(unIndicador->cboIndicador.addItem(unIndicador.getNombreIndicador()));

		
		JLabel lblIndicadorAComparar = new JLabel("Indicador A Comparar");
		lblIndicadorAComparar.setBounds(256, 43, 121, 17);
		contentPane.add(lblIndicadorAComparar);
		
		JFormattedTextField txtAnios = new JFormattedTextField();
		txtAnios.setBounds(327, 166, 84, 20);
		contentPane.add(txtAnios);
		
		JLabel lblAos = new JLabel("A\u00F1os:");
		lblAos.setBounds(271, 169, 46, 14);
		contentPane.add(lblAos);
		
		JButton btnCrearCondicion = new JButton("Crear Condicion");
		btnCrearCondicion.setBounds(297, 230, 127, 54);
		contentPane.add(btnCrearCondicion);
		
		txtVC = new JTextField();
		txtVC.setBounds(325, 125, 86, 20);
		contentPane.add(txtVC);
		txtVC.setColumns(10);
		
		JLabel lblValorComparacion = new JLabel("Valor Comparacion:");
		lblValorComparacion.setBounds(218, 128, 108, 14);
		contentPane.add(lblValorComparacion);
		ButtonGroup group = new ButtonGroup();
		
		for(String unOperador:nombreOperadores){
			JRadioButton btn=new JRadioButton(unOperador);
			panel.add(btn);
			btn.setSelected(true);
			group.add(btn);

			btn.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e){
					if(!btn.isSelected()){
						operadorSeleccionado=operador[i];
						if(i==0 || i==1){
							txtVC.setText("asd");
							txtVC.setEditable(false);
						}
					}
				}
			});

		}

		
		
	}
}
