package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Cuenta;
import modelo.Empresa;
import modelo.Periodo;
import persistence.DataCollector;


import static org.junit.Assert.*;

public class TestPeriodos {
	
	public ArrayList<Empresa> empresas;
	public ArrayList<Periodo> periodos;
	public Empresa empresaATestear;
	
	DataCollector persistence;
	@Before
	public void init(){
		persistence = new DataCollector();
		try {
			empresas = persistence.cargarEmpresas();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		empresaATestear = empresas.get(0);
	}
	
	@Test
	public void leoPeriodosDeUnaEmpresaYSuTamanioVerifica(){
		periodos = empresaATestear.getPeriodos();
		Assert.assertEquals(4,periodos.size());
	}
	
	@Test
	public void agregoUnaCuentaYCambiaElTamanioDeLaListaDeCuentasDeUnPeriodo(){
		periodos = empresaATestear.getPeriodos();
		Periodo periodoATestear = periodos.get(0);
		int tamanioAntes = periodoATestear.getCuentas().size();
		Cuenta cuentaTest = new Cuenta();
		cuentaTest.setear("prueba",200);
		periodoATestear.agregarCuenta(cuentaTest);
		try {
			persistence.updateEmpresa(empresaATestear);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			empresas = persistence.cargarEmpresas();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		empresaATestear = empresas.get(0);
		periodos = empresaATestear.getPeriodos();
		
		int tamanioDespues = periodoATestear.getCuentas().size();
		Assert.assertEquals(tamanioAntes + 1, tamanioDespues);

		
	}
}
