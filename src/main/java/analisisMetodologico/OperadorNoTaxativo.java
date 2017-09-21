package analisisMetodologico;

import java.util.ArrayList;

import entities.Empresa;
import entities.Indicador;

public abstract class OperadorNoTaxativo  {
	

	public abstract int aplicarOperador(Double prom1,Double prom2,int peso);
	
	public int aplicarPesos(Empresa empresa1, Empresa empresa2,Indicador unIndicador,int anios,int peso){
		
		Double promedio1=this.calcularPromedio(empresa1, unIndicador, anios);
		Double promedio2=this.calcularPromedio(empresa2, unIndicador, anios);
			
		return aplicarOperador(promedio1,promedio2,peso);
	}

	
	public Double calcularPromedio(Empresa empresa,Indicador unIndicador,int anios){
			
		ArrayList<Double> valoresEmpresa = empresa.getValoresIndicadorEn(unIndicador, anios);
		
		return this.sumatoria(valoresEmpresa)/anios;
	}


	
	public  Double sumatoria(ArrayList<Double> m){
		double sum = 0;
		for(Double d : m)
			sum += d;
		return sum;
	}

}
