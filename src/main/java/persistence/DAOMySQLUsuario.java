package persistence;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import db.EntityManagerHelper;
import entities.Usuario;

public class DAOMySQLUsuario implements DAOUsuario{
	EntityManager entityManager= EntityManagerHelper.getEntityManager();

	@Override
	public ArrayList<Usuario> getAllUsuarios() throws IOException {
		
		return null;
	}

}
