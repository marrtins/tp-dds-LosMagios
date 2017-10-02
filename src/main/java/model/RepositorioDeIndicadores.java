package model;
import java.io.IOException;
import java.util.ArrayList;

import entities.Indicador;
import entities.Metodologia;
import entities.Usuario;
import persistence.DAOEmpresa;
import persistence.DAOIndicador;


public class RepositorioDeIndicadores {

	private DAOIndicador daoIndicador;
	private static RepositorioDeIndicadores instance = null;
	

	public RepositorioDeIndicadores(DAOIndicador dao){
		this.daoIndicador = dao;
	}

	
	public RepositorioDeIndicadores getInstance(DAOIndicador dao){
		if(instance==null){
			instance = new RepositorioDeIndicadores(dao);
		}
		return instance;
	}
	



	public void add(Indicador indicador) throws IOException{
		this.daoIndicador.add(indicador);
	}
	public void addMetodologia(Metodologia unaM) throws IOException{
		this.daoIndicador.addMetodologia(unaM);
	}

	public void delete(String nombre) throws IOException{
		this.daoIndicador.delete(nombre);
	}

	public ArrayList<Indicador> getAllIndicadores() throws IOException{
		return this.daoIndicador.getAllIndicadores();
	}
	public ArrayList<Metodologia> getAllMetodologias() throws IOException{
		return this.daoIndicador.getAllMetodologias();
	}
	public ArrayList<Usuario> getAllUsuarios() throws IOException{
		return this.daoIndicador.getAllUsuarios();
	}
	
	
	public void update(Indicador indicador) throws IOException{
		this.daoIndicador.update(indicador);
	}
	
}