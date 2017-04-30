package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import bddCuentas.DAOJsonCuenta;
import bddCuentas.RepositorioDeCuentas;
import clases.Cuenta;


public class TestDAOJsonCuentas {

	private ArrayList<Cuenta> cuentas;
	private RepositorioDeCuentas repoCuentas;
	
	@Before
	public void init(){
		DAOJsonCuenta dao = new DAOJsonCuenta();
		dao.setFilePath("C:\\Users\\martin\\Git\\3-LosMagios\\bd\\cuentas.json");
		this.repoCuentas = new RepositorioDeCuentas(dao);
	}
	
	@Test
	public void leoCuentasYNombresSonCorrectos(){
		try {
			this.cuentas = repoCuentas.getAllCuentas();
			Assert.assertEquals("EITDA", cuentas.get(0).getNombreCuenta());
			Assert.assertEquals("FDS", cuentas.get(1).getNombreCuenta());
			Assert.assertEquals("free cash flow", cuentas.get(2).getNombreCuenta());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void agrego(){
		try {
			this.cuentas = repoCuentas.getAllCuentas();
			Cuenta nuevaCuenta = new Cuenta(10,"asd",10);
			cuentas.add(nuevaCuenta);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(1,cuentas.size());
	}
	

}
