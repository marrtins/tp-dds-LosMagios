package analisisMetodologico;

public class OperadoresFactory {
	public OperadorTaxativo crearOperadorTaxativo(String nombre){

		OperadorTaxativo operadorReturn = null;
				
		switch (nombre) {
		case "consistence":
			operadorReturn= new Consistence();
			break;
		case "crescent":
			operadorReturn= new Crescent();
			break;
		case "antique":
			operadorReturn= new AntiqueFilter();
			break;
		case "lowerThan": 
			operadorReturn=new LowerThan();
			break;
		case "higherThan":
				operadorReturn=new HigherThan();
			break;
		default:
			break;
		}
		
			
		return operadorReturn;	

	}
	public OperadorNoTaxativo crearOperadorNoTaxativo(String nombre){

		OperadorNoTaxativo operadorReturn=null;
		switch(nombre){
		case "highest":
			operadorReturn= new Highest();
			break;
		case "lowest":
			operadorReturn= new Lowest();
			break;
		case "antique":
			operadorReturn= new AntiqueSort();
			break;
		default:
			break;
		}

		return operadorReturn;
	}
}
