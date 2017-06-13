package parser;

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
}
