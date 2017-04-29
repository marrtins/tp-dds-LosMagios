package clases;

import clases.Periodo;

public class Cuenta extends Dato {
	Empresa empresaAsociada = new Empresa(nombre, null);
	
	
	public Cuenta(Empresa unaEmpresaAsociada, int unValor,Periodo unPeriodo, String unNombre) {
		super();
		this.setNombre(unNombre);
		this.empresaAsociada = unaEmpresaAsociada;
		this.setValor(unValor);
		unPeriodo.agregarCuenta(this);
		
	}
	
	@Override
	public int consultarValor(Periodo unPeriodo){
		return unPeriodo.valorCuenta(this);
	}
	
	
	
	//GETTERS & SETTERS
	
	public Empresa getEmpresaAsociada() {
		return empresaAsociada;
	}
	public void setEmpresaAsociada(Empresa empresaAsociada) {
		this.empresaAsociada = empresaAsociada;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
