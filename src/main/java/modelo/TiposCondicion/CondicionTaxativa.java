package modelo.TiposCondicion;

import java.io.IOException;

import analisisMetodologico.OperadorTaxativo;
import analisisMetodologico.OperadoresFactory;
import modelo.Empresa;
import modelo.Indicador;
import modelo.TipoCondicion;
import persistence.DataCollector;

public class CondicionTaxativa implements TipoCondicion  {

	
	
	String nombreCondicion;
	String operadorString;
	int anios;
	String indicadorString;
	Double valorComparacion;
	
	OperadorTaxativo operador;
	Indicador indicador;
	
	
	public String getNombreCondicion() {
		return nombreCondicion;
	}
	public void setNombreCondicion(String nombreCondicion) {
		this.nombreCondicion = nombreCondicion;
	}
	public OperadorTaxativo getOperador() {
		return operador;
	}
	public void setOperador(OperadorTaxativo operador) {
		this.operador = operador;
	}
	public int getAnios() {
		return anios;
	}
	public void setAnios(int anios) {
		this.anios = anios;
	}
	public Indicador getIndicador() {
		return indicador;
	}
	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
	}

	
	public Boolean empresaCalifica(Empresa unaEmpresa) throws IOException{
		
		DataCollector persistence=new DataCollector();
		OperadoresFactory creador = new OperadoresFactory();
		
		indicador= persistence.getIndicador(indicadorString);
		operador=creador.crearOperadorTaxativo(operadorString);
		
		
		return operador.analizarEmpresaTaxativamente(unaEmpresa,indicador,anios,valorComparacion);
		
		
	}
}
