package persistence;

import java.io.IOException;
import java.util.ArrayList;

import modelo.Cuenta;
import modelo.Empresa;
import modelo.Indicador;

public class DataCollector {
	
	private String ruta = "C:\\Users\\martin\\Git\\3-LosMagios\\bd\\empresas.json";
	private String rutaIn = "C:\\Users\\martin\\Git\\3-LosMagios\\bd\\indicadores.json";
	private RepositorioDeEmpresas repoEmpresas;	
	private RepositorioDeIndicadores repoIndicadores;
	ArrayList<Empresa> empresas = null;
	ArrayList<Cuenta> cuentas = null;
	ArrayList<Indicador> indicadores = null;
	
	public void setRuta(String unaRuta){
		this.ruta = unaRuta;
	}
	
	public ArrayList<Empresa> cargarEmpresas(){
		DAOJsonEmpresa dao = new DAOJsonEmpresa();
		dao.setFilePath(ruta);
		this.repoEmpresas = new RepositorioDeEmpresas(dao);
		
		try {
			empresas = repoEmpresas.getAllEmpresas();
		} catch (IOException e) {
			// TODO crear EXCEPCIONES!
			
			e.printStackTrace();
		}
		
		for(Empresa unaEmpresa:empresas){
			unaEmpresa.agregarPeriodos(unaEmpresa.getPeriodos());
		}
		
		return empresas;
		
	}
	

	public void updateEmpresa(Empresa unaEmpresa){
		try {
			repoEmpresas.update(unaEmpresa);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void agregarEmpresa(Empresa unaEmpresa){
		empresas = this.cargarEmpresas();
		try {
			repoEmpresas.add(unaEmpresa);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Indicador>cargarIndicadores(){
		DAOJsonIndicador daoI = new DAOJsonIndicador();
		daoI.setFilePath(rutaIn);
		this.repoIndicadores = new RepositorioDeIndicadores(daoI);
		
		try {
			indicadores = repoIndicadores.getAllIndicadores();
		} catch (IOException e) {
			// TODO crear EXCEPCIONES!
			
			e.printStackTrace();
		}
	
	return indicadores;
	}
	
	
	
		

}
