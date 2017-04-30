package bddPeriodos;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractListModel;

import bddEmpresa.RepositorioDeEmpresas;
import clases.Cuenta;
import clases.Empresa;
import clases.Periodo;



public class CustomListModelPeriodo extends AbstractListModel {

	
	private ArrayList <Periodo> periodos = new ArrayList<>();
	
	
	
	
	@Override
    public int getSize() {
        return periodos.size();
        
	}
 
    @Override
    public Object getElementAt(int index) {
    	Periodo unPeriodo = periodos.get(index);
        return unPeriodo.getAnio();
    }
    
    public void setPeriodos(ArrayList<Periodo> unaLista){
    	periodos = unaLista;
    }
           
    public ArrayList<Periodo> getPeriodos(){
    	return periodos;
    }
    
    /*public void addCuenta(Cuenta unaCuenta){
    	cuentas.add(unaCuenta);
        this.fireIntervalAdded(this, getSize(), getSize()+1);
    }
    public void eliminarPersona(int index0){
        cuentas.remove(index0);
        this.fireIntervalRemoved(index0, getSize(), getSize()+1);
    }
    public Cuenta getCuenta(int index){
        return cuentas.get(index);
    }*/
	
    

}
