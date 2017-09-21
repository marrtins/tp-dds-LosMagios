package persistence;
import java.io.IOException;
import java.util.ArrayList;

import entities.Empresa;


public interface DAOEmpresa {

	public void add(Empresa empresa) throws IOException;
	public void delete(String  nombreEmpresa) throws IOException;
	public ArrayList<Empresa> getAllEmpresas() throws IOException;
	public void update(Empresa empresa) throws IOException;
	

}