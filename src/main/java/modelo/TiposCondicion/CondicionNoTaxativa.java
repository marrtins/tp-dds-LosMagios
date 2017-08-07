package modelo.TiposCondicion;

import java.io.IOException;
import java.util.ArrayList;

import analisisMetodologico.OperadorNoTaxativo;
import analizadorIndicadores.Parser;
import modelo.Empresa;
import modelo.Indicador;
import modelo.TipoCondicion;
import persistence.DataCollector;

public class CondicionNoTaxativa implements TipoCondicion {

	
	
	String nombreCondicion;
	String operadorString;
	int anios;
	int peso;
	String indicadorString;
	
	OperadorNoTaxativo operador;
	
	
	public int aplicarCondicion(Empresa empresa1, Empresa empresa2) throws IOException{
		
		DataCollector persistence=new DataCollector();
		Parser eval = new Parser();
		Indicador unIndicador = persistence.getIndicador(indicadorString);
		
		operador=eval.getOperadorNT(operadorString);
		
		
		return operador.aplicarPesos(empresa1, empresa2,unIndicador, anios,peso);
		
		
		
		
	}
	
	

	
}
