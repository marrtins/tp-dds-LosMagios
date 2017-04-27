package clases;

import java.util.ArrayList;

public class Periodo {
	private int anio;
	static ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
	static ArrayList<Indicador> indicadores = new ArrayList<Indicador>();
	
	
	public void agregarIndicador(Indicador unIndicador){
		indicadores.add(unIndicador);
	}
	public void agregarCuenta(Cuenta unaCuenta){
		cuentas.add(unaCuenta);
	}
	public int valorCuenta(Cuenta unaCuenta){
		//TODO valorDeUnacuenta
		return 1;
	}
	
	
	
	
	//GETTERS & SETTERS

	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public static ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}
	public static void setCuentas(ArrayList<Cuenta> cuentas) {
		Periodo.cuentas = cuentas;
	}
	public static ArrayList<Indicador> getIndicadores() {
		return indicadores;
	}
	public static void setIndicadores(ArrayList<Indicador> indicadores) {
		Periodo.indicadores = indicadores;
	}
	
	
	
	
}
