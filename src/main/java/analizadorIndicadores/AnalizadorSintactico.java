package analizadorIndicadores;


import excepciones.ErrorConstantesEnIndicador;
import excepciones.ErrorLexico;

public class AnalizadorSintactico {
	
	
	
	
	public Boolean indicadorValido(String formula){
		
	
		char cadena[] = formula.toCharArray();
		
		for(int i=0;i<formula.length();i++){
			if(cadena[i] == '{'){
				while(cadena[i]!='}'){
					i++;
					if(i==formula.length() || this.esUnOperador(cadena[i])||cadena[i]=='{'){
						return false;
					}
				}			
			}
			else{
				if(!this.caracterValido(cadena[i])){
					Exception e = new Exception();
					try {
						throw new ErrorLexico(e);
					} catch (ErrorLexico e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					return false;
				}
			
			else{ 
				if(!Character.isDigit(cadena[i])){
					if(i +1 == formula.length() && cadena[i] ==')') return true;
					if(i == 0 && cadena[i] != '(' )return false;
					if(!Character.isDigit(cadena[i+1]) && cadena[i+1]!='{') return false;
					
				}
				
			}
			
		}
	
		
		
	}
		return true;
}
	
	public Boolean caracterValido(char caracter){
		
		return (Character.isDigit(caracter)||this.esUnOperador(caracter));
	}
	public Boolean esUnOperador(char caracter){
		return (caracter == '/'||caracter == '*'||caracter == '+'||caracter == '-'||caracter=='('||caracter==')'||caracter =='.');
	}
	
	public String parseInput(String formula) {
		
		int init = 0;
		int end = formula.length();
		String cte = "0";
		String anterior = formula;
		String palabra  ="";
		String ret="";
		for(int i=0;i<formula.length();i++){
			char cadena[] = formula.toCharArray();
			if(!Character.isDigit(cadena[i])) {
				if(!esUnOperador(cadena[i])) {
					ret=ret.concat("{");
					init =i;
					while(i<formula.length()&&!esUnOperador(cadena[i])) {
						i++;
					}
					palabra=formula.substring(init,i);
					ret=ret.concat(palabra);
					ret=ret.concat("}");
					i--;
				}else {
					palabra=formula.substring(i,i+1);
					ret=ret.concat(palabra);
				}
			}else {
				palabra=formula.substring(i,i+1);
				ret=ret.concat(palabra);
			}
		}
		return ret;
		
		/*char cadena[] = formula.toCharArray();
		String asd = "";
		char cte[] = asd.toCharArray()  ;
		char ret[]=asd.toCharArray();
		String formulaRet = null;
		int j=0,k=0;
		for(int i=0;i<formula.length();i++){
			if(!Character.isDigit(cadena[i])) {
				if(!esUnOperador(cadena[i])) {
					ret[j]+='{';
					//formulaRet.concat("{");
					while(i<formula.length()&&!esUnOperador(cadena[i])) {
						ret[j]+=cadena[i];
						i++;j++;
					}
					ret[j]='}';
					j++;
					
					
					//formulaRet.concat("}");
					formulaRet+=cadena[i];
				}else {
					ret[j]=cadena[i];
					j++;
					
				}
			}else {
				ret[j]=cadena[i];
				j++;
			}
			
		}
		
		return ret.toString();*/
	}
}