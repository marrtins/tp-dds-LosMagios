package modelo;



import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import modelo.TiposCondicion.CondicionCombinada;
import modelo.TiposCondicion.CondicionNoTaxativa;
import modelo.TiposCondicion.CondicionTaxativa;

public class Metodologia {

	public String nombreMetodologia;
	
	ArrayList<CondicionTaxativa> cTaxativas;
	ArrayList<CondicionNoTaxativa> cNoTaxativas;
	ArrayList<CondicionCombinada> cCombinadas;
	LinkedList<Empresa> listaOrdenada=new LinkedList<>();
	
	
	
	
	public LinkedList<Empresa> aplicarMetodologia(ArrayList<Empresa> empresas){
		
		
		//combinamos las condiciones (asgergamos las tax y no tax de las combinadas a la listas grales)
		this.combinarCondiciones();
		//A cada una de las empresas le aplico las condiciones TAXATIVAS, si no las pasa, las dejo de analizar (no las agrego a la lista link)
		
		
		//	empresas.removeIf(unaEmpresa -> !this.cumpleCondicionesTaxativas(unaEmpresa));
		
		//Todas las empresas que quedaron, cumplen todas las condiciones taxativas. Las agrego a la lista linkeada para luego ordenar x prioridad
		
		listaOrdenada.addAll(empresas);
		
		//Les aplico las comparaciones basadas en las condiciones no taxativas para ordenarlas
		
		try {
			this.ordenarEmpresas();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return listaOrdenada;
		
	}
	
	public void combinarCondiciones(){
		cCombinadas.forEach(condCombinada->{
			cTaxativas.addAll(condCombinada.getCondicionesTaxativas());
		});
		cCombinadas.forEach(condCombinada->{
			cNoTaxativas.addAll(condCombinada.getCondicionesNoTaxativas());
		});
	}
	
	public Boolean cumpleCondicionesTaxativas(Empresa unaEmpresa) throws IOException{
		
		
		for(CondicionTaxativa unaCondicion:cTaxativas){
			if(!unaCondicion.empresaCalifica(unaEmpresa))return false;
		}	
		return true;
	}
	
	
	public void ordenarEmpresas() throws IOException{
	
		int n = listaOrdenada.size();
		for(int i=0;i<n;i++){
			for(int j=1;j<(n-1);j++){
				Empresa empresa1 = listaOrdenada.get(j-1);Empresa empresa2=listaOrdenada.get(j);
				if(!this.empresaConMayorPrioridadQue(empresa1,empresa2)){
					listaOrdenada.add(j, empresa1);
					listaOrdenada.add((j-1), empresa2);
				}
			}
		}	
	}
	
	
	
	public Boolean empresaConMayorPrioridadQue(Empresa empresa1, Empresa empresa2) throws IOException{
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
		for(CondicionCombinada unaCombinada:cCombinadas){
			cCombinadas.add(unaCombinada);
		}
		
	}
	
}
