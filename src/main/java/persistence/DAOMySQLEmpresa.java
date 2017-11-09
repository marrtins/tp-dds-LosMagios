package persistence;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import db.EntityManagerHelper;
import entities.Empresa;
import entities.Metodologia;

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
//		Query query = entityManager.createQuery("SELECT e FROM Empresa e");
//		return (ArrayList<Empresa>) query.getResultList();
		ArrayList<Empresa> empresas= new ArrayList<Empresa>();
		Empresa empresa= new Empresa();
		int i = 1;
		while((empresa = entityManager.find(empresa.getClass(),i))!=null){
			empresas.add(empresa);
			i++;
		}
		return empresas;
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
