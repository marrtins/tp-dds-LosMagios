package modelo.TiposCondicion;

import java.io.IOException;
import java.util.ArrayList;

import analisisMetodologico.OperadorNoTaxativo;
import analisisMetodologico.OperadoresFactory;
import analizadorIndicadores.Parser;
import modelo.Empresa;
import modelo.Indicador;
import modelo.TipoCondicion;
import persistence.DataCollector;

public class CondicionNoTaxativa implements TipoCondicion {

	
	
	public String getNombreCondicion() {
		return nombreCondicion;
	}


	public void setNombreCondicion(String nombreCondicion) {
		this.nombreCondicion = nombreCondicion;
	}


	public String getOperadorString() {
		return operadorString;
	}


	public CondicionNoTaxativa(String nombreCondicion, String operadorString, int anios, int peso,
			String indicadorString) {
		super();
		this.nombreCondicion = nombreCondicion;
		this.operadorString = operadorString;
		this.anios = anios;
		this.peso = peso;
		this.indicadorString = indicadorString;
	}


	public void setOperadorString(String operadorString) {
		this.operadorString = operadorString;
	}


	public int getAnios() {
		return anios;
	}


	public void setAnios(int anios) {
		this.anios = anios;
	}


	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		this.peso = peso;
	}


	public String getIndicadorString() {
		return indicadorString;
	}


	public void setIndicadorString(String indicadorString) {
		this.indicadorString = indicadorString;
	}


	public OperadorNoTaxativo getOperador() {
		return operador;
	}


	public void setOperador(OperadorNoTaxativo operador) {
		this.operador = operador;
	}


	String nombreCondicion;
	String operadorString;
	int anios;
	int peso;
	String indicadorString;
	Indicador unIndicador = null;
	OperadorNoTaxativo operador;
	
	
	public int aplicarCondicion(Empresa empresa1, Empresa empresa2){
		
		DataCollector persistence=new DataCollector();
		OperadoresFactory creador=new OperadoresFactory();
		
		try {
			unIndicador = persistence.getIndicador(indicadorString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		operador=creador.crearOperadorNoTaxativo(operadorString);
		
		
		return operador.aplicarPesos(empresa1, empresa2,unIndicador, anios,peso);
		
		
		
		
	}
	
	

	
}
