package domain;

public class Pajaro {
	private int energia ; // atributo
	public Pajaro() {
		super();
		this.energia = 500;
		
	}
	
	
	
	
	//métodos
	public void volar () {
		this . energia = this . energia - 10 ;
	}
	public void comer () {
		this . energia = this . energia + 300 ;
	}




	public int getEnergia() {
		return energia;
	}
	
	
	
}

