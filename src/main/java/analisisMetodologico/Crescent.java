package analisisMetodologico;

import java.util.ArrayList;

import modelo.Empresa;
import modelo.Indicador;

public class Crescent extends OperadorTaxativo{

	@Override
	public Boolean analizarEmpresaTaxativa(Empresa unaEmpresa, Indicador unIndicador, int anios) {

		if(!unaEmpresa.tieneIndicadorEnUltimosAnios(unIndicador, anios))return false;

		ArrayList<Double> valoresIndicador = unaEmpresa.getValoresIndicadorEn( unIndicador, anios);
		
		return esCreciente(valoresIndicador);
		

	}
	
	public Boolean esCreciente(ArrayList<Double> valores){	
		int i;
		for(i=0;i<valores.size()-1;i++){
			if(valores.get(i)>valores.get(i+1)) return false;
		}
		return true;
	}

}
