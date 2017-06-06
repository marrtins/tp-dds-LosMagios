package bddCuentas;

import java.io.IOException;
import java.util.ArrayList;

import clases.Cuenta;

public interface DAOCuenta {
	
	public void add(Cuenta cuenta) throws IOException;
	public void delete(Cuenta cuenta) throws IOException;
	public ArrayList<Cuenta> getAllCuentas() throws IOException;
	public void update(Cuenta cuenta) throws IOException; 

}
