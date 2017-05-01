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
	public void add(){
		try {
			this.cuentas = repoCuentas.getAllCuentas();
			Cuenta nuevaCuenta = new Cuenta(4,"CuentaDePrueba",999, 2010, "EmpresaDePrueba");
			repoCuentas.add(nuevaCuenta);
			Assert.assertEquals(4,cuentas.size());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@Test
	public void delete(){
		try {
			this.cuentas = repoCuentas.getAllCuentas();
			Cuenta eliminarCuenta = new Cuenta(0,"EITsDA",100, 2010, "facebook");
			repoCuentas.delete(eliminarCuenta);
			Assert.assertEquals(2,cuentas.size());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
