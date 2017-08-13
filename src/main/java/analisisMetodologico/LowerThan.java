package analisisMetodologico;

import java.util.ArrayList;

import modelo.Empresa;
import modelo.Indicador;

public class LowerThan extends OperadorTaxativo{
	
	Double valorComparacion;
	
	public void setValorComparacion(Double valor){
		valorComparacion=valor;
	}
	
	
	@Override
	public Boolean analizarEmpresaTaxativamente(Empresa unaEmpresa, Indicador unIndicador, int anios,Double valorComparacion) {

		if(!unaEmpresa.tieneIndicadorEnUltimosAnios(unIndicador, anios))return false;

		ArrayList<Double> valoresIndicador = unaEmpresa.getValoresIndicadorEn( unIndicador, anios);
		
		return (sumatoria(valoresIndicador)/anios) < valorComparacion;
	}

}