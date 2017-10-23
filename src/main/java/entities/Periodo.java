package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import entities.Cuenta;

@Entity
@Table(name ="Periodo")
public class Periodo {
	
	@Id
	private int anio;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Cuenta> cuentas = new ArrayList<>();

	public Periodo(int unAnio) {
		anio = unAnio;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public ArrayList<Cuenta> getCuentas() {
		return (ArrayList<Cuenta>) cuentas;
	}

	public void setCuentas(ArrayList<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
	public void agregarCuenta(Cuenta unaCuenta){
		cuentas.add(unaCuenta);
	}
	public void setearCuentas(ArrayList<Cuenta>cuentas){
		for (int i = 0; i < cuentas.size(); i++) {
			this.agregarCuenta(cuentas.get(i));
		}
	}

	public Cuenta getCuenta(String nombreCuenta){
		for(int i=0;i<cuentas.size();i++){
			if(cuentas.get(i).getNombreCuenta().equals(nombreCuenta)){
				return cuentas.get(i);
			}
			
		}
		return null;
		
}
	
	
	public void agregarCuentas(ArrayList<Cuenta> cuentas) {
		this.setCuentas(cuentas);
	}

	public boolean contieneCuenta(String nombreCuenta){
		return cuentas.stream().anyMatch(unaCuenta -> unaCuenta.getNombreCuenta().equals(nombreCuenta));
	}
	
	public void modificarCuenta(String nombreCuenta,int nuevoValor){
		
		this.getCuenta(nombreCuenta).setValorCuenta(nuevoValor);
		
		
	}
	public void eliminarCuenta(String nombreCuenta){
		cuentas.remove(this.getCuenta(nombreCuenta));
	}
	
	
	
	
}
