package modelo;

import java.awt.List;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import org.junit.experimental.theories.Theories;



public class Cuenta extends Dato implements Serializable {
	
	private String nombreCuenta;
	private int valorCuenta;
	
	//private Object periodoDeCuenta;
	//private Object empresaAsociada;
	
	
	public String getNombreCuenta() {
		return nombreCuenta;
	}
	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}
	public int getValorCuenta() {
		return valorCuenta;
	}
	public void setValorCuenta(int valorCuenta) {
		this.valorCuenta = valorCuenta;
	}
	public void setear(String _nombre,int _valor){
		
		this.nombreCuenta = _nombre;
		this.valorCuenta = _valor;
	}
	
	
		
	
}
