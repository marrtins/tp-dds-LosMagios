package entities;

import java.io.IOException;


import analizadorIndicadores.AnalizadorLexico;
import analizadorIndicadores.AnalizadorSintactico;
import analizadorIndicadores.Parser;
import excepciones.ErrorConstantesEnIndicador;

import javax.persistence.*;

@Entity
@Table(name ="Indicador")
public class Indicador {
	


	@Id
	@GeneratedValue
	private int idIndicador;
	
	private String nombreIndicador;
	private String calculoIndicador;
	public String formulaString;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	public Usuario usuario;
	
	
	
	public String getNombreIndicador() {
		return nombreIndicador;
	}
	public void setNombreIndicador(String nombreIndicador) {
		this.nombreIndicador = nombreIndicador;
	}
	
	public int getIdIndicador() {
		return idIndicador;
	}
	
	public void setIdIndicador(int idIndicador) {
		this.idIndicador = idIndicador;
	}
	
	public String getCalculoIndicador() {
		return calculoIndicador;
	}
	
	public void setCalculoIndicador(String calculoIndicador) {
		this.calculoIndicador = calculoIndicador;
	}
	private String nombreUsuario;
	public String getUsuario() {
		return nombreUsuario;
	}
	public void setUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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
