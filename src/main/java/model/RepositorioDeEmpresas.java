package model;
import java.io.IOException;
import java.util.ArrayList;

import entities.Empresa;
import persistence.DAOEmpresa;


public class RepositorioDeEmpresas {

	private DAOEmpresa daoEmpresa;
	private RepositorioDeEmpresas instance = null;
	
	public RepositorioDeEmpresas(DAOEmpresa dao){
		this.daoEmpresa = dao;
	}
	
	public RepositorioDeEmpresas getInstance(DAOEmpresa dao){
		if(instance==null){
			instance = new RepositorioDeEmpresas(dao);
		}
		return instance;
	}
	

	public void add(Empresa empresa) throws IOException{
		this.daoEmpresa.add(empresa);
	}

	public void delete(String nombreEmpresa) throws IOException{
		this.daoEmpresa.delete(nombreEmpresa);
	}

	public ArrayList<Empresa> getAllEmpresas() throws IOException{
		return this.daoEmpresa.getAllEmpresas();
	}
	
	public void update(Empresa empresa) throws IOException{
		this.daoEmpresa.update(empresa);
	}
	
}