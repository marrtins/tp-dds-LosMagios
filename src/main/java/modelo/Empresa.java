package modelo;

import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import modelo.Periodo;

import java.io.Serializable;

public class Empresa implements Serializable {

	private int idEmpresa;
	private String nombreEmpresa;
	private ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
	
	public Empresa(int _id,String _nombre) {
		super();
		this.idEmpresa = _id;
		this.nombreEmpresa = _nombre;
		this.cuentas = cuentas;
	}
	
	public int getId() {
		return idEmpresa;
	}

	public void setId(int id) {
		this.idEmpresa = id;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombre(String nombre) {
		this.nombreEmpresa = nombre;
	}

	public ArrayList<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(ArrayList<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public void agregarCuenta(Cuenta nuevaCuenta){
		this.cuentas.add(nuevaCuenta);
	}
	public Cuenta getCuenta(int indice){
		return cuentas.get(indice);
	}
	

}








