package entities;

import javax.persistence.*;

@Entity
@Table(name ="Usuario")
public class Usuario {

	
	//@GeneratedValue
	//int idUsuario;
	
	@Id
	String nombreUsuario;
	String pass;
	
	//AGREGAR METODOLOGIAS E INDICADORES

	public Usuario(/*String nombre,String pass*/) {
		super();
//		this.nombreUsuario=nombre;
//		this.pass=pass;
	}

	public String getNombre() {
		return nombreUsuario;
	}

	public void setNombre(String nombre) {
		this.nombreUsuario = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	
	

}
