package entities;



import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import entities.TiposCondicion.CondicionNoTaxativa;
import entities.TiposCondicion.CondicionTaxativa;
import excepciones.ErrorCargaDatos;
import persistence.DataCollector;

import javax.persistence.*;

@Entity
@Table(name ="Metodologia")
public class Metodologia {

	@Id
	@GeneratedValue
	private int idMetodologia;
	
	public String nombreMetodologia;

	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	List<CondicionTaxativa> cTaxativas;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	List<CondicionNoTaxativa> cNoTaxativas;
	
//	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="metodologias")
	@Transient //TODO para mi no se persiste esto: una metodologia se aplica sobre empresas, pero para la creacion de una metodologia no se necesita
	List<Empresa> listaOrdenada;
	
	public Metodologia() { 
		super();
		listaOrdenada=new LinkedList<>();
		cTaxativas = new ArrayList<>();
		cNoTaxativas = new ArrayList<>();
	}

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



	public List<CondicionTaxativa> getcTaxativas() {
		return cTaxativas;
	}
	
	



	public void setcTaxativas(ArrayList<CondicionTaxativa> cTaxativas) {
		this.cTaxativas = cTaxativas;
	}



	public List<CondicionNoTaxativa> getcNoTaxativas() {
		return cNoTaxativas;
	}



	public void setcNoTaxativas(ArrayList<CondicionNoTaxativa> cNoTaxativas) {
		this.cNoTaxativas = cNoTaxativas;
	}



	public List<Empresa> getListaOrdenada() {
		return listaOrdenada;
	}



	public void setListaOrdenada(List<Empresa> listaOrdenada) {
		this.listaOrdenada = listaOrdenada;
	}



	public List<Empresa> aplicarMetodologia(List<Empresa> empresas,String periodoSeleccionado) throws IOException{
		//A cada una de las empresas le aplico las condiciones TAXATIVAS, si no las pasa, las dejo de analizar (no las agrego a la lista link)
		//empresas.removeIf(unaEmpresa -> !this.cumpleCondicionesTaxativas(unaEmpresa));
		
		
		
		int i;
		for(i=0;i<empresas.size();i++){
			
			Empresa empresa = empresas.get(i);
			if(this.cumpleCondicionesTaxativas(empresa,periodoSeleccionado)) listaOrdenada.add(empresa);
		}	
		
		
		if(this.soyTaxativa()) {
			return (List<Empresa>) listaOrdenada;		
		}
		
		
		//Todas las empresas que quedaron, cumplen todas las condiciones taxativas. Las agrego a la lista linkeada para luego ordenar x prioridad
		//listaOrdenada.addAll(empresas);
		//Les aplico las comparaciones basadas en las condiciones no taxativas para ordenarlas
		this.ordenarEmpresas(periodoSeleccionado);
		return (List<Empresa>) listaOrdenada;		

		
		
	}
	
	public Boolean soyTaxativa() {
		if(cTaxativas.size()>0) return true;
		return false;
	}

	
	public Boolean cumpleCondicionesTaxativas(Empresa unaEmpresa,String periodoSeleccionado){
		
		
		for(CondicionTaxativa unaCondicion:cTaxativas){
			try {
				if(!unaCondicion.empresaCalifica(unaEmpresa,periodoSeleccionado))return false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
	
	
	
	
	public void ordenarEmpresas(String periodoSeleccionado) throws IOException{
		Empresa temp;
		
		List<Empresa> listaFiltrada = new ArrayList<Empresa>();
		
		int i;
		Indicador unIndicador = null;
		DataCollector persistence = new DataCollector();
		for(i=0;i<listaOrdenada.size();i++) {
			Empresa empresaAux = listaOrdenada.get(i);
			for(CondicionNoTaxativa unaCondicion:cNoTaxativas){
				unIndicador = persistence.getIndicador(unaCondicion.getIndicadorString());
				if(unIndicador==null) {
					Indicador nuevoIndicador = new Indicador();
					nuevoIndicador.setCalculoIndicador("{"+unaCondicion.getIndicadorString()+"}");
					nuevoIndicador.setNombreIndicador(unaCondicion.getIndicadorString());
					unIndicador = nuevoIndicador;
				}
				Periodo unPeriodo = empresaAux.getPeriodoOrCreate(Integer.valueOf(periodoSeleccionado));
				Double resultadoEmpresa=unIndicador.aplicarIndicadorA(empresaAux,unPeriodo);
				//Double resultadoEmpresa = empresaAux.getValorIndicador(unaCondicion.getUnIndicador(), periodoSeleccionado);
				if(resultadoEmpresa!=-999.9) listaFiltrada.add(empresaAux);
			}
		}
		
		//listaOrdenada.clear();
		listaOrdenada=listaFiltrada;
		if(!listaOrdenada.isEmpty()){
			int n = listaOrdenada.size();


			for (i = n-1; i >= 0; i--){
				for(int j=1;j<=i;j++){
					Empresa empresa1 = listaOrdenada.get(j-1);Empresa empresa2=listaOrdenada.get(j);
					if(!this.empresaConMayorPrioridadQue(empresa1,empresa2,periodoSeleccionado)){

						temp = empresa1;
						listaOrdenada.remove(j);
						listaOrdenada.remove(j-1);
						listaOrdenada.add((j-1),empresa2);
						listaOrdenada.add(j,empresa1);


					}
				}
			}	
		}
	}	
	
	
	
	public Boolean empresaConMayorPrioridadQue(Empresa empresa1, Empresa empresa2,String periodoSeleccionado) throws IOException {
		int peso=0;
		for(CondicionNoTaxativa unaCondicion:cNoTaxativas){
			peso+=unaCondicion.aplicarCondicion(empresa1, empresa2,periodoSeleccionado);
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
