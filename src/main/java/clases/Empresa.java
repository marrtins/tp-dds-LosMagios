package clases;

import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import clases.Periodo;
public class Empresa {
	String nombreEmpresa;
	static ArrayList<Periodo> periodos = new ArrayList<Periodo>();
	
	
		
	
	public Empresa(String nombreEmpresa,Periodo unPeriodo) {
		super();
		this.nombreEmpresa = nombreEmpresa;
		this.agregarPeriodo(unPeriodo);
	}

	
	public void visualizarGrafico(Periodo unPeriodo){
		//TODO: implementar mas adelante
	}
	
	
	
	//GETTERS & SETTERS
	public void agregarPeriodo(Periodo unPeriodo){
		periodos.add(unPeriodo);
	}
	public int caca(){
		return 1;
	}
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
