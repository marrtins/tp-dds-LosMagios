package persistence;

import excepciones.*;
import model.RepositorioDeEmpresas;
import model.RepositorioDeIndicadores;
import model.RepositorioDeUsuarios;

import java.io.IOException;
import java.util.ArrayList;

import analizadorIndicadores.AnalizadorSintactico;
import entities.Cuenta;
import entities.Empresa;
import entities.Indicador;
import entities.Metodologia;
import entities.Usuario;
import entities.TiposCondicion.CondicionNoTaxativa;
import entities.TiposCondicion.CondicionTaxativa;



public class DataCollector {
	
	private String rutaEmpresas="C:\\Home\\workspace\\3-LosMagios\\bd\\empresas.json";
	private String rutaIndicadores="C:\\Users\\martin\\Git\\3-LosMagios\\bd\\indicadores.json";
	private String rutaUsuarios="C:\\Users\\martin\\Git\\3-LosMagios\\bd\\usuarios.json";
	private String rutaMetodologias="C:\\Users\\martin\\Git\\3-LosMagios\\bd\\metodologias.json";
	private RepositorioDeEmpresas repoEmpresas;	
	private RepositorioDeIndicadores repoIndicadores;
	private RepositorioDeUsuarios repoUsuarios;
	ArrayList<Empresa> empresas = null;
	ArrayList<Cuenta> cuentas = null;
	ArrayList<Indicador> indicadores = null;
	ArrayList<Metodologia> metodologias = null;
	ArrayList<Usuario> usuarios = null;
	
	
	
	public ArrayList<Empresa> cargarEmpresas() throws IOException{
		//DAOJsonEmpresa dao = new DAOJsonEmpresa();
		DAOMySQLEmpresa dao = new DAOMySQLEmpresa();
		//dao.setFilePath(rutaEmpresas);
		this.repoEmpresas = new RepositorioDeEmpresas(dao);
		
		try {
			empresas = repoEmpresas.getAllEmpresas();
		} catch (ErrorCargaDatos e) {
			throw e;
		}
		
		for(Empresa unaEmpresa:empresas){
			unaEmpresa.agregarPeriodos(unaEmpresa.getPeriodos());
		}
		
		return empresas;
		
	}
	

	public String getRutaIndicadores() {
		return rutaIndicadores;
	}
	
	public Indicador getIndicador(String nombreIndicador) throws IOException{
		indicadores = this.cargarIndicadores();
		return indicadores.stream().filter(unIndicador->unIndicador.getNombreIndicador().equals(nombreIndicador)).findFirst().orElse(null);
	}
	

	public void updateEmpresa(Empresa unaEmpresa) throws IOException{
		try {
			repoEmpresas.update(unaEmpresa);
		} catch (ErrorEscrituraDatos e) {
			throw e;
		}
	}
	public void agregarEmpresa(Empresa unaEmpresa) throws IOException{
		empresas = this.cargarEmpresas();
		try {
			repoEmpresas.add(unaEmpresa);
		} catch (ErrorEscrituraDatos e) {
			throw e;
		}
	}
	
	public void borrarEmpresa(Empresa unaEmpresa) throws IOException{
		try {
			repoEmpresas.delete(unaEmpresa.getNombreEmpresa());
		} catch (ErrorBorrarDatos e) {
			throw e;
		}
	}
	
	public ArrayList<Indicador>cargarIndicadores() throws IOException{
		//DAOJsonIndicador daoI = new DAOJsonIndicador();
		DAOMySQLIndicador daoI = new DAOMySQLIndicador();
		//daoI.setFilePath(rutaIndicadores);
		this.repoIndicadores = new RepositorioDeIndicadores(daoI);
		
		indicadores = repoIndicadores.getAllIndicadores();
		
		
	
	return indicadores;
	}
	public ArrayList<Usuario>cargarUsuarios() throws IOException{
		//DAOJsonIndicador daoI = new DAOJsonIndicador();
		//daoI.setFilePath(rutaUsuarios);
		DAOMySQLIndicador daoI = new DAOMySQLIndicador();
		this.repoIndicadores = new RepositorioDeIndicadores(daoI);
		
		try {
			usuarios = repoIndicadores.getAllUsuarios();
		} catch (ErrorCargaDatos e) {
			throw e;
		}
		
	
	return usuarios;
	}
	
	
	public ArrayList<Metodologia>cargarMetodologias() throws IOException{
		//DAOJsonIndicador daoI = new DAOJsonIndicador();
		//daoI.setFilePath(rutaMetodologias);
		DAOMySQLIndicador daoI = new DAOMySQLIndicador();
		this.repoIndicadores = new RepositorioDeIndicadores(daoI);
		
		try {
			metodologias = repoIndicadores.getAllMetodologias();
		} catch (ErrorCargaDatos e) {
			throw e;
		}
		
	/*	for(Metodologia unaMetodologia:metodologias){
			unaMetodologia.cargarMetodologia();
		}
*/
	return metodologias;
	}
	
	public Boolean sePuedeCrearMetodologia(String nombreMet,ArrayList<CondicionTaxativa> cTax,ArrayList<CondicionNoTaxativa> cNTax){
		if(nombreMet.isEmpty())return false;
		return true;
	}
	
	public void agregarMetodologia(Metodologia unaMetodologia) throws IOException{
		metodologias=this.cargarMetodologias();
		try {
			repoIndicadores.addMetodologia(unaMetodologia);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void agregarIndicador(Indicador unIndicador) throws IOException{
		indicadores = this.cargarIndicadores();
		try {
			repoIndicadores.add(unIndicador);
		} catch (ErrorEscrituraDatos e) {
			throw e;
		}
	}
	public void borrarIndicador(Indicador unIndicador){
		try {
			repoIndicadores.delete(unIndicador.getNombreIndicador());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Boolean crearIndicador(String nombre, String formula,String usuario){
		AnalizadorSintactico sintax = new AnalizadorSintactico();
		if(sintax.indicadorValido(formula)){
			Indicador indicador = new Indicador();
			indicador.setNombreIndicador(nombre.toUpperCase());
			indicador.setCalculoIndicador(formula.toUpperCase());
			indicador.setUsuario(usuario);
			try {
				this.agregarIndicador(indicador);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return true;
		}
		else{
			
			return false;
		}
	}
	
	public void crearMetodologia(String nombreMet,ArrayList<CondicionTaxativa> cTax,ArrayList<CondicionNoTaxativa> cNTax,String nombreUsuario){
		Metodologia nuevaMet = new Metodologia();
		nuevaMet.setNombreMetodologia(nombreMet);
		nuevaMet.setcTaxativas(cTax);
		nuevaMet.setcNoTaxativas(cNTax);
		nuevaMet.setUsuario(nombreUsuario);
		try {
			this.agregarMetodologia(nuevaMet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
		

}
