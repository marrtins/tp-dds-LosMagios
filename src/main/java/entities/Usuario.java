package entities;

import javax.persistence.*;

@Entity
@Table(name ="Usuario")
public class Usuario {

	@Id
	@GeneratedValue
	int idUsuario;
	
	String nombreUsuario;
	String pass;
	

	public Usuario(String nombre,String pass) {
		super();
		this.nombreUsuario=nombre;
		this.pass=pass;
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
