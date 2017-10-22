package persistence;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
		Query query = entityManager.createQuery("SELECT e FROM Empresa e WHERE nombreEmpresa='" + nombreEmpresa + "'");
	    Empresa empresa= (Empresa) query.getSingleResult();
	    EntityManagerHelper.beginTransaction();
		entityManager.remove(empresa);
		entityManager.flush();
		EntityManagerHelper.commit();
		
	}

	@Override
	public ArrayList<Empresa> getAllEmpresas() throws IOException {
		Query query = entityManager.createQuery("SELECT e FROM Empresa e");
		return (ArrayList<Empresa>) query.getResultList();
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
