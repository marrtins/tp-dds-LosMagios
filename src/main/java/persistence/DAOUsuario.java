package persistence;

import java.io.IOException;
import java.util.ArrayList;

import entities.Empresa;
import entities.Usuario;

public interface DAOUsuario {

	public ArrayList<Usuario> getAllUsuarios() throws IOException;
	
	

}