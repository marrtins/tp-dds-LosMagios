package test;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entities.Cuenta;
import entities.Empresa;
import model.RepositorioDeEmpresas;
import persistence.DAOJsonEmpresa;
import persistence.DataCollector;

public class TestEmpresa {
	private ArrayList<Empresa> empresas;
	private RepositorioDeEmpresas repoEmpresas;
	private DataCollector persistence = new DataCollector();
	@Before
	public void init(){
		try {
			empresas = persistence.cargarEmpresas();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void leoEmpresasYNombresSonCorrectos(){
		Assert.assertEquals("APPLE", empresas.get(0).getNombreEmpresa());
	}
	
	@Test
	public void agregoUnaEmpresaYAumentaElTamanioDeLaLIsta(){
		int tamanioAntes = empresas.size();
		Empresa nuevaE = new Empresa("EMPRESAPRUEBA");
		try {
			persistence.agregarEmpresa(nuevaE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			empresas  = persistence.cargarEmpresas();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int tamanioDespues = empresas.size();
		Assert.assertEquals(tamanioAntes + 1, tamanioDespues );
		try {
			persistence.borrarEmpresa(nuevaE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void eliminoUnaEmpresaYDisminuyeElTamanioDeLaLista(){
		int tamanioAntes = empresas.size();
		Empresa empresaABorrar = empresas.get(1);
		try {
			persistence.borrarEmpresa(empresaABorrar);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			empresas=persistence.cargarEmpresas();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int tamanioDespues = empresas.size();
		Assert.assertEquals(tamanioAntes - 1, tamanioDespues );
		try {
			persistence.agregarEmpresa(empresaABorrar);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
