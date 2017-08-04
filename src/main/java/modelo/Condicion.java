package modelo;

import java.io.IOException;
import java.util.ArrayList;

import analizadorIndicadores.AnalizadorLexico;
import analizadorIndicadores.Parser;
import persistence.DataCollector;

public class Condicion{
	
	public String formatoCondicion;
	public TipoCondicion tipoCondicion;
	DataCollector persistence = new DataCollector();
	public Condicion getTipoCondicion() {
		return tipoCondicion;
	}
	public void setTipoCondicion() {
		Parser type = new Parser();
		
		
		tipoCondicion = type.setter(formatoCondicion);
	}
	

		
	public String getFormatoCondicion() {
		return formatoCondicion;
	}

	public void setFormatoCondicion(String formatoCondicion) {
		this.formatoCondicion = formatoCondicion;
	}

	public Condicion(String formatoCondicion) {
		super();
		this.formatoCondicion = formatoCondicion;
	}
	public String condicionFormateada(){
		AnalizadorLexico eval=new AnalizadorLexico();
		return eval.getMethS(formatoCondicion);
		
		
	}
	
	public Indicador getIndicador(String nombreIndicador) throws IOException{
		return persistence.getIndicador(nombreIndicador);
	}
	
	public ArrayList<Empresa> aplicar(ArrayList<Empresa> empresas) throws IOException{
		return tipoCondicion.aplicar(empresas);
	}
	
	
	
	

}
