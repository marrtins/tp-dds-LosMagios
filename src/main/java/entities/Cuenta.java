package entities;

import javax.persistence.*;

@Entity
@Table(name ="Cuenta")
public class Cuenta  {
	
	@Id
	@GeneratedValue
	private int idCuenta;
	
	private String nombreCuenta;
	private int valorCuenta;
	
	
	
	
	public String getNombreCuenta() {
		return nombreCuenta;
	}
	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}
	public int getValorCuenta() {
		return valorCuenta;
	}
	public void setValorCuenta(int valorCuenta) {
		this.valorCuenta = valorCuenta;
	}
	public void setear(String _nombre,int _valor){
		
		this.nombreCuenta = _nombre;
		this.valorCuenta = _valor;
	}
	
	
		
	
}
