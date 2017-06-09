package parser;

import java.io.IOException;
import java.util.ArrayList;

import modelo.Empresa;
import persistence.DAOJsonEmpresa;
import persistence.DataCollector;
import persistence.RepositorioDeEmpresas;

public class ParserFormula {
	private ArrayList<Empresa> empresas = new ArrayList<>();
	ArrayList<Indicador> indicadores = new ArrayList<>();
	private RepositorioDeEmpresas repoEmpresas;	
	private DAOJsonEmpresa dao;

	
	
	public String parseF(String formula){
		 
		DataCollector persistence = new DataCollector();
		empresas = persistence.cargarEmpresas();
		indicadores = persistence.cargarIndicadores();
		
		
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
			cName=formula.substring(init,end);
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
		
		dao = new DAOJsonEmpresa();
		//TODO: Cambiar esto
		dao.setFilePath("C:\\Users\\martin\\Git\\3-LosMagios\\bd\\empresas.json");
		this.repoEmpresas = new RepositorioDeEmpresas(dao);
		try {
			empresas = repoEmpresas.getAllEmpresas();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();;
		}
		
		
		return "2";
	}
}
