package bddEmpresa;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractListModel;

import bddEmpresa.RepositorioDeEmpresas;
import clases.Cuenta;
import clases.Empresa;



public class CustomListModelEmpresa extends AbstractListModel {

	
	private ArrayList<Empresa> empresas = new ArrayList<>();
	
	
	
	
	@Override
    public int getSize() {
        return empresas.size();
        
	}
 
    @Override
    public Object getElementAt(int index) {
    	Empresa unaEmpresa = empresas.get(index);
        return unaEmpresa.getNombre();
    }
    
   
    public void setEmpresas(ArrayList<Empresa> unaLista){
    	empresas = unaLista;
    }
    
    public ArrayList<Empresa> getEmpresas(){
    	return empresas;
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
