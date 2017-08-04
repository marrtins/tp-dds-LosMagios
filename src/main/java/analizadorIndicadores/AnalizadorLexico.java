package analizadorIndicadores;

import java.util.ArrayList;

import excepciones.*;
import java.io.IOException;
import modelo.Cuenta;
import modelo.Empresa;
import modelo.Indicador;
import modelo.Periodo;

import persistence.DataCollector;

public class AnalizadorLexico {
	ArrayList<Indicador> indicadores = new ArrayList<>();
	
	private Empresa empresaAplicada;
	private Periodo periodoAplicado;
	
	
	public String analizar(String formula,Empresa empresa,Periodo periodo) throws IOException{
		 
		DataCollector persistence = new DataCollector();
		indicadores = persistence.cargarIndicadores();
		empresaAplicada = empresa;
		periodoAplicado=periodo;
		
		
		int init = 0;
		int end = formula.length();
		String cte = "0";
		String anterior = formula;
		String siguiente  ="";
		for(int i=0;i<formula.length();i++){
			char cadena[] = formula.toCharArray();
			String cName;
			if(cadena[i] =='{'){
				cName=getIndicatorS(formula,i);
				while(cadena[i]!='}') i++;
				end =i;
				try {
					cte = getcNameValue(cName);
				} catch (ErrorLexico e) {
					throw e;
				}
				anterior = formula.substring(0,init);
				siguiente = formula.substring(end+1,formula.length());
				formula=anterior.concat(cte);

				formula=formula.concat(siguiente);
				i=0;

			}
		}

		return formula;


	}	
	public String getIndicatorS(String formula, int pos){
		int init,end;
		char cadena[]=formula.toCharArray();
		init = pos;
		
		while(cadena[pos]!='}'){
			pos++;
		}
		end = pos;
		return formula.substring(init+1,end);		
	}
	private String getcNameValue(String cons) throws IOException{

		if(esUnaCuenta(cons)){
			Cuenta cuenta = periodoAplicado.getCuenta(cons);
			return Integer.toString(cuenta.getValorCuenta());
		}
		else if (esUnIndicador(cons)) {
			String formula="";
			for(int i=0;i<indicadores.size();i++){
				if(indicadores.get(i).getNombreIndicador().equals(cons)){
					formula = indicadores.get(i).getCalculoIndicador();
				}
			}
			return this.analizar(formula,empresaAplicada,periodoAplicado);
		}
		else {
			Exception e = new Exception();
			throw new ErrorConstantesEnIndicador(e);
		}




	}

	private boolean esUnIndicador(String cons) {
		return indicadores.stream().anyMatch(unIndicador -> unIndicador.getNombreIndicador().equals(cons));
	}
	private boolean esUnaCuenta(String cons) {
		return periodoAplicado.contieneCuenta(cons);
	}

	public String getMethS(String formula){
		int init,end;
		int pos=0;
		
		String metKey="";
		String off="";
		char cadena[]=formula.toCharArray();
			if(cadena[pos]=='#'){
				pos++;
				init=pos;
			while(cadena[pos]!='#'){
				pos++;
			}
			end=pos;
			pos++;
			metKey=formula.substring(init,end);
			}
		
			if(metKey.contains("Antique")){
				return metKey;	
			}
			
		off=getIndicatorS(formula, pos);
		
		if(isAnalysis(metKey)){
			return off+" --> "+metKey;
		}
		else{
			return "NOEEEEEEEXISTE";
		}
		
		//return 
		
	}
	
	private Boolean isAnalysis(String key){
		return key.contains("Consistent")||key.contains("Lowest")||key.contains("Highest")||key.contains("Crescent")||key.contains("Decrescent")||key.contains("Than");
	}
	
	
	private String years(String key){
		return key.substring(7, key.length());
	}






}
