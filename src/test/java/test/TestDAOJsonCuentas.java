package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import bddCuentas.DAOJsonCuenta;
import bddCuentas.RepositorioDeCuentas;
import modelo.Cuenta;
import modelo.Empresa;


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
	public void agregoCuentaYAumentaElSizeDeLaListaCuentas(){
		try {
			this.cuentas = repoCuentas.getAllCuentas();
			Cuenta nuevaCuenta = new Cuenta(4,"CuentaDePrueba",999, 2010, "EmpresaDePrueba");
			int tamanioAntesDeAgregar = cuentas.size();
			repoCuentas.add(nuevaCuenta);
			this.cuentas = repoCuentas.getAllCuentas();
			Assert.assertEquals(tamanioAntesDeAgregar,cuentas.size() - 1);
			repoCuentas.delete(nuevaCuenta);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@Test
	public void deleteoCuentaYDisminuyeElSizeDeLaListaCuentas(){
		try {
			this.cuentas = repoCuentas.getAllCuentas();
			Cuenta cuentaABorrar = cuentas.get(2);
			int tamanioCuentaAntesDeBorrar = cuentas.size();
			repoCuentas.delete(cuentaABorrar);
			this.cuentas = repoCuentas.getAllCuentas();
			int tamanioCuentaDespuesDeBorrar = cuentas.size();
			Assert.assertEquals(tamanioCuentaDespuesDeBorrar +1,tamanioCuentaAntesDeBorrar);
			repoCuentas.add(cuentaABorrar);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@Test
	public void cambioElValorDeUnaCuentaPor13(){
		try {
			this.cuentas = repoCuentas.getAllCuentas();
			Cuenta cuentaAModificar= cuentas.get(2);
			int valorAntesDeModificar = cuentas.get(2).getValorCuenta();
			cuentaAModificar.setValorCuenta(13);
			repoCuentas.update(cuentaAModificar);
			Assert.assertEquals(13,cuentas.get(2).getValorCuenta());
			cuentaAModificar.setValorCuenta(valorAntesDeModificar);
			repoCuentas.update(cuentaAModificar);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
