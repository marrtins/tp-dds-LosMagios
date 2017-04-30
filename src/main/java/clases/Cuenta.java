package clases;

import java.awt.List;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import org.junit.experimental.theories.Theories;

import bddCuentas.DAOJsonCuenta;
import bddCuentas.RepositorioDeCuentas;

public class Cuenta extends Dato implements Serializable {
	
	private int idCuenta;
	private String nombreCuenta;
	private int valorCuenta;
	//private int periodoDeCuenta;
	//private String empresaAsociada;
	//private Object periodoDeCuenta;
	//private Object empresaAsociada;
	
	public int getIdCuenta() {
		return idCuenta;
	}
	public Cuenta(int _id,String _nombre,int _valor) {
		super();
		this.idCuenta = _id;
		this.nombreCuenta = _nombre;
		this.valorCuenta = _valor;
		//this.empresaAsociada = _empresa;
		//this.periodoDeCuenta=_periodo;
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
	
	
	
	
	
	
	/*public Periodo getPeriodoDeCuenta() {
		return periodoDeCuenta;
	}
	public void setPeriodoDeCuenta(Periodo periodoDeCuenta) {
		this.periodoDeCuenta = periodoDeCuenta;
	}
	public Empresa getEmpresaAsociada() {
		return empresaAsociada;
	}
	public void setEmpresaAsociada(Empresa empresaAsociada) {
		this.empresaAsociada = empresaAsociada;
	}*/
	
	
	
	
	
	
}
