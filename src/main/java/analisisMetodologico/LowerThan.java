package analisisMetodologico;

import java.io.IOException;
import java.util.ArrayList;

import entities.Empresa;
import entities.Indicador;

public class LowerThan extends OperadorTaxativo{
	
	Double valorComparacion;
	
	public void setValorComparacion(Double valor){
		valorComparacion=valor;
	}
	
	
	@Override
	public Boolean analizarEmpresaTaxativamente(Empresa unaEmpresa, Indicador unIndicador, String periodoSeleccionado,Double valorComparacion) throws IOException {
		
		if(!unaEmpresa.tieneIndicadorEnPeriodoSeleccionado(unIndicador, periodoSeleccionado))return false;

		Double valorIndicador = unaEmpresa.getValorIndicador( unIndicador,periodoSeleccionado);
		
		return valorIndicador < valorComparacion;
	}

}