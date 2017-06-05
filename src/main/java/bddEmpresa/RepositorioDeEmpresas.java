package bddEmpresa;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Empresa;


public class RepositorioDeEmpresas {

	private DAOEmpresa daoEmpresa;

	public RepositorioDeEmpresas(DAOEmpresa dao){
		this.daoEmpresa = dao;
	}

	public void add(Empresa empresa) throws IOException{
		this.daoEmpresa.add(empresa);
	}

	public void delete(Empresa empresa) throws IOException{
		this.daoEmpresa.delete(empresa);
	}

	public ArrayList<Empresa> getAllEmpresas() throws IOException{
		return this.daoEmpresa.getAllEmpresas();
	}


	
	public void update(Empresa empresa) throws IOException{
		this.daoEmpresa.update(empresa);
	}
}