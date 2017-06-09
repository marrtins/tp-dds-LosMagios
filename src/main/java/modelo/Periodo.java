package modelo;

import java.util.ArrayList;
import java.util.List;

import modelo.Cuenta;

public class Periodo {
	private int anio;
	private ArrayList<Cuenta> cuentas;

	public Periodo(int unAnio) {
		anio = unAnio;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(ArrayList<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
	public void agregarCuenta(Cuenta unaCuenta){
		cuentas.add(unaCuenta);
	}
	public void setearCuentas(ArrayList<Cuenta>cuentas){
		for (int i = 0; i < cuentas.size(); i++) {
			this.agregarCuenta(cuentas.get(i));
		}
	}

	public Cuenta getCuenta(String nombreCuenta){
		for(int i=0;i<cuentas.size();i++){
			if(cuentas.get(i).getNombreCuenta() == nombreCuenta){
				return cuentas.get(i);
			}
			
		}
		return null;
		
}
	
	
	public void agregarCuentas(ArrayList<Cuenta> cuentas) {
		this.setCuentas(cuentas);
	}

/*	public void agreg2arCuenta(Cuenta cuenta) {
		if (!existeCuenta(cuenta))
			cuentas.add(cuenta);
		else
			this.buscarCuenta(cuenta).setValor(cuenta.getValor());
	}*/
	
	
	
	
}