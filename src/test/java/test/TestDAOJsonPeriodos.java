package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import bddPeriodos.RepositorioDePeriodos;
import modelo.Periodo;
import bddPeriodos.DAOJsonPeriodo;

import static org.junit.Assert.*;

public class TestDAOJsonPeriodos {
	private ArrayList<Periodo> periodos;
	private RepositorioDePeriodos repoPeriodos;
	
	@Before
	public void init(){
		DAOJsonPeriodo dao = new DAOJsonPeriodo();
		dao.setFilePath("C:\\Users\\martin\\Git\\3-LosMagios\\bd\\periodos.json");
		this.repoPeriodos = new RepositorioDePeriodos(dao);
	}
	
	@Test
	public void leoPeriodosYSonCorrectos(){
		try {
			this.periodos = repoPeriodos.getAllPeriodos();
			Assert.assertEquals(2010, periodos.get(0).getAnio());
			Assert.assertEquals(2011, periodos.get(1).getAnio());
			Assert.assertEquals(2013, periodos.get(2).getAnio());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
