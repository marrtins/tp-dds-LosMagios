package erroresVista;

public class NuevaCNTCheck {
	
	
	
	
public Boolean condicionValida(String operador,String indicador, String anios,String peso){
		
		
		if(anios.isEmpty())return false;
		if(peso.isEmpty())return false;		
		
		return true;
	}
	
	public String getNombreCondicion(String indicadorString,String operadorTax,int anios,int peso){
		String nombreCondicion="";
		
		if(indicadorString.equals("No aplica")){
			nombreCondicion=operadorTax+". Peso="+peso;
		}else{
			nombreCondicion=indicadorString+" "+operadorTax+ " en "+anios+" años. Peso="+peso;
		}
		
		
		
		
		
		return nombreCondicion;
		
		
	}
	
	
	
	
	
	

}
