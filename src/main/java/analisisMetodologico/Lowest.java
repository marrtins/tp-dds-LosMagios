package analisisMetodologico;



public class Lowest extends OperadorNoTaxativo{

	@Override
	public int aplicarOperador(Double prom1,Double prom2,int peso){
		
		if(prom1>prom2)return peso*(-1);
		if(prom1==prom2)return 0;
		
		return peso;
	}

	
	
}
