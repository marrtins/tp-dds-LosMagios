package analisisMetodologico;



import java.util.ArrayList;

import modelo.Empresa;
import modelo.Indicador;

public abstract class OperadorTaxativo{

	
	
	
	public Float getDelta(Double v1,Double v2){
		Double dif =Math.abs(v2-v1);
		return (float) ((dif/v1)*100);
		
	}

	public abstract Boolean analizarEmpresaTaxativamente(Empresa unaEmpresa, Indicador unIndicador, int anios, Double valorComparativo);
	
	public  Double sumatoria(ArrayList<Double> m){
		double sum = 0;
		for(Double d : m)
			sum += d;
		return sum;
	}

	
	
	

	

}
