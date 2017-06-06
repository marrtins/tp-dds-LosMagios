package clases;

import java.util.ArrayList;

public class Indicador extends Dato {
	
	private String nombreIndicador;
	static ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
	private Calculo calculoIndicador;
	
	
	public String getNombreIndicador() {
		return nombreIndicador;
	}
	public void setNombreIndicador(String nombreIndicador) {
		this.nombreIndicador = nombreIndicador;
	}
	public static ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}
	public static void setCuentas(ArrayList<Cuenta> cuentas) {
		Indicador.cuentas = cuentas;
	}
	public Calculo getCalculoIndicador() {
		return calculoIndicador;
	}
	public void setCalculoIndicador(Calculo calculoIndicador) {
		this.calculoIndicador = calculoIndicador;
	}
	
	

}
