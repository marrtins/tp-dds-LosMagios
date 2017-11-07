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
	
//	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@Transient
	private List<Cuenta> cuentas = new ArrayList<>();

	public Periodo(/*int unAnio*/) {
//		anio = unAnio;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
	public void agregarCuenta(Cuenta unaCuenta){
		cuentas.add(unaCuenta);
	}
	public void setearCuentas(List<Cuenta>cuentas){
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
	
	
	public void agregarCuentas(List<Cuenta> cuentas) {
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
