package persistence;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Indicador;


public class RepositorioDeIndicadores {

	private DAOIndicador daoIndicador;

	public RepositorioDeIndicadores(DAOIndicador dao){
		this.daoIndicador = dao;
	}

	public void add(Indicador indicador) throws IOException{
		this.daoIndicador.add(indicador);
	}

	public void delete(Indicador indicador) throws IOException{
		this.daoIndicador.delete(indicador);
	}

	public ArrayList<Indicador> getAllIndicadores() throws IOException{
		return this.daoIndicador.getAllIndicadores();
	}
	
	public void update(Indicador indicador) throws IOException{
		this.daoIndicador.update(indicador);
	}
	
}