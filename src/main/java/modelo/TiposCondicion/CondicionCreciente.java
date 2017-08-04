package modelo.TiposCondicion;

import java.io.IOException;
import java.util.ArrayList;

import modelo.Empresa;
import modelo.Indicador;
import modelo.TipoCondicion;

public class CondicionCreciente extends TipoCondicion {

	public CondicionCreciente(String formatoCondicion) {
		super(formatoCondicion);
		// TODO Auto-generated constructor stub
	}
	
	
	public ArrayList<Empresa> aplicar(ArrayList<Empresa> empresas){
		
		empresas.removeIf(unaEmpresa -> !unaEmpresa.antiguedadMayorA(10));
		return empresas;
		
	}
	
	

}
