package persistence;

import excepciones.*;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Cuenta;
import modelo.Empresa;
import modelo.Indicador;
import parser.AnalizadorSintactico;

public class DataCollector {
	
	private String rutaEmpresas="C:\\Users\\martin\\Git\\3-LosMagios\\bd\\empresas.json";
	private String rutaIndicadores="C:\\Users\\martin\\Git\\3-LosMagios\\bd\\indicadores.json";
	private RepositorioDeEmpresas repoEmpresas;	
	private RepositorioDeIndicadores repoIndicadores;
	ArrayList<Empresa> empresas = null;
	ArrayList<Cuenta> cuentas = null;
	ArrayList<Indicador> indicadores = null;
	
	
	
	public ArrayList<Empresa> cargarEmpresas() throws IOException{
		DAOJsonEmpresa dao = new DAOJsonEmpresa();
		dao.setFilePath(rutaEmpresas);
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
		DAOJsonIndicador daoI = new DAOJsonIndicador();
		daoI.setFilePath(rutaIndicadores);
		this.repoIndicadores = new RepositorioDeIndicadores(daoI);
		
		try {
			indicadores = repoIndicadores.getAllIndicadores();
		} catch (ErrorCargaDatos e) {
			throw e;
		}
	
	return indicadores;
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
	
	
	public Boolean crearIndicador(String nombre, String formula){
		AnalizadorSintactico sintax = new AnalizadorSintactico();
		if(sintax.indicadorValido(formula)){
			Indicador indicador = new Indicador();
			indicador.setNombreIndicador(nombre.toUpperCase());
			indicador.setCalculoIndicador(formula.toUpperCase());
			try {
				this.agregarIndicador(indicador);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return true;
		}
		else{
			Exception e = new Exception();
			try {
				throw new ErrorLexico(e);
			} catch (ErrorLexico e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
	}
	
	
	
		

}
