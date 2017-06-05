package modelo;



import java.util.ArrayList;

public class Metodologia {

	private String nombreMetodologia;
	static ArrayList<Condicion> condiciones = new ArrayList<Condicion>();
	static ArrayList<Indicador> indicadores = new ArrayList<Indicador>();
	
	public String getNombreMetodologia() {
		return nombreMetodologia;
	}
	public void setNombreMetodologia(String nombreMetodologia) {
		this.nombreMetodologia = nombreMetodologia;
	}
	public static ArrayList<Condicion> getCondiciones() {
		return condiciones;
	}
	public static void setCondiciones(ArrayList<Condicion> condiciones) {
		Metodologia.condiciones = condiciones;
	}
	public static ArrayList<Indicador> getIndicadores() {
		return indicadores;
	}
	public static void setIndicadores(ArrayList<Indicador> indicadores) {
		Metodologia.indicadores = indicadores;
	}
	
	
	
}
