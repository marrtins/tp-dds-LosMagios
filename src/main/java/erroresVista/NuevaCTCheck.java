package erroresVista;

public class NuevaCTCheck {

	
	
	
	public Boolean condicionValida(String operador,String indicador, String anios, String valorAComp){
		
		
		if(anios.isEmpty())return false;
		if(valorAComp.isEmpty())return false;		
		
		return true;
	}
	
	public String getNombreCondicion(String indicadorString,String operadorTax,int anios,Double valorComparar){
		
		String nombreCondicion="";
		
		
		if(!indicadorString.equals("No aplica")){
			if(valorComparar.equals(0.0)){
				nombreCondicion=indicadorString+" "+operadorTax+" en "+anios+" a�os";
			}else{
				nombreCondicion=indicadorString+" "+operadorTax+" "+valorComparar.toString()+" en "+anios+" a�os";
			}
		}else{
			nombreCondicion=operadorTax+" "+anios+" a�os";
		}
		return nombreCondicion;
		
		
	}
}
