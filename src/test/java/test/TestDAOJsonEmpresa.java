package test;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import bddEmpresa.DAOJsonEmpresa;
import bddEmpresa.RepositorioDeEmpresas;
import modelo.Cuenta;
import modelo.Empresa;

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
			Assert.assertEquals("facebook", empresas.get(0).getNombre());
			Assert.assertEquals("google", empresas.get(1).getNombre());
			Assert.assertEquals("apple", empresas.get(2).getNombre());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
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
	
	}
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
			empresaAModificar.setNombre("COCA COLA");
			repoEmpresas.update(empresaAModificar);
			Assert.assertEquals("COCA COLA",empresas.get(2).getNombre());
			empresaAModificar.setNombre(nombreAntesDeModificar);
			repoEmpresas.update(empresaAModificar);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

}
