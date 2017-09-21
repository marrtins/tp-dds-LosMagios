package analisisMetodologico;

import java.util.ArrayList;

import entities.Empresa;
import entities.Indicador;

public class HigherThan extends OperadorTaxativo{
	
	Double valorComparacion;
	
	@Override
	public Boolean analizarEmpresaTaxativamente(Empresa unaEmpresa, Indicador unIndicador, int anios,Double valorComparacion) {

		if(!unaEmpresa.tieneIndicadorEnUltimosAnios(unIndicador, anios))return false;

		ArrayList<Double> valoresIndicador = unaEmpresa.getValoresIndicadorEn( unIndicador, anios);
		
		return (sumatoria(valoresIndicador)/anios) > valorComparacion;
	}

}
