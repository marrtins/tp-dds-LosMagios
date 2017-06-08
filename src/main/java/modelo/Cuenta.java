package modelo;

import java.awt.List;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import org.junit.experimental.theories.Theories;



public class Cuenta extends Dato implements Serializable {
	
	private int idCuenta;
	private String nombreCuenta;
	private int valorCuenta;
	private int periodoCuenta;
	private Empresa empresaAsociada;
	//private Object periodoDeCuenta;
	//private Object empresaAsociada;
	
	public int getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}
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
	public int getPeriodoDeCuenta() {
		return periodoCuenta;
	}
	public void setPeriodoDeCuenta(int periodoDeCuenta) {
		this.periodoCuenta = periodoDeCuenta;
	}
	public Empresa getEmpresaAsociada() {
		return empresaAsociada;
	}
	public void setEmpresaAsociada(Empresa empresaAsociada) {
		this.empresaAsociada = empresaAsociada;
	}
	public void setear(int _id,String _nombre,int _valor,int _periodo){
		this.idCuenta = _id;
		this.nombreCuenta = _nombre;
		this.valorCuenta = _valor;
		this.periodoCuenta = _periodo;
	}
	
		
	
}
