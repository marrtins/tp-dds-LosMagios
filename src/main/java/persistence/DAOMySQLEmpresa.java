package persistence;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import db.EntityManagerHelper;
import entities.Empresa;

public class DAOMySQLEmpresa implements DAOEmpresa {
	EntityManager entityManager= EntityManagerHelper.getEntityManager();

	@Override
	public void add(Empresa empresa) throws IOException {
		EntityManagerHelper.beginTransaction();
		entityManager.persist(empresa);
		entityManager.flush();
		EntityManagerHelper.commit();
	}

	@Override
	public void delete(String nombreEmpresa) throws IOException {
		
		
	}

	@Override
	public ArrayList<Empresa> getAllEmpresas() throws IOException {
		
		return null;
	}

	@Override
	public void update(Empresa empresa) throws IOException {
		Empresa upd = entityManager.find(empresa.getClass(), empresa.getIdEmpresa());
		EntityManagerHelper.beginTransaction();
		entityManager.merge(upd);
		entityManager.flush();
		EntityManagerHelper.commit();
		
	}

}
