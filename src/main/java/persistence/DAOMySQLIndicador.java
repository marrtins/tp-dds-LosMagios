package persistence;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import db.EntityManagerHelper;
import entities.Empresa;
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
		
		
	}

	@Override
	public void delete(String nombreIndicador) throws IOException {
		
		
	}

	@Override
	public ArrayList<Indicador> getAllIndicadores() throws IOException {
		
		return null;
	}

	@Override
	public ArrayList<Metodologia> getAllMetodologias() throws IOException {
		
		return null;
	}

	@Override
	public ArrayList<Usuario> getAllUsuarios() throws IOException {
		
		return null;
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
