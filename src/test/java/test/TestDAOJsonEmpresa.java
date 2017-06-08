package test;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Cuenta;
import modelo.Empresa;
import persistence.DAOJsonEmpresa;
import persistence.RepositorioDeEmpresas;

public class TestDAOJsonEmpresa {
	private ArrayList<Empresa> empresas;
	private RepositorioDeEmpresas repoEmpresas;
	
	@Before
	public void init(){
		DAOJsonEmpresa dao = new DAOJsonEmpresa();
		dao.setFilePath("C:\\Users\\martin\\Git\\3-LosMagios\\bd\\empresas.json");
		this.repoEmpresas = new RepositorioDeEmpresas(dao);
	}
	
	@Test
	public void leoEmpresasYNombresSonCorrectos(){
		try {
			this.empresas = repoEmpresas.getAllEmpresas();
			Assert.assertEquals("Apple", empresas.get(0).getNombre());
			Assert.assertEquals("Google", empresas.get(1).getNombre());
			Assert.assertEquals("facebook", empresas.get(2).getNombre());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*@Test
	public void agregoUnaEmpresaYAumentaElTamanioDeLaLIsta(){
		try {
			this.empresas = repoEmpresas.getAllEmpresas();
			Empresa nuevaEmpresa = new Empresa(3,"facebook");
			int tamanioAntesDeAgregar = empresas.size();
			repoEmpresas.add(nuevaEmpresa);
			int tamanioDespuesDeAgregar = empresas.size();
			this.empresas = repoEmpresas.getAllEmpresas();
			Assert.assertEquals(tamanioAntesDeAgregar,empresas.size() - 1);
			repoEmpresas.delete(nuevaEmpresa);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}*/
	@Test
	public void borroUnaEmpresaYDisminuyeElTamnioDeLaLista(){
		try {
			this.empresas = repoEmpresas.getAllEmpresas();
			Empresa empresaABorrar = empresas.get(2);
			int tamanioEmpresaAntesDeBorrar = empresas.size();
			repoEmpresas.delete(empresaABorrar);
			this.empresas = repoEmpresas.getAllEmpresas();
			int tamanioEmpresaDespuesDeBorrar = empresas.size();
			Assert.assertEquals(tamanioEmpresaDespuesDeBorrar +1,tamanioEmpresaAntesDeBorrar);
			repoEmpresas.add(empresaABorrar);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@Test
	public void cambioElNombreDeUnaEmpresaPorCOCACOLA(){
		try {
			this.empresas = repoEmpresas.getAllEmpresas();
			Empresa empresaAModificar = empresas.get(2);
			String nombreAntesDeModificar = empresas.get(2).getNombre();
			empresaAModificar.setNombre("COCAA COLA");
			repoEmpresas.update(empresaAModificar);
			Assert.assertEquals("COCAA COLA",empresas.get(2).getNombre());
			empresaAModificar.setNombre(nombreAntesDeModificar);
			Cuenta nuevaCuenta = new Cuenta();
			nuevaCuenta.setear(10, "asd", 100, 2000);
			empresaAModificar.agregarCuenta(nuevaCuenta);
			repoEmpresas.update(empresaAModificar);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

}
