package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import entities.Cuenta;
import entities.Empresa;
import entities.Indicador;
import entities.Metodologia;
import entities.Periodo;
import entities.Usuario;
import persistence.DataCollector;

public class CuentaModel {
	
	
	private List<Cuenta> cuentas;
	private ArrayList<Empresa> empresas = new ArrayList<>();
	private ArrayList<Indicador> indicadores = new ArrayList<>();
	private ArrayList<Metodologia> metodologias = new ArrayList<>();

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
	
	try {
		indicadores=persistence.cargarIndicadores();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		metodologias=persistence.cargarMetodologias();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	//	empresas.forEach(unaEmpresa->this.addEmpresa(unaEmpresa));
				
		
		

	}
	
	public void addCuenta(Cuenta cuenta){
		this.cuentas.add(cuenta);
	}
	
	public void addEmpresa(Empresa emp){
		this.empresas.add(emp);
	}
	public ArrayList<Cuenta> getCuentasDeEmpresa(Empresa empresa){
		
		
		return empresa.getAllCuentas();
		
	}
	
	public List<Empresa> getAll(){
		this.boot();
		return this.empresas;
	}
	public ArrayList<Empresa> getArrayEmpresas(){
		this.boot();
		return this.empresas;
	}
	
	public List<Indicador> getAllIndicadores(){
		this.boot();
		return this.indicadores;
	}
	
	public List<Metodologia> getAllMetodologias(){
		
		
		this.boot();
		return this.metodologias;
	}
	public Empresa getEmpresa(String nombreEmpresa){
		int i=0;
		for(i=0; i<empresas.size(); i++){
			String n1 = empresas.get(i).getNombreEmpresa();
			String n2 = nombreEmpresa;
			if(n1.equals(n2)){
				return empresas.get(i);
			}
		}
		return empresas.get(i);
	}
	public Indicador getIndicador(String nombre){
		int i=0;
		for(i=0; i<indicadores.size(); i++){
			String n1 = indicadores.get(i).getNombreIndicador();
			String n2 = nombre;
			if(n1.equals(n2)){
				return indicadores.get(i);
			}
		}
		return indicadores.get(i);
	}
	
	public Metodologia getMetodologia(String nombre){
		int i=0;
		for(i=0; i<metodologias.size(); i++){
			String n1 = metodologias.get(i).getNombreMetodologia();
			String n2 = nombre;
			if(n1.equals(n2)){
				return metodologias.get(i);
			}
		}
		return metodologias.get(i);
	}
	
	public Periodo getPeriodoDe(Empresa empresa,String anio){
		
		
		return empresa.getPeriodoOrCreate(Integer.valueOf(anio));
	}
	
	public Cuenta get(String nombreCuenta){
		List<Cuenta> lista = this.cuentas.stream().filter(s->s.getNombreCuenta().equals(nombreCuenta)).collect(Collectors.toList());
		return lista.get(0);
	}
	
}
