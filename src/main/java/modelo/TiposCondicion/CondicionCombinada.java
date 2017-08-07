package modelo.TiposCondicion;

import java.util.ArrayList;

import modelo.TipoCondicion;

public class CondicionCombinada implements TipoCondicion {

	
	
	String nombreCondicion;
	ArrayList<CondicionTaxativa> cTaxativas;
	ArrayList<CondicionNoTaxativa> cNoTaxativas;
	
	
	public String getNombreCondicion() {
		return nombreCondicion;
	}
	public void setNombreCondicion(String nombreCondicion) {
		this.nombreCondicion = nombreCondicion;
	}
	public ArrayList<CondicionTaxativa> getCondicionesTaxativas() {
		return cTaxativas;
	}
	public void setCondicionesTaxativas(ArrayList<CondicionTaxativa> condicionesTaxativas) {
		this.cTaxativas = condicionesTaxativas;
	}
	public ArrayList<CondicionNoTaxativa> getCondicionesNoTaxativas() {
		return cNoTaxativas;
	}
	public void setCondicionesNoTaxativas(ArrayList<CondicionNoTaxativa> condicionesNoTaxativas) {
		this.cNoTaxativas = condicionesNoTaxativas;
	}
	
	
	
}
