package model;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractListModel;

import modelo.Cuenta;
import modelo.Empresa;
import persistence.RepositorioDeEmpresas;



public class CustomListModelCuentas extends AbstractListModel {

	private ArrayList<Cuenta> cuentas = new ArrayList<>();
	
	//private ArrayList <Periodo> periodos = new ArrayList<>();
	
	
	
	
	@Override
    public int getSize() {
        return cuentas.size();
        
	}
 
    @Override
    public Object getElementAt(int index) {
    	Cuenta unaCuenta = cuentas.get(index);
        Object algo = unaCuenta.getNombreCuenta();
    	return algo;
    }
    
    public void setCuentas(ArrayList<Cuenta> unaLista){
    	cuentas = unaLista;
    }
    
    
    public ArrayList<Cuenta> getCuentas(){
    	return cuentas;
    }
    
    public void addCuenta(Cuenta unaCuenta){
    	cuentas.add(unaCuenta);
        this.fireIntervalAdded(this, getSize(), getSize()+1);
    }
    public void eliminarPersona(int index0){
        cuentas.remove(index0);
        this.fireIntervalRemoved(index0, getSize(), getSize()+1);
    }
    public Cuenta getCuenta(int index){
        return cuentas.get(index);
    }
	
    
    

}

