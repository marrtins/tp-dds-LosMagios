<<<<<<< HEAD
/*package test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entities.Cuenta;
import entities.Empresa;
import entities.Indicador;
import entities.Metodologia;
import model.RepositorioDeEmpresas;
import model.RepositorioDeIndicadores;
import persistence.DAOJsonEmpresa;
import persistence.DataCollector;

public class TestMetodologias {
	private ArrayList<Indicador> indicadores;
	private ArrayList<Empresa> empresas;
	private ArrayList<Metodologia> metodologias;

	private RepositorioDeIndicadores repoIndicadores;
	private DataCollector persistence = new DataCollector();
	FixtureTests fixture;
	@Before
	public void init(){
		try {
			indicadores = persistence.cargarIndicadores();
			metodologias=persistence.cargarMetodologias();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fixture= new FixtureTests();
	}
	
	
	//de 5 empresas creadas en el orden APPLE FB GOOGLE PEPSI COCA, PEPSIyCoca no cumple las cond taxativas de buffet y las otras 4 se ordenan FB APPLE GOOGLE.
	
	
	//TEST #1
	@Test
	public void empresasSeFiltranYOrdenanBienConMetodologiaDeBuffet(){
				
		empresas = fixture.setearCuentasParaTest1(empresas);
		
		Metodologia metodologiaDeBuffet = metodologias.get(0);
		
		LinkedList<Empresa> empresasOrdenadas = new LinkedList<>();
		empresasOrdenadas = metodologiaDeBuffet.aplicarMetodologia(empresas);
		
		Assert.assertEquals(3, empresasOrdenadas.size());
		Assert.assertEquals("FB", empresasOrdenadas.get(0).getNombreEmpresa());
		Assert.assertEquals("GOOGLE", empresasOrdenadas.get(1).getNombreEmpresa());
		Assert.assertEquals("APPLE", empresasOrdenadas.get(2).getNombreEmpresa());
				
	}
	//TEST#2 //Pruebo una metodologia con condiciones solo taxativas. 3 empresas donde solo fb cumple las dos condiciones impuestas.
	@Test
	public void empresasSeFiltranYOrdenanBienConMetodologiaInventada(){
		
		empresas=fixture.setearCuentasParaTest2(empresas);
		
		Metodologia metodologiaInventada = metodologias.get(1);
		
		LinkedList<Empresa> empresasOrdenadas = new LinkedList<>();
		
		empresasOrdenadas = metodologiaInventada.aplicarMetodologia(empresas);
		
		Assert.assertEquals(1, empresasOrdenadas.size());
		Assert.assertEquals("FACEBOOK", empresasOrdenadas.get(0).getNombreEmpresa());
		
	}

	
	
	
	
	
	
	

}*/
=======
/*package test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entities.Cuenta;
import entities.Empresa;
import entities.Indicador;
import entities.Metodologia;
import model.RepositorioDeEmpresas;
import model.RepositorioDeIndicadores;
import persistence.DAOJsonEmpresa;
import persistence.DataCollector;

public class TestMetodologias {
	private ArrayList<Indicador> indicadores;
	private ArrayList<Empresa> empresas;
	private ArrayList<Metodologia> metodologias;

	private RepositorioDeIndicadores repoIndicadores;
	private DataCollector persistence = new DataCollector();
	FixtureTests fixture;
	@Before
	public void init(){
		try {
			indicadores = persistence.cargarIndicadores();
			metodologias=persistence.cargarMetodologias();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fixture= new FixtureTests();
	}
	
	
	//de 5 empresas creadas en el orden APPLE FB GOOGLE PEPSI COCA, PEPSIyCoca no cumple las cond taxativas de buffet y las otras 4 se ordenan FB APPLE GOOGLE.
	
	
	//TEST #1
	@Test
	public void empresasSeFiltranYOrdenanBienConMetodologiaDeBuffet(){
				
		empresas = fixture.setearCuentasParaTest1(empresas);
		
		Metodologia metodologiaDeBuffet = metodologias.get(0);
		
		LinkedList<Empresa> empresasOrdenadas = new LinkedList<>();
		empresasOrdenadas = metodologiaDeBuffet.aplicarMetodologia(empresas);
		
		Assert.assertEquals(3, empresasOrdenadas.size());
		Assert.assertEquals("FB", empresasOrdenadas.get(0).getNombreEmpresa());
		Assert.assertEquals("GOOGLE", empresasOrdenadas.get(1).getNombreEmpresa());
		Assert.assertEquals("APPLE", empresasOrdenadas.get(2).getNombreEmpresa());
				
	}
	//TEST#2 //Pruebo una metodologia con condiciones solo taxativas. 3 empresas donde solo fb cumple las dos condiciones impuestas.
	@Test
	public void empresasSeFiltranYOrdenanBienConMetodologiaInventada(){
		
		empresas=fixture.setearCuentasParaTest2(empresas);
		
		Metodologia metodologiaInventada = metodologias.get(1);
		
		LinkedList<Empresa> empresasOrdenadas = new LinkedList<>();
		
		empresasOrdenadas = metodologiaInventada.aplicarMetodologia(empresas);
		
		Assert.assertEquals(1, empresasOrdenadas.size());
		Assert.assertEquals("FACEBOOK", empresasOrdenadas.get(0).getNombreEmpresa());
		
	}

	
	
	
	
	
	
	

}*/
>>>>>>> 98c32eb728ebd10a9dddf1c95222c7ee29b1bb03
