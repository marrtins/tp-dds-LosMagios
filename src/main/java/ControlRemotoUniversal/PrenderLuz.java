package ControlRemotoUniversal;

//este es uno de los ConcreteCommand 

public class PrenderLuz implements Command {
	private Luz luz;
	
	public PrenderLuz (Luz luz){// constructor
		this.luz = luz;
	}
	
	public void execute(){
		luz.prender();
	}
	
	public void deshacer(){
		luz.apagar();
	}
	

}
