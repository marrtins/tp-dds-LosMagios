package bddEmpresa;
import java.io.IOException;
import java.util.ArrayList;

import clases.Empresa;


public interface DAOEmpresa {

	public void add(Empresa empresa) throws IOException;
	public void delete(Empresa empresa) throws IOException;
	public ArrayList<Empresa> getAllEmpresas() throws IOException;
	public void update(Empresa empresa) throws IOException;

}