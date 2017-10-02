package model;

import java.io.IOException;
import java.util.ArrayList;

import entities.Metodologia;
import entities.Usuario;
import persistence.DAOIndicador;
import persistence.DAOUsuario;

public class RepositorioDeUsuarios {
	private DAOUsuario daoUsuario;
	
	
	
	public RepositorioDeUsuarios(DAOUsuario dao){
		this.daoUsuario = dao;
	}
	
	public ArrayList<Usuario> getAllUsuarios() throws IOException{
		return this.daoUsuario.getAllUsuarios();
	}
}
