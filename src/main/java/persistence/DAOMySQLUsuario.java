package persistence;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import db.EntityManagerHelper;
import entities.Usuario;

public class DAOMySQLUsuario implements DAOUsuario{
	EntityManager entityManager= EntityManagerHelper.getEntityManager();

	@Override
	public ArrayList<Usuario> getAllUsuarios() throws IOException {
		Query query = entityManager.createQuery("SELECT u FROM Usuario u");
		return (ArrayList<Usuario>) query.getResultList();
	}

}
