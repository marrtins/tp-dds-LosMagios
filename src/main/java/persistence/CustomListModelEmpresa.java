package persistence;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

import entities.Empresa;



public class CustomListModelEmpresa extends AbstractListModel {

	
	private List<Empresa> empresas = new ArrayList<>();
	
	
	
	@Override
    public int getSize() {
        return empresas.size();
        
	}
 
    @Override
    public Object getElementAt(int index) {
    	Empresa unaEmpresa = empresas.get(index);
        return unaEmpresa.getNombreEmpresa();
    }
   
    public void setEmpresas(List<Empresa> unaLista){
    	empresas = unaLista;
    }
    
    
    
    public List<Empresa> getEmpresas(){
    	return empresas;
    }
    
   
  
    
    
	
    

}