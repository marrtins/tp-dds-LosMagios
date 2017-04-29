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
	private int periodoDeCuenta;
	private String empresaAsociada;
	//private Periodo periodoDeCuenta;
	//private Empresa empresaAsociada;
	
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
	
	public List leerCuentasDeJson() throws IOException{
		ArrayList<Cuenta> cuentas;
		RepositorioDeCuentas repoCuentas;
		DAOJsonCuenta dao = new DAOJsonCuenta();
		dao.setFilePath("C:\\Users\\martin\\Git\\3-LosMagios\\bd\\cuentas.json");
		//this.repoCuentas = new RepositorioDeCuentas(dao);
		repoCuentas = new RepositorioDeCuentas(dao);
		cuentas = repoCuentas.getAllCuentas();
		return cuentas;
		
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
