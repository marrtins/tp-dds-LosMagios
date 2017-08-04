package modelo;

import java.io.IOException;

import javax.swing.JOptionPane;

import analizadorIndicadores.AnalizadorLexico;
import analizadorIndicadores.AnalizadorSintactico;
import analizadorIndicadores.Parser;
import excepciones.ErrorConstantesEnIndicador;
import persistence.DataCollector;

public class Indicador {
	
	private String nombreIndicador;
	private String calculoIndicador;
	public String formulaString;
	
	public String getNombreIndicador() {
		return nombreIndicador;
	}
	public void setNombreIndicador(String nombreIndicador) {
		this.nombreIndicador = nombreIndicador;
	}
	
	public String getCalculoIndicador() {
		return calculoIndicador;
	}
	public void setCalculoIndicador(String calculoIndicador) {
		this.calculoIndicador = calculoIndicador;
	}
	
	public Boolean puedeAplicarA(Empresa unaEmpresa,Periodo unPeriodo){
		AnalizadorSintactico sintax = new AnalizadorSintactico();
		return sintax.indicadorValido(this.getCalculoIndicador());
	}
	
	
	public  Double aplicarIndicadorA(Empresa unaEmpresa, Periodo unPeriodo){
		
		AnalizadorLexico analizadorLexico = new AnalizadorLexico();
		AnalizadorSintactico sintax = new AnalizadorSintactico();
		if(sintax.indicadorValido(this.getCalculoIndicador())){
			try {
				formulaString = analizadorLexico.analizar(this.getCalculoIndicador(), unaEmpresa, unPeriodo);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
				Exception e = new Exception();
				try {
					throw new ErrorConstantesEnIndicador(e);
				} catch (ErrorConstantesEnIndicador e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
		return Parser.eval(formulaString);
		
		
		
		
		
	}
	
	
	

}
