package analisisMetodologico;

import modelo.Empresa;
import modelo.Indicador;

public class AntiqueSort extends OperadorNoTaxativo{

	@Override
	public int aplicarOperador(Double prom1, Double prom2, int peso) {
		
		return 0;
	}
	
	@Override
	public int aplicarPesos(Empresa empresa1, Empresa empresa2,Indicador unIndicador,int anios,int peso){
		
		int antiguedad1=empresa1.getAntiguedad();
		int antiguedad2=empresa2.getAntiguedad();
		
		if(antiguedad1<antiguedad2) return peso*(-1);
		if(antiguedad1==antiguedad2) return 0;
		
		return peso;
		
	}

}
