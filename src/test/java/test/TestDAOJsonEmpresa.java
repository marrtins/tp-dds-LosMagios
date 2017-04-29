package test;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import bddEmpresa.DAOJsonEmpresa;
import bddEmpresa.RepositorioDeEmpresas;
import clases.Empresa;

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
			Assert.assertEquals("Philips", empresas.get(0).getNombre());
			Assert.assertEquals("walmart", empresas.get(1).getNombre());
			Assert.assertEquals("Sanyo", empresas.get(2).getNombre());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*@Test
	public void agregoEmpleadoYLoRecupero(){
		Empresa empleado = new Empresa();
		empleado.setId(4);
		empleado.setNombre("Monica");
		empleado.setApellido("Morado");
		empleado.setDireccion("Avenida de Mayo 850,CABA");
		
		try {
			this.repoEmpleados.add(empleado);
			this.empleados = repoEmpresas.getAllEmpleados();
			Assert.assertTrue(empresas.contains(empleado));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
