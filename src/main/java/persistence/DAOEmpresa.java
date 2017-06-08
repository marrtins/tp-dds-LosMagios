package persistence;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Cuenta;
import modelo.Empresa;


public interface DAOEmpresa {

	public void add(Empresa empresa) throws IOException;
	public void delete(Empresa empresa) throws IOException;
	public ArrayList<Empresa> getAllEmpresas() throws IOException;
	public void update(Empresa empresa) throws IOException;
	

}