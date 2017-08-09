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

	
	
	String nombreCondicion;
	String operadorString;
	int anios;
	int peso;
	String indicadorString;
	
	OperadorNoTaxativo operador;
	
	
	public int aplicarCondicion(Empresa empresa1, Empresa empresa2){
		
		DataCollector persistence=new DataCollector();
		OperadoresFactory creador=new OperadoresFactory();
		Indicador unIndicador = null;
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
