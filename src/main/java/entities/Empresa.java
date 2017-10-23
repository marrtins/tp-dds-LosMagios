package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import entities.Periodo;

import java.io.Serializable;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name ="Empresa")
public class Empresa implements Serializable {

	@Id
	@GeneratedValue
	private int idEmpresa;
	


	private String nombreEmpresa;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Periodo> periodos = new ArrayList<>();
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Metodologia> metodologias= new LinkedList<>();;
	

	
	public Empresa(String _nombre) {
		super();
		this.nombreEmpresa = _nombre;
	}
	
	public int getIdEmpresa() {
		return idEmpresa;
	}
	
	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombre(String nombre) {
		this.nombreEmpresa = nombre;
	}

	public ArrayList<Periodo> getPeriodos() {
		return (ArrayList<Periodo>) periodos;
	}
	

	public void setPeriodos(ArrayList<Periodo> periodos) {
		this.periodos = periodos;
	}
	
	public ArrayList<Cuenta> getAllCuentas(){
		
		ArrayList<Cuenta> cuentas=new ArrayList<>();
		int i=0;
		for(i=0;i<periodos.size();i++){
			ArrayList<Cuenta> aux=this.getCuentasDePeriodo(periodos.get(i));
			aux.forEach(unaCuenta->cuentas.add(unaCuenta));

		}
		
		return cuentas;
	}
	
	
	public ArrayList<Cuenta> getCuentasDePeriodo(Periodo unPeriodo){
		
		if(!(this.periodos.contains(unPeriodo))) {
			this.agregarPeriodo(unPeriodo);
		}
		return unPeriodo.getCuentas();
	}
	
	public void agregarCuentaEnPeriodo(Cuenta unaCuenta, Periodo unPeriodo){
		
			if(!unPeriodo.contieneCuenta(unaCuenta.getNombreCuenta())){
				unPeriodo.agregarCuenta(unaCuenta);
			}
			else{
				unPeriodo.modificarCuenta(unaCuenta.getNombreCuenta(), unaCuenta.getValorCuenta());
			}
			
			
			
		
	}
	
	public void agregarPeriodos(ArrayList<Periodo> periodos){
		for(Periodo unPeriodo:periodos){
			unPeriodo.agregarCuentas(unPeriodo.getCuentas());
		}
		
	}
	
	public boolean tienePeriodo(int unAnio){
		return periodos.stream().anyMatch(periodo-> periodo.getAnio() == (new Periodo(unAnio)).getAnio());
	}
	public void agregarPeriodo(Periodo unPeriodo){
		periodos.add(unPeriodo);
		unPeriodo.setCuentas(new ArrayList<Cuenta>());
	}
	public Cuenta getCuentaDePeriodo(Periodo unPeriodo,String nombreCuenta){
		return unPeriodo.getCuenta(nombreCuenta);
	}
	public Periodo getPeriodoOrCreate(int unAnio){
		if(!this.tienePeriodo(unAnio)) this.agregarPeriodo(new Periodo(unAnio));
		return this.getPeriodo(unAnio);
	
	}
	
	public Periodo getPeriodo(int unAnio){
		return periodos.stream().filter(unPeriodo->unPeriodo.getAnio() == unAnio).findFirst().orElse(null);
	}
	
	
	
	
	public Boolean tieneIndicadorEnUltimosAnios(Indicador unIndicador, int anios){
		int lastYear = Calendar.getInstance().get(Calendar.YEAR) - 1;
		int firstYear = 1+lastYear-anios;
		int i;
		for(i=firstYear;i<=lastYear;i++){
			if(!this.tienePeriodo(i)) return false;
			Periodo periodoTemp = this.getPeriodoOrCreate(i);
			if(!unIndicador.puedeAplicarA(this,periodoTemp)) return false;
		}
		return true;
	}
	
	
	
	public int getAntiguedad(){
		int thisYear=Calendar.getInstance().get(Calendar.YEAR);
		int primerPeriodo=thisYear;
		int i;
		for(Periodo unPeriodo:periodos){
			if(unPeriodo.getAnio() < primerPeriodo) primerPeriodo=unPeriodo.getAnio();
		}
		
		return thisYear-primerPeriodo;
		
	}

	
	
	public Boolean antiguedadMayorA(int anios){
		int lastYear = Calendar.getInstance().get(Calendar.YEAR);
		int firstYear = lastYear-anios;
		int i;
		for(i=firstYear;i<lastYear;i++){
			if(!this.tienePeriodo(i)) return false;
		}
		return true;
	}
	
	public Boolean indicadorCrecienteEn(Indicador unIndicador, int anios){
		int lastYear = Calendar.getInstance().get(Calendar.YEAR) - 1;
		int firstYear = lastYear-anios;
		int i;
		if(!this.tieneIndicadorEnUltimosAnios(unIndicador, anios)) return false;
		for(i=firstYear;i<lastYear;i++){
			Periodo periodoAnterior = this.getPeriodoOrCreate(i);
			Periodo periodoSiguiente = this.getPeriodoOrCreate(i+1);
			if(unIndicador.aplicarIndicadorA(this,periodoAnterior)>unIndicador.aplicarIndicadorA(this,periodoSiguiente))return false;
		}
		return true;
	}



	public Double getValorIndicadorEn(int anio,Indicador unIndicador) {

		Periodo unPeriodo=this.getPeriodoOrCreate(anio);
		return unIndicador.aplicarIndicadorA(this,unPeriodo);
		
		
	}
	
	
	public ArrayList<Double> getValoresIndicadorEn(Indicador unIndicador, int anios){ 
		int lastYear = Calendar.getInstance().get(Calendar.YEAR) - 1;
		int firstYear = 1+lastYear-anios;
		int i;
		ArrayList<Double> valoresIndicador = new ArrayList<Double>();
		for(i=firstYear;i<=lastYear;i++){
			valoresIndicador.add(this.getValorIndicadorEn(i,unIndicador));
		}
		return valoresIndicador;
	}
	
	
	
	
	
	
	
	
	

}








