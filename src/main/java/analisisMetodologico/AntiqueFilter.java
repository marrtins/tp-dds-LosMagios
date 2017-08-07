package analisisMetodologico;

import modelo.Empresa;
import modelo.Indicador;

public class AntiqueFilter extends OperadorTaxativo{

	
	
	String nombreOperador;

	@Override
	public Boolean analizarEmpresaTaxativa(Empresa unaEmpresa, Indicador unIndicador, int anios) {
		
		
		return unaEmpresa.antiguedadMayorA(anios);
	}
}
