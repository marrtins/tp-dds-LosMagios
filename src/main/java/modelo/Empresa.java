package modelo;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import modelo.Periodo;

import java.io.Serializable;

public class Empresa implements Serializable {

	
	private String nombreEmpresa;
	private ArrayList<Periodo> periodos = new ArrayList<Periodo>();
	
	public Empresa(String _nombre) {
		super();
		this.nombreEmpresa = _nombre;
		this.periodos = periodos;
		
	}
	
	

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombre(String nombre) {
		this.nombreEmpresa = nombre;
	}

	public ArrayList<Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(ArrayList<Periodo> periodos) {
		this.periodos = periodos;
	}
	
	public ArrayList<Cuenta> getCuentasDePeriodo(Periodo unPeriodo){
		
		if(!(this.periodos.contains(unPeriodo))) {
			this.agregarPeriodo(unPeriodo);
		}
		return unPeriodo.getCuentas();
	}
	
	public void agregarCuentaEnPeriodo(Cuenta unaCuenta, Periodo unPeriodo){
		
			unPeriodo.agregarCuenta(unaCuenta);
		
	}
	
	public void agregarPeriodos(ArrayList<Periodo> periodos){
		for(Periodo unPeriodo:periodos){
			unPeriodo.agregarCuentas(unPeriodo.getCuentas());
		}
		
	}
	
	public boolean tienePeriodo(int unAnio){
		return periodos.stream().anyMatch(periodo-> periodo.getAnio() == (new Periodo(unAnio)).getAnio());
	}
	public void agregarPeriodo(Periodo unPeriodo){
		periodos.add(unPeriodo);
		unPeriodo.setCuentas(new ArrayList<Cuenta>());
	}
	public Cuenta getCuentaDePeriodo(Periodo unPeriodo,String nombreCuenta){
		return unPeriodo.getCuenta(nombreCuenta);
	}
	public Periodo getPeriodoOrCreate(int unAnio){
		
		if(!this.tienePeriodo(unAnio)) this.agregarPeriodo(new Periodo(unAnio));
		
		return periodos.stream().filter(unPeriodo->unPeriodo.getAnio() == unAnio).findFirst().orElse(null);
	
	}
	
	

	
	

}








