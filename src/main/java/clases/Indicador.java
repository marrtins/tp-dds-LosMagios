package clases;
import clases.Periodo;

import java.util.ArrayList;

public class Indicador extends Dato {
	
	static ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
	private Calculo calculoAsociado;
	
	//CONSTRUCTOR
	public Indicador(Calculo calculoAsociado, Cuenta unaCuenta,Periodo unPeriodo,String unNombre) {
		super();
		this.calculoAsociado = calculoAsociado;
		this.agregarCuenta(unaCuenta);
		this.setNombre(unNombre);
		unPeriodo.agregarIndicador(this);
	}
	//FIN CONSTRUCTOR
	
	public void agregarCuenta(Cuenta unaCuenta){
		cuentas.add(unaCuenta);
	}
	
	
	//GETTERS & SETTERS
	public static ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}
	
	public static void setCuentas(ArrayList<Cuenta> cuentas) {
		Indicador.cuentas = cuentas;
	}
	public Calculo getCalculoAsociado() {
		return calculoAsociado;
	}
	public void setCalculoAsociado(Calculo calculoAsociado) {
		this.calculoAsociado = calculoAsociado;
	}
    

}
