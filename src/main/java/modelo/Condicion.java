package modelo;

import analizadorIndicadores.AnalizadorLexico;

public class Condicion {
	
	public String formatoCondicion;

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
	
	

}
