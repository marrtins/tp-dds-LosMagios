package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name ="Usuario")
public class Usuario {

	
	//@GeneratedValue
	//int idUsuario;
	
	@Id
	String nombreUsuario;
	String pass;
	
//	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//	private List<Indicador> indicadores = new ArrayList<>();
//	
//	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//	private List<Metodologia> metodologias = new ArrayList<>();
	
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
