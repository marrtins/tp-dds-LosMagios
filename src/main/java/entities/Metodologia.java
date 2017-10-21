package entities;



import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.text.html.HTMLDocument.Iterator;

import entities.TiposCondicion.CondicionNoTaxativa;
import entities.TiposCondicion.CondicionTaxativa;
import excepciones.ErrorCargaDatos;

import javax.persistence.*;

public class Metodologia {

	@Id
	@GeneratedValue
	private int idMetodologia;
	
	public String nombreMetodologia;
	
	ArrayList<CondicionTaxativa> cTaxativas;
	ArrayList<CondicionNoTaxativa> cNoTaxativas;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="metodologias")
	LinkedList<Empresa> listaOrdenada=new LinkedList<>();
	
	public String usuario;
	
	String descripcionMetodologia;
	
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombreMetodologia() {
		return nombreMetodologia;
	}
	
	public String getDescripcionCondicionTaxativas(){
		
		String descripcion = "";
		for( CondicionTaxativa s : cTaxativas ){
		  descripcion+="#"+s.getNombreCondicion()+"\n\n";
		}
		
		return descripcion;
		
	}
	
	
public String getDescripcionCondicionNoTaxativas(){
		
		String descripcion = "";
		for( CondicionNoTaxativa s : cNoTaxativas ){
		  descripcion+="#"+s.getNombreCondicion()+"\n\n";
		}
		
		return descripcion;
		
	}
	
	

	


	public void setNombreMetodologia(String nombreMetodologia) {
		this.nombreMetodologia = nombreMetodologia;
	}



	public ArrayList<CondicionTaxativa> getcTaxativas() {
		return cTaxativas;
	}
	
	



	public void setcTaxativas(ArrayList<CondicionTaxativa> cTaxativas) {
		this.cTaxativas = cTaxativas;
	}



	public ArrayList<CondicionNoTaxativa> getcNoTaxativas() {
		return cNoTaxativas;
	}



	public void setcNoTaxativas(ArrayList<CondicionNoTaxativa> cNoTaxativas) {
		this.cNoTaxativas = cNoTaxativas;
	}



	public LinkedList<Empresa> getListaOrdenada() {
		return listaOrdenada;
	}



	public void setListaOrdenada(LinkedList<Empresa> listaOrdenada) {
		this.listaOrdenada = listaOrdenada;
	}



	public LinkedList<Empresa> aplicarMetodologia(ArrayList<Empresa> empresas){
		//A cada una de las empresas le aplico las condiciones TAXATIVAS, si no las pasa, las dejo de analizar (no las agrego a la lista link)
		//empresas.removeIf(unaEmpresa -> !this.cumpleCondicionesTaxativas(unaEmpresa));
		int i;
		for(i=0;i<empresas.size();i++){
			
			Empresa empresa = empresas.get(i);
			if(this.cumpleCondicionesTaxativas(empresa)) listaOrdenada.add(empresa);
		}
		
		
		//Todas las empresas que quedaron, cumplen todas las condiciones taxativas. Las agrego a la lista linkeada para luego ordenar x prioridad
		//listaOrdenada.addAll(empresas);
		//Les aplico las comparaciones basadas en las condiciones no taxativas para ordenarlas
		this.ordenarEmpresas();
		return listaOrdenada;
		
	}
	

	
	public Boolean cumpleCondicionesTaxativas(Empresa unaEmpresa){
		
		
		for(CondicionTaxativa unaCondicion:cTaxativas){
			try {
				if(!unaCondicion.empresaCalifica(unaEmpresa))return false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return true;
	}
	
	
	
	
	
	public void ordenarEmpresas(){
		Empresa temp;
		int n = listaOrdenada.size();
		int i;
		for (i = n-1; i >= 0; i--){
			for(int j=1;j<=i;j++){
				Empresa empresa1 = listaOrdenada.get(j-1);Empresa empresa2=listaOrdenada.get(j);
				if(!this.empresaConMayorPrioridadQue(empresa1,empresa2)){
					
					temp = empresa1;
					listaOrdenada.remove(j);
					listaOrdenada.remove(j-1);
					listaOrdenada.add((j-1),empresa2);
					listaOrdenada.add(j,empresa1);
					
	
					
					
					
					
				}
			}
		}	
	}
	
	
	
	public Boolean empresaConMayorPrioridadQue(Empresa empresa1, Empresa empresa2) {
		int peso=0;
		for(CondicionNoTaxativa unaCondicion:cNoTaxativas){
			peso+=unaCondicion.aplicarCondicion(empresa1, empresa2);
		}
		if(peso<0) return false;
		return true;
	}
	
	public void cargarMetodologia(){
		
		for(CondicionTaxativa unaTaxativa:cTaxativas){
			cTaxativas.add(unaTaxativa);
		}
		for(CondicionNoTaxativa unaNoTaxativa:cNoTaxativas){
			cNoTaxativas.add(unaNoTaxativa);
		}
		
		
	}
	
}
