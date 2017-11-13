package analisisMetodologico;



import java.io.IOException;
import java.util.ArrayList;

import entities.Empresa;
import entities.Indicador;

public abstract class OperadorTaxativo{

	
	
	
	public Float getDelta(Double v1,Double v2){
		Double dif =Math.abs(v2-v1);
		return (float) ((dif/v1)*100);
		
	}

	public abstract Boolean analizarEmpresaTaxativamente(Empresa unaEmpresa, Indicador unIndicador, String periodoSeleccionado, Double valorComparativo) throws IOException;
	
	public  Double sumatoria(ArrayList<Double> m){
		double sum = 0;
		for(Double d : m)
			sum += d;
		return sum;
	}

	
	
	

	

}
