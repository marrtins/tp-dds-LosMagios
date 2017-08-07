package analisisMetodologico;


import java.util.ArrayList;

import modelo.Empresa;
import modelo.Indicador;

public class Consistence extends OperadorTaxativo {

	@Override
	public Boolean analizarEmpresaTaxativa(Empresa unaEmpresa, Indicador unIndicador, int anios) {
		
		if(!unaEmpresa.tieneIndicadorEnUltimosAnios(unIndicador, anios))return false;
		
		ArrayList<Double> valoresIndicador = unaEmpresa.getValoresIndicadorEn( unIndicador, anios);		
		return esConsistente(valoresIndicador);
		
	}
	
	public Boolean esConsistente(ArrayList<Double> valores){
		
		Double v1,v2;int i;
		for(i=0;i<valores.size()-1;i++){
			v1=valores.get(i);v2=valores.get(i+1);
			if(this.getDelta(v1, v2)>10)return false;
		}
		return true;
		
		
	}

}
