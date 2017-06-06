package bddPeriodos;

import java.io.IOException;
import java.util.ArrayList;

import clases.Periodo;

public interface DAOPeriodo {
	
	public void add(Periodo periodo) throws IOException;
	public void delete(Periodo periodo) throws IOException;
	public ArrayList<Periodo> getAllPeriodos() throws IOException;
	public void update(Periodo periodo) throws IOException; 

}
