package analisisMetodologico;

import java.io.IOException;
import java.util.ArrayList;

import entities.Empresa;
import entities.Indicador;

public class HigherThan extends OperadorTaxativo{
	
	Double valorComparacion;
	
	@Override
	public Boolean analizarEmpresaTaxativamente(Empresa unaEmpresa, Indicador unIndicador, String periodoSeleccionado,Double valorComparacion) throws IOException {
		if(!unaEmpresa.tieneIndicadorEnPeriodoSeleccionado(unIndicador, periodoSeleccionado))return false;

		Double valorIndicador = unaEmpresa.getValorIndicador( unIndicador,periodoSeleccionado);
		
		return valorIndicador > valorComparacion;
	}

}
