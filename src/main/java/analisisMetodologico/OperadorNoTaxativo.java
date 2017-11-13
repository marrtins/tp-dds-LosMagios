package analisisMetodologico;

import java.io.IOException;
import java.util.ArrayList;

import entities.Empresa;
import entities.Indicador;

public abstract class OperadorNoTaxativo  {
	

	public abstract int aplicarOperador(Double prom1,Double prom2,int peso);
	
	public int aplicarPesos(Empresa empresa1, Empresa empresa2,Indicador unIndicador,String periodoSeleccionado,int peso) throws IOException{
		
		Double promedio1=this.calcularPromedio(empresa1, unIndicador, periodoSeleccionado);
		Double promedio2=this.calcularPromedio(empresa2, unIndicador, periodoSeleccionado);
			
		return aplicarOperador(promedio1,promedio2,peso);
	}

	
	public Double calcularPromedio(Empresa empresa,Indicador unIndicador,String periodoSeleccionado) throws IOException{
			
		Double valorEmpresa = empresa.getValorIndicadorEn(Integer.valueOf(periodoSeleccionado),unIndicador);
		
		return valorEmpresa;
	}


	
	public  Double sumatoria(ArrayList<Double> m){
		double sum = 0;
		for(Double d : m)
			sum += d;
		return sum;
	}

}
