package bddCuentas;

import java.io.IOException;
import java.util.ArrayList;

import clases.Cuenta;

public class RepositorioDeCuentas {
	
	private DAOCuenta daoCuenta;
	
	public RepositorioDeCuentas(DAOCuenta dao){
		this.daoCuenta = dao;
	}
	
	public void add(Cuenta cuenta) throws IOException{
		this.daoCuenta.add(cuenta);
	}
	
	public void delete(Cuenta cuenta) throws IOException{
		this.daoCuenta.delete(cuenta);
	}
	
	public ArrayList<Cuenta> getAllCuentas() throws IOException{
		return this.daoCuenta.getAllCuentas();
	}
	
	public void update(Cuenta cuenta) throws IOException{
		this.daoCuenta.update(cuenta);
	}
	
}
