package test;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Cuenta;
import modelo.Empresa;
import persistence.DAOJsonEmpresa;
import persistence.DataCollector;
import persistence.RepositorioDeEmpresas;

public class TestDAOJsonEmpresa {
	private ArrayList<Empresa> empresas;
	private RepositorioDeEmpresas repoEmpresas;
	private DataCollector persistence = new DataCollector();
	@Before
	public void init(){
		empresas = persistence.cargarEmpresas();
	}
	
	@Test
	public void leoEmpresasYNombresSonCorrectos(){
		
		Assert.assertEquals("APPLE", empresas.get(0).getNombreEmpresa());
		
	}
	
	@Test
	public void agregoUnaEmpresaYAumentaElTamanioDeLaLIsta(){
		int tamanioAntes = empresas.size();
		Empresa nuevaE = new Empresa("EMPRESAPRUEBA");
		persistence.agregarEmpresa(nuevaE);
		empresas  = persistence.cargarEmpresas();
		int tamanioDespues = empresas.size();
		Assert.assertEquals(tamanioAntes + 1, tamanioDespues );
		persistence.borrarEmpres(nuevaE);
		
	}
	
	

}
