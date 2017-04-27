package clases;

import java.util.ArrayList;
import clases.Periodo;
public class Empresa {
	String nombreEmpresa;
	static ArrayList<Periodo> periodos = new ArrayList<Periodo>();
	
	
	public void visualizarGrafico(Periodo unPeriodo){
		//TODO: implementar mas adelante
	}
	
	
	
	//GETTERS & SETTERS

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public static ArrayList<Periodo> getPeriodos() {
		return periodos;
	}
	public static void setPeriodos(ArrayList<Periodo> periodos) {
		Empresa.periodos = periodos;
	}

	


	
}
