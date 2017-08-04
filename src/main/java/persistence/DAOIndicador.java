package persistence;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Indicador;
import modelo.Metodologia;


public interface DAOIndicador {

	public void add(Indicador indicador) throws IOException;
	public void delete(String nombreIndicador) throws IOException;
	public ArrayList<Indicador> getAllIndicadores() throws IOException;
	public ArrayList<Metodologia> getAllMetodologias() throws IOException;

	public void update(Indicador indicador) throws IOException;
	

}