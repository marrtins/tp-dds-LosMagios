package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import entities.Periodo;

import java.io.IOException;
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
	
	@ManyToMany(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
//	@ElementCollection
//	@CollectionTable(name="cuenta_periodo_empresa", joinColumns=@JoinColumn(name="idEmpresa"))
//	@Column(name="periodo", table="Periodo", unique=false)
	private List<Periodo> periodos = new ArrayList<>();
	
	public Empresa(/*String _nombre*/) { 
		super();
//		this.nombreEmpresa = _nombre;
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

	public List<Periodo> getPeriodos() {
		return periodos;
	}
	

	public void setPeriodos(ArrayList<Periodo> periodos) {
		this.periodos = periodos;
	}
	
	public ArrayList<Cuenta> getAllCuentas(){
		
		ArrayList<Cuenta> cuentas=new ArrayList<>();
		int i=0;
		for(i=0;i<periodos.size();i++){
			List<Cuenta> aux=this.getCuentasDePeriodo(periodos.get(i));
			aux.forEach(unaCuenta->cuentas.add(unaCuenta));

		}
		
		return cuentas;
	}
	
	
	public List<Cuenta> getCuentasDePeriodo(Periodo unPeriodo){
		
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
	
	public void agregarPeriodos(List<Periodo> list){
		for(Periodo unPeriodo:list){
			unPeriodo.agregarCuentas(unPeriodo.getCuentas());
		}
		
	}
	
	public boolean tienePeriodo(int unAnio){
		Periodo p = new Periodo();
		p.setAnio(unAnio);
		return periodos.stream().anyMatch(periodo-> periodo.getAnio() == (p.getAnio()));
	}
	public void agregarPeriodo(Periodo unPeriodo){
		periodos.add(unPeriodo);
		unPeriodo.setCuentas(new ArrayList<Cuenta>());
	}
	public Cuenta getCuentaDePeriodo(Periodo unPeriodo,String nombreCuenta){
		return unPeriodo.getCuenta(nombreCuenta);
	}
	public Periodo getPeriodoOrCreate(int unAnio){
		Periodo p = new Periodo();
		p.setAnio(unAnio);
		if(!this.tienePeriodo(unAnio)) this.agregarPeriodo(p);
		return this.getPeriodo(unAnio);
	
	}
	
	public Periodo getPeriodo(int unAnio){
		return periodos.stream().filter(unPeriodo->unPeriodo.getAnio() == unAnio).findFirst().orElse(null);
	}
	
	
	
	
	public Boolean tieneIndicadorEnUltimosAnios(Indicador unIndicador, int anios) throws IOException{
		int lastYear = Calendar.getInstance().get(Calendar.YEAR) - 1;
		int firstYear = 1+lastYear-anios;
		int i;
		for(i=firstYear;i<=lastYear;i++){
			if(!this.tienePeriodo(i)) return false;
			Periodo periodoTemp = this.getPeriodoOrCreate(i);
			if(!unIndicador.puedeAplicarA(this,periodoTemp)) return false;
			if(unIndicador.aplicarIndicadorA(this,periodoTemp)!=-999.9)return true;
		}
		return false;
	}
	
	
	public Boolean tieneIndicadorEnPeriodoSeleccionado(Indicador unIndicador, String periodo) throws IOException{
	
		Periodo periodoTemp = this.getPeriodoOrCreate(Integer.valueOf(periodo));
		if(!unIndicador.puedeAplicarA(this,periodoTemp)) return false;
		if(unIndicador.aplicarIndicadorA(this,periodoTemp)==-999.9)return false;
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
	
	public Boolean indicadorCrecienteEn(Indicador unIndicador, int anios) throws IOException{
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



	public Double getValorIndicadorEn(int anio,Indicador unIndicador) throws IOException {

		Periodo unPeriodo=this.getPeriodoOrCreate(anio);
		return unIndicador.aplicarIndicadorA(this,unPeriodo);
		
		
	}
	
	
	public ArrayList<Double> getValoresIndicadorEn(Indicador unIndicador, int anios) throws IOException{ 
		int lastYear = Calendar.getInstance().get(Calendar.YEAR) - 1;
		int firstYear = 1+lastYear-anios;
		int i;
		ArrayList<Double> valoresIndicador = new ArrayList<Double>();
		
		
		for(i=firstYear;i<=lastYear;i++){
		
			valoresIndicador.add(this.getValorIndicadorEn(i,unIndicador));
		}
		return valoresIndicador;
	}
	
	
	public Double getValorIndicador(Indicador unIndicador, String periodoSeleccionado) throws IOException{ 
				
		return this.getValorIndicadorEn(Integer.valueOf(periodoSeleccionado),unIndicador);
	}
	
	
	
	
	
	
	
	
	

}








