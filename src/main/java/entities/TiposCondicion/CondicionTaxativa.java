package entities.TiposCondicion;

import java.io.IOException;

import javax.persistence.*;

import analisisMetodologico.OperadorTaxativo;
import analisisMetodologico.OperadoresFactory;
import entities.Empresa;
import entities.Indicador;
import entities.Metodologia;
import entities.TipoCondicion;
import persistence.DataCollector;

@Entity
@Table(name ="CondicionTaxativa")
public class CondicionTaxativa implements TipoCondicion  {

	
	
	//CREAR CONSTRUCTOR VACIO, HIBERNATE NO RECONOCE PARAMETROS


	public CondicionTaxativa(/*String nombreCondicion, String operadorString, int anios, String indicadorString,
			Double valorComparacion*/) {
		super();
//		this.nombreCondicion = nombreCondicion;
//		this.operadorString = operadorString;
//		this.anios = anios;
//		this.indicadorString = indicadorString;
//		this.valorComparacion = valorComparacion;
	}

	@Id
	@GeneratedValue
	int id;

	
	String nombreCondicion;
	String operadorString;
	int anios;
	String indicadorString;
	Double valorComparacion;
	
	@Transient
	OperadorTaxativo operador;
	
//	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@Transient
	Indicador indicador;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	Metodologia metodologia;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOperadorString() {
		return operadorString;
	}
	public void setOperadorString(String operadorString) {
		this.operadorString = operadorString;
	}
	public String getIndicadorString() {
		return indicadorString;
	}
	public void setIndicadorString(String indicadorString) {
		this.indicadorString = indicadorString;
	}
	public Double getValorComparacion() {
		return valorComparacion;
	}
	public void setValorComparacion(Double valorComparacion) {
		this.valorComparacion = valorComparacion;
	}
	
	
	public String getNombreCondicion() {
		return nombreCondicion;
	}
	public void setNombreCondicion(String nombreCondicion) {
		this.nombreCondicion = nombreCondicion;
	}
	public OperadorTaxativo getOperador() {
		return operador;
	}
	public void setOperador(OperadorTaxativo operador) {
		this.operador = operador;
	}
	public int getAnios() {
		return anios;
	}
	public void setAnios(int anios) {
		this.anios = anios;
	}
	public Indicador getIndicador() {
		return indicador;
	}
	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
	}

	
	public Boolean empresaCalifica(Empresa unaEmpresa) throws IOException{
		
		DataCollector persistence=new DataCollector();
		OperadoresFactory creador = new OperadoresFactory();
		
		indicador= persistence.getIndicador(indicadorString);
		operador=creador.crearOperadorTaxativo(operadorString);
		
		
		return operador.analizarEmpresaTaxativamente(unaEmpresa,indicador,anios,valorComparacion);
		
		
	}
}
