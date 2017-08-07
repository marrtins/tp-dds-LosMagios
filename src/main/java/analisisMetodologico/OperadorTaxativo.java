package analisisMetodologico;



import modelo.Empresa;
import modelo.Indicador;

public abstract class OperadorTaxativo {

	
	public abstract Boolean analizarEmpresaTaxativa(Empresa unaEmpresa, Indicador unIndicador, int anios);
	
	public Float getDelta(Double v1,Double v2){
		Double dif =Math.abs(v2-v1);
		return (float) ((dif/v1)*100);
		
	}

	

}
