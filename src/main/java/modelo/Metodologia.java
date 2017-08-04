package modelo;



import java.util.ArrayList;

public class Metodologia {

	private String nombreMetodologia;
	private ArrayList<Condicion> condiciones = new ArrayList<Condicion>();
	String descripcion;
	
	public Metodologia(String nombreMetodologia,ArrayList< Condicion> condiciones) {
		super();
		this.nombreMetodologia = nombreMetodologia;
		this.condiciones=condiciones;
	}
	public String getNombreMetodologia() {
		return nombreMetodologia;
	}
	public void setNombreMetodologia(String nombreMetodologia) {
		this.nombreMetodologia = nombreMetodologia;
	}
	public  ArrayList<Condicion> getCondiciones() {
		return condiciones;
	}
	public  void setCondiciones(ArrayList<Condicion> condicionesSet) {
		condiciones = condicionesSet;
	}
	public  void agregarNuevaCondicion(String nuevaFormula){
		Condicion nuevaCondicion = new Condicion(nuevaFormula);
		condiciones.add(nuevaCondicion);	
	}
	public String getDescripcion(){
		descripcion="";		
		condiciones.forEach((unaMetodologia)->{
			descripcion+= unaMetodologia.condicionFormateada()+'\n';
			});
		return descripcion;
	}
	
	
	
	
}
