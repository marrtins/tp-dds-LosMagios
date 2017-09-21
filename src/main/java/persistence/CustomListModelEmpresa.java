package persistence;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

import entities.Empresa;



public class CustomListModelEmpresa extends AbstractListModel {

	
	private ArrayList<Empresa> empresas = new ArrayList<>();
	
	
	
	@Override
    public int getSize() {
        return empresas.size();
        
	}
 
    @Override
    public Object getElementAt(int index) {
    	Empresa unaEmpresa = empresas.get(index);
        return unaEmpresa.getNombreEmpresa();
    }
   
    public void setEmpresas(ArrayList<Empresa> unaLista){
    	empresas = unaLista;
    }
    
    
    
    public ArrayList<Empresa> getEmpresas(){
    	return empresas;
    }
    
   
  
    
    
	
    

}