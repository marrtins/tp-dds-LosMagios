package ControlRemotoUniversal;

//este es uno de los ConcreteCommand 

public class ApagarLuz implements Command {
	private Luz luz;
	
	public ApagarLuz(Luz luz){// constructor
		this.luz = luz;
	}
	
	public void execute(){
		luz.apagar();
	}
	
	public void deshacer(){
		luz.prender();
	}

}
