package analisisMetodologico;

import modelo.Empresa;
import modelo.Indicador;

public class AntiqueFilter extends OperadorTaxativo{

	
	
	String nombreOperador;

	@Override
	public Boolean analizarEmpresaTaxativamente(Empresa unaEmpresa, Indicador unIndicador, int anios,Double valorComparacion) {
		
		
		return unaEmpresa.antiguedadMayorA(anios);
	}

	
}
