package ControlRemotoUniversal;

//este es uno de los ConcreteCommand 

public class CerrarGarage implements Command {
	private Garage garage;
	
	public CerrarGarage(Garage garage){ // constructor
		this.garage = garage;
	}
	
	public void execute(){
		garage.bajar();
	}
	
	public void deshacer(){
		garage.subir();
	}

}
