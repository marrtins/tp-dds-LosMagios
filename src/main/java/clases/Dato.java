package clases;

public abstract class Dato {
	private int periodo;
	String nombre;
	private int valor;
	
	
	public int consultarValor(Periodo unPeriodo){
		return this.getValor();
	}
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}


	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
