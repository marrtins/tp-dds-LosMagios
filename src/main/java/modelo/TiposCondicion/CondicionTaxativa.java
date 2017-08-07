package modelo.TiposCondicion;

import java.io.IOException;

import analisisMetodologico.OperadorTaxativo;
import analizadorIndicadores.Parser;
import modelo.Empresa;
import modelo.Indicador;
import modelo.TipoCondicion;
import persistence.DataCollector;

public class CondicionTaxativa implements TipoCondicion  {

	
	
	String nombreCondicion;
	String operadorString;
	int anios;
	String indicadorString;
	
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
		Parser eval = new Parser();
		indicador= persistence.getIndicador(indicadorString);
		
		operador=eval.getOperadorT(operadorString);
		
		return operador.analizarEmpresaTaxativa(unaEmpresa,indicador,anios);
		
		
	}
}
