package persistence;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import db.EntityManagerHelper;
import entities.Indicador;
import entities.Metodologia;
import entities.Usuario;

public class DAOMySQLIndicador implements DAOIndicador{

	EntityManager entityManager= EntityManagerHelper.getEntityManager();
	
	@Override
	public void add(Indicador indicador) throws IOException {
		EntityManagerHelper.beginTransaction();
		entityManager.persist(indicador);
		entityManager.flush();
		EntityManagerHelper.commit();
		
	}

	@Override
	public void addMetodologia(Metodologia unaM) throws IOException {
		EntityManagerHelper.beginTransaction();
		entityManager.persist(unaM);
		entityManager.flush();
		EntityManagerHelper.commit();
	}

	@Override
	public void delete(String nombreIndicador) throws IOException {
		Query query = entityManager.createQuery("SELECT i FROM Indicador i WHERE nombreIndicador='" + nombreIndicador + "'");
	    Indicador indicador= (Indicador) query.getSingleResult();
	    EntityManagerHelper.beginTransaction();
		entityManager.remove(indicador);
		entityManager.flush();
		EntityManagerHelper.commit();
	}

	@Override
	public ArrayList<Indicador> getAllIndicadores() throws IOException {
		ArrayList<Indicador> indicadores = new ArrayList<Indicador>();
		Indicador indicador = new Indicador();
		int i = 1;
		while((indicador = entityManager.find(indicador.getClass(),i))!=null){
			indicadores.add(indicador);
			i++;
		}
		return indicadores;
		//Query query = entityManager.createQuery("SELECT i FROM Indicador i");
		//return (ArrayList<Indicador>) query.getResultList();
	}

	@Override
	public ArrayList<Metodologia> getAllMetodologias() throws IOException {
		ArrayList<Metodologia> metodologias= new ArrayList<Metodologia>();
		Metodologia metodologia= new Metodologia();
		int i = 1;
		while((metodologia = entityManager.find(metodologia.getClass(),i))!=null){
			metodologias.add(metodologia);
			i++;
		}
		return metodologias;
		//Query query = entityManager.createQuery("SELECT m FROM Metodologia m");
		//usar find
		//return (ArrayList<Metodologia>) query.getResultList();
	}

	@Override
	public ArrayList<Usuario> getAllUsuarios() throws IOException {
		Query query = entityManager.createQuery("SELECT u FROM Usuario u");
		return (ArrayList<Usuario>) query.getResultList();
	}

	@Override
	public void update(Indicador indicador) throws IOException {
		Indicador upd = entityManager.find(indicador.getClass(), indicador.getIdIndicador());
		EntityManagerHelper.beginTransaction();
		entityManager.merge(upd);
		entityManager.flush();
		EntityManagerHelper.commit();
		
	}

}
