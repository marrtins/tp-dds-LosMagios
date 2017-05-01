package bddPeriodos;

import java.io.IOException;
import java.util.ArrayList;

import clases.Cuenta;
import clases.Periodo;

public class RepositorioDePeriodos {
	
	private DAOPeriodo daoPeriodo;
	
	public RepositorioDePeriodos(DAOPeriodo dao){
		this.daoPeriodo = dao;
	}
	
	public void add(Periodo periodo) throws IOException{
		this.daoPeriodo.add(periodo);
	}
	
	public void delete(Periodo periodo) throws IOException{
		this.daoPeriodo.delete(periodo);
	}
	
	public ArrayList<Periodo> getAllPeriodos() throws IOException{
		return this.daoPeriodo.getAllPeriodos();
	}
	
	public void update(Periodo periodo) throws IOException{
		this.daoPeriodo.update(periodo);
	}
	
}
