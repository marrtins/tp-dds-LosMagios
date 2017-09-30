package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import entities.Cuenta;
import entities.Empresa;
import entities.Usuario;
import persistence.DataCollector;

public class CuentaModel {
	
	
	private List<Cuenta> cuentas;
	private ArrayList<Empresa> empresas = new ArrayList<>();
	private static CuentaModel instance = null;
	
	
	
	public static CuentaModel getInstance(){
		if(instance==null){
			instance = new CuentaModel();
		}
		return instance;
	}
	
	
	private CuentaModel() {
		this.cuentas = new LinkedList<>();
		this.boot();
	}
	
public void boot(){
		
		
	
	DataCollector persistence = new DataCollector();
	
	try {
		empresas = persistence.cargarEmpresas();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
		
	//	empresas.forEach(unaEmpresa->this.addEmpresa(unaEmpresa));
				
		
		

	}
	
	public void addCuenta(Cuenta cuenta){
		this.cuentas.add(cuenta);
	}
	public void addEmpresa(Empresa emp){
		this.empresas.add(emp);
	}
	
	public List<Empresa> getAll(){
		return this.empresas;
	}
	
	public Cuenta get(String nombreCuenta){
		List<Cuenta> lista = this.cuentas.stream().filter(s->s.getNombreCuenta().equals(nombreCuenta)).collect(Collectors.toList());
		return lista.get(0);
	}
	
}
