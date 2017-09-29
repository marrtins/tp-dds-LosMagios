package entities;

public class Usuario {

	String nombre;
	int pass;
	
	public Usuario(String nombre,int pass) {
		super();
		this.nombre=nombre;
		this.pass=pass;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPass() {
		return pass;
	}

	public void setPass(int pass) {
		this.pass = pass;
	}
	
	
	
	
	

}
