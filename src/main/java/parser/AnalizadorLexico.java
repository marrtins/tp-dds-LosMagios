package parser;

import java.util.ArrayList;

import modelo.Cuenta;
import modelo.Empresa;
import modelo.Indicador;
import modelo.Periodo;

import persistence.DataCollector;

public class AnalizadorLexico {
	private ArrayList<Empresa> empresas = new ArrayList<>();
	ArrayList<Indicador> indicadores = new ArrayList<>();
	
	private Empresa empresaAplicada;
	private Periodo periodoAplicado;
	
	
	public String analizar(String formula,Empresa empresa,Periodo periodo){
		 
		DataCollector persistence = new DataCollector();
		empresas = persistence.cargarEmpresas();
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
				init = i;
				while(cadena[i]!='}'){
					i++;
				}
				end = i;
				cName=formula.substring(init+1,end);
				cte = getcNameValue(cName);
				anterior = formula.substring(0,init);
				siguiente = formula.substring(end+1,formula.length());
				formula=anterior.concat(cte);

				formula=formula.concat(siguiente);
				i=0;

			}
		}

		return formula;


	}	

	private String getcNameValue(String cons){

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
		//TODO:EXCEPCION!!
		return "-1";




	}

	private boolean esUnIndicador(String cons) {
		return indicadores.stream().anyMatch(unIndicador -> unIndicador.getNombreIndicador().equals(cons));

	}

	private boolean esUnaCuenta(String cons) {
		return periodoAplicado.contieneCuenta(cons);
	}
}
