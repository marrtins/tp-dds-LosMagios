package test;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import excepciones.ErrorConstantesEnIndicador;
import excepciones.ErrorLexico;
import junit.framework.Assert;
import modelo.Empresa;
import modelo.Indicador;
import modelo.Periodo;
import parser.AnalizadorLexico;
import parser.AnalizadorSintactico;
import parser.Parser;
import persistence.DataCollector;

public class TestIndicadores {
	
	
	public ArrayList<Empresa> empresas;
	public ArrayList<Periodo> periodos;
	public Empresa empresaATestear;
	public ArrayList<Indicador> indicadores;
	DataCollector persistence;
	Indicador indicadorPrueba;
	Parser parser = new Parser();
	AnalizadorLexico analizadorLexico = new AnalizadorLexico();
	public Periodo periodoATestear;
	
	
	
	
	@Before
	public void init(){

		indicadorPrueba = new Indicador();
		persistence = new DataCollector();
		try {
			empresas = persistence.cargarEmpresas();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			indicadores = persistence.cargarIndicadores();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			empresas = persistence.cargarEmpresas();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		empresaATestear = empresas.get(1);
		periodoATestear = empresaATestear.getPeriodos().get(1);
	}
	
	@Test
	public void agregoIndicadorCorrectoYAumentaSizeDeLaListaLuegoLoBorroYElSizeEsCorrecto(){
		
		Indicador nuevoIndicador = new Indicador();
		nuevoIndicador.setNombreIndicador("EJEMPLO");
		nuevoIndicador.setCalculoIndicador("{ASD}*{FDS}+1-5/5*3");
		int tamanioAntes = indicadores.size();
		try {
			persistence.agregarIndicador(nuevoIndicador);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			indicadores = persistence.cargarIndicadores();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int tamanioDespues = indicadores.size();
		Assert.assertEquals(tamanioAntes+1,tamanioDespues);
		persistence.borrarIndicador(nuevoIndicador);
		try {
			indicadores = persistence.cargarIndicadores();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tamanioDespues = indicadores.size();
		Assert.assertEquals(tamanioAntes,tamanioDespues);
		
		
	}
	
	@Test
	public void analizoSiLaFormulaDelIndicadorIndicadorEsValidoCuandoNoUsoLlavesYLanzaExcepcion(){
		indicadorPrueba.setCalculoIndicador("PBI+1");
		AnalizadorSintactico sintax = new AnalizadorSintactico();
		Assert.assertFalse("Error en la escritura de la formula",sintax.indicadorValido(indicadorPrueba.getCalculoIndicador()));
	}
	
	
	
	
	

}
