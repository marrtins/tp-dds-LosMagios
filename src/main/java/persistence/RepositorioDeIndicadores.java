package persistence;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Indicador;
import modelo.Metodologia;


public class RepositorioDeIndicadores {

	private DAOIndicador daoIndicador;

	public RepositorioDeIndicadores(DAOIndicador dao){
		this.daoIndicador = dao;
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
	
	
	public void update(Indicador indicador) throws IOException{
		this.daoIndicador.update(indicador);
	}
	
}