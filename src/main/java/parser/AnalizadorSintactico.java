package parser;


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
					return false;
				}
			}
			
		}
		
		
		
		return true;
	}
	
	public Boolean caracterValido(char caracter){
		
		return (Character.isDigit(caracter)||this.esUnOperador(caracter));
	}
	public Boolean esUnOperador(char caracter){
		return (caracter == '/'||caracter == '*'||caracter == '+'||caracter == '-'||caracter=='('||caracter==')');
	}
}
